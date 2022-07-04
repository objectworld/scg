package org.objectworld.backend;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

  @Bean
  public GroupedOpenApi openApi() {
    String[] paths = {"/**"};
    return GroupedOpenApi.builder().group("api-group").pathsToMatch(paths).build();
  }

  @Bean
  public OpenAPI springShopOpenAPI() {
      return new OpenAPI()
              .info(new Info().title("")
              .description("")
              .version("")
              .license(new License().name("").url("")))
              .externalDocs(new ExternalDocumentation()
              .description("")
              .url(""));
  }  
}