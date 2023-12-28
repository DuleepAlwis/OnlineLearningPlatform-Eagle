package com.olp.eagle;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all endpoints, customize as needed
                .allowedOrigins("http://localhost:3000") // Allow requests from any origin, restrict as needed
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
                .allowedHeaders("*") // Allow all headers, restrict based on your headers
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials") // Add this line
                .allowCredentials(true); // Enable credentials (if needed)
    }
}
