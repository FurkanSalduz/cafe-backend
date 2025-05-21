package com.cafe.menu.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Local ortam"),
                        new Server().url("https://api.cafe.com").description("Production ortam")
                ))
                .info(new Info()
                        .title("Cafe Menü API")
                        .description("Bu API, cafe menüsünü yönetmek için kullanılır.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Furkan Salduz")
                                .email("furkansalduz@example.com")
                                .url("https://github.com/furkansalduz")
                        )
                );
    }
}
