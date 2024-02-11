package com.pinaki.MyBlogger.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;


@Configuration
public class SwagggerConfig {
	 @Value("${mybloger.openapi.dev-url}")
	  private String devUrl;

	  @Value("${mybloger.openapi.prod-url}")
	  private String prodUrl;

	  @Bean
	  public OpenAPI myOpenAPI() {
	    Server devServer = new Server();
	    devServer.setUrl(devUrl);
	    devServer.setDescription("Server URL in Development environment");

	    Server prodServer = new Server();
	    prodServer.setUrl(prodUrl);
	    prodServer.setDescription("Server URL in Production environment");

	    Contact contact = new Contact();
	    contact.setEmail("mybloger@gmail.com");
	    contact.setName("mybloger");
	    contact.setUrl("https://www.mybloger.com");

	    License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

	    Info info = new Info()
	        .title("MyBloger API")
	        .version("1.0")
	        .contact(contact)
	        .description("This API exposes endpoints to manage blogs.").termsOfService("https://www.mybloger.com/terms")
	        .license(mitLicense);

	    return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
	  }
}