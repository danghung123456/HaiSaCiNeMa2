//package com.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebCorsConfig implements WebMvcConfigurer {
//	@Bean
//	public WebMvcConfigurer webConfigMVC() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//				.allowedOrigins("http://localhost:4200")
//				.allowedHeaders("*")
//				.allowedMethods("POST", "PUT","DELETE", "GET");
//			}
//
//		};
//
//	}
//}
