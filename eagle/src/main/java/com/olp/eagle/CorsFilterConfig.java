package com.olp.eagle;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

public class CorsFilterConfig extends CorsFilter {

    public CorsFilterConfig() {
        super(configurationSource());
    }

    private static UrlBasedCorsConfigurationSource configurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:3000"); // Replace with your React app's URL
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setExposedHeaders(List.of("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}