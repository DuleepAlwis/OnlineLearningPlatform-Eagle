package com.olp.eagle;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CorsFilterConfig> corsFilter() {
        FilterRegistrationBean<CorsFilterConfig> registrationBean =
                new FilterRegistrationBean<>(new CorsFilterConfig());
        registrationBean.setOrder(0);
        return registrationBean;
    }
}