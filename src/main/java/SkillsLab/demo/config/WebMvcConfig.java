package SkillsLab.demo.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("localhost:4200")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
        .allowedHeaders("Content-Type", "Date", "Total-Count", "loginInfo", "Authorization")
        .allowCredentials(true);
    }
}
