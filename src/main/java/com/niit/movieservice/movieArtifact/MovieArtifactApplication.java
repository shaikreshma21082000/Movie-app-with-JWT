package com.niit.movieservice.movieArtifact;

import com.niit.movieservice.movieArtifact.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieArtifactApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieArtifactApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		System.out.println("Inside jwt filter method");
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/api/v1/*");
		return filterRegistrationBean;
	}
}
