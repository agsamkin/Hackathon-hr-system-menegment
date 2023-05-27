package hackathon.ru.api;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class GoogleConfig {
    @Value("${google.clientId}")
    private String clientId;

    @Value("${google.redirect-url}")
    private String redirectUrl;
}
