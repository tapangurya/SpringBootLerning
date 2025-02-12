package com.example.secondProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class SecondProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondProjectApplication.class, args);
    }

    @Bean
    public ModelAndView modelAndView() {  // ✅ Use a meaningful method name (camelCase)
        return new ModelAndView();
    }
}
