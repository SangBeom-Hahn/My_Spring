package hello.core.singleton;

import hello.core.singleton.StatefulService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public StatefulService statefulService() {
        return new StatefulService();
    }
}
