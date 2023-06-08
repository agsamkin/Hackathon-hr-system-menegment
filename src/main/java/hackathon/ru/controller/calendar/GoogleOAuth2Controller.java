package hackathon.ru.controller.calendar;

import com.google.api.client.googleapis.auth.oauth2.GoogleBrowserClientRequestUrl;
import com.google.api.services.calendar.CalendarScopes;
import hackathon.ru.api.GoogleConfig;
import hackathon.ru.data.dto.calendar.TokenDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("${base-url}" + GoogleOAuth2Controller.GOOGLE_OAUTH2_CONTROLLER_PATH)
@RestController
public class GoogleOAuth2Controller {
    public static final String GOOGLE_OAUTH2_CONTROLLER_PATH = "/oauth2";

    private final GoogleConfig googleConfig;

    @GetMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> scopes =
                Collections.singletonList(CalendarScopes.CALENDAR);

        String url = new GoogleBrowserClientRequestUrl(googleConfig.getClientId(), googleConfig.getRedirectUrl(),
                Arrays.asList(
                        "https://www.googleapis.com/auth/userinfo.email",
                        "https://www.googleapis.com/auth/userinfo.profile"))
                .setState("/profile").setScopes(scopes).build();

        response.sendRedirect(url);
    }

    @GetMapping("/callback")
    public void callback() {
        log.info("Google callback received!");
    }
    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @GetMapping("/realcallback")
    public void realcallback(@RequestBody TokenDto tokenDto) {
        log.info("Application callback received!");
    }
}
