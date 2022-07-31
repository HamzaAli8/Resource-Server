package hamzaali.springresourceserver.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http.oauth2ResourceServer(

                c -> c.opaqueToken(

                        t -> {
                            t.introspectionUri("http://localhost:8080/oauth/check_token");
                            t.introspectionClientCredentials("client", "secret");
                        }
                )

        );

        http.authorizeRequests().antMatchers("/public").permitAll()
                .antMatchers("/private").authenticated();

        http.csrf().disable();

        return http.build();
    }

}

