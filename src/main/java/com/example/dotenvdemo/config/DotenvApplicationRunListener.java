package com.example.dotenvdemo.config;

import me.paulschwarz.springdotenv.DotenvConfig;
import me.paulschwarz.springdotenv.DotenvPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class DotenvApplicationRunListener implements SpringApplicationRunListener {
    private final SpringApplication application;

    private final String[] args;
    public DotenvApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }
    public void environmentPrepared(ConfigurableEnvironment environment) {
        DotenvPropertySource.addToEnvironment(environment);
    }
}
