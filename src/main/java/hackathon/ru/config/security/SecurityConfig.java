package hackathon.ru.config.security;


import hackathon.ru.config.component.JWTHelper;
import hackathon.ru.config.filter.JWTAuthenticationFilter;
import hackathon.ru.config.filter.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static hackathon.ru.controller.CityController.CITIES_CONTROLLER_PATH;
import static hackathon.ru.controller.application.ApplicationController.APPLICATION_CONTROLLER_PATH;
import static hackathon.ru.controller.application.ApplicationStatusController.APPLICATION_STATUS_CONTROLLER_PATH;
import static hackathon.ru.controller.calendar.GoogleOAuth2Controller.GOOGLE_OAUTH2_CONTROLLER_PATH;
import static hackathon.ru.controller.candidate.DegreeController.DEGREE_CONTROLLER_PATH;
import static hackathon.ru.controller.userController.UserController.ID;
import static hackathon.ru.controller.userController.UserController.USER_CONTROLLER_PATH;
import static hackathon.ru.controller.vacancy.VacancyController.VACANCY_CONTROLLER_PATH;
import static hackathon.ru.controller.vacancy.dictionaries.RequiredExperienceController.REQUIRED_EXPERIENCE_CONTROLLER_PATH;
import static hackathon.ru.controller.vacancy.dictionaries.VacancyStatusController.VACANCY_STATUS_CONTROLLER_PATH;
import static hackathon.ru.controller.vacancy.dictionaries.WorkFormatController.WORK_FORMAT_CONTROLLER_PATH;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String LOGIN = "/login";

    public static final List<GrantedAuthority> DEFAULT_AUTHORITIES = List.of(new SimpleGrantedAuthority("USER"));

    //Note: Сейчас разрешены:
    // - GET('/api/users')
    // - POST('/api/users')
    // - POST('/api/login')
    // - все запросы НЕ начинающиеся на '/api'
    private final RequestMatcher publicUrls;
    private final RequestMatcher loginRequest;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JWTHelper jwtHelper;

    public SecurityConfig(@Value("${base-url}") final String baseUrl,
                          final UserDetailsService userDetailsService,
                          final PasswordEncoder passwordEncoder,
                          final JWTHelper jwtHelper) {
        this.loginRequest = new AntPathRequestMatcher(baseUrl + LOGIN, POST.toString());
        this.publicUrls = new OrRequestMatcher(
                loginRequest,
                new AntPathRequestMatcher(baseUrl + USER_CONTROLLER_PATH, POST.toString()),
                new AntPathRequestMatcher(baseUrl + USER_CONTROLLER_PATH, GET.toString()),

                new AntPathRequestMatcher(baseUrl + CITIES_CONTROLLER_PATH + "/**", GET.toString()),
                new AntPathRequestMatcher(baseUrl + DEGREE_CONTROLLER_PATH + "/**", GET.toString()),
                new AntPathRequestMatcher(baseUrl + REQUIRED_EXPERIENCE_CONTROLLER_PATH+ "/**", GET.toString()),
                new AntPathRequestMatcher(baseUrl + VACANCY_STATUS_CONTROLLER_PATH + "/**", GET.toString()),
                new AntPathRequestMatcher(baseUrl + WORK_FORMAT_CONTROLLER_PATH + "/**", GET.toString()),
                new AntPathRequestMatcher(baseUrl + APPLICATION_STATUS_CONTROLLER_PATH + "/**", GET.toString()),
                new AntPathRequestMatcher(baseUrl + GOOGLE_OAUTH2_CONTROLLER_PATH + "/**"),
                new AntPathRequestMatcher(baseUrl + APPLICATION_CONTROLLER_PATH + "/**"),
                new AntPathRequestMatcher(baseUrl + APPLICATION_CONTROLLER_PATH + ID, GET.toString()),
                new AntPathRequestMatcher(baseUrl + APPLICATION_CONTROLLER_PATH, POST.toString()),

                new AntPathRequestMatcher(baseUrl + VACANCY_CONTROLLER_PATH, GET.toString()),
                new AntPathRequestMatcher(baseUrl + VACANCY_CONTROLLER_PATH + ID, GET.toString()),


                new NegatedRequestMatcher(new AntPathRequestMatcher(baseUrl + "/**"))
        );
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtHelper = jwtHelper;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {

        final var authenticationFilter = new JWTAuthenticationFilter(
                authenticationManagerBean(),
                loginRequest,
                jwtHelper
        );

        final var authorizationFilter = new JWTAuthorizationFilter(
                publicUrls,
                jwtHelper
        );

        http.csrf().disable()
                .cors()
                .and()
                .authorizeRequests()
                .requestMatchers(publicUrls).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(authenticationFilter)
                .addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .logout().disable();

        http.headers().frameOptions().disable();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}


//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    public static final String LOGIN = "/login";
//
//    public static final List<GrantedAuthority> DEFAULT_AUTHORITIES
//            = List.of(new SimpleGrantedAuthority("USER"));
//
//    private final RequestMatcher publicUrls;
//
//    private final RequestMatcher loginRequest;
//
//    private final UserDetailsService userDetailsService;
//
//    private final PasswordEncoder passwordEncoder;
//
//    private final JWTHelper jwtHelper;
//
//
//    public SecurityConfig(@Value("${base-url}") final String baseUrl,
//                          final UserDetailsService userDetailsService,
//                          final PasswordEncoder passwordEncoder,
//                          final JWTHelper jwtHelper) {
//
//        this.loginRequest = new AntPathRequestMatcher(baseUrl + LOGIN, POST.toString());
//        this.publicUrls = new OrRequestMatcher(
//                loginRequest,
//                new AntPathRequestMatcher(baseUrl + USER_CONTROLLER_PATH, POST.toString()),
//                new AntPathRequestMatcher(baseUrl + USER_CONTROLLER_PATH, GET.toString()),
//                new AntPathRequestMatcher(baseUrl + CITIES_CONTROLLER_PATH + "/**", GET.toString()),
//                new AntPathRequestMatcher(baseUrl + DEGREE_CONTROLLER_PATH + "/**", GET.toString()),
//                new AntPathRequestMatcher(baseUrl + REQUIRED_EXPERIENCE_CONTROLLER_PATH+ "/**", GET.toString()),
//                new AntPathRequestMatcher(baseUrl + VACANCY_STATUS_CONTROLLER_PATH + "/**", GET.toString()),
//                new AntPathRequestMatcher(baseUrl + WORK_FORMAT_CONTROLLER_PATH + "/**", GET.toString()),
//                new AntPathRequestMatcher(baseUrl + APPLICATION_CONTROLLER_PATH + "**", GET.toString()),
//                new AntPathRequestMatcher(baseUrl + APPLICATION_CONTROLLER_PATH + "**", POST.toString()),
//                new AntPathRequestMatcher(baseUrl + VACANCY_CONTROLLER_PATH, GET.toString()),
//                new AntPathRequestMatcher(baseUrl + VACANCY_CONTROLLER_PATH + ID, GET.toString()),
//
//                new NegatedRequestMatcher(new AntPathRequestMatcher(baseUrl + "/**"))
//        );
//
//        this.userDetailsService = userDetailsService;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtHelper = jwtHelper;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        final var authenticationFilter = new JWTAuthenticationFilter(
//                authenticationManagerBean(), loginRequest, jwtHelper);
//
//        final var authorizationFilter = new JWTAuthorizationFilter(
//                publicUrls,
//                jwtHelper
//        );
//
//        http.csrf().disable()
//                .cors()
//                .and()
//                .authorizeRequests()
//                .requestMatchers(publicUrls).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(authenticationFilter)
//                .addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
//                .sessionManagement().disable()
//                .formLogin().disable()
//                .httpBasic().disable()
//                .logout().disable()
//                .headers().frameOptions().disable();
//    }
//
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//        return source;
//    }
//}
