package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Hooks;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
		Hooks.enableAutomaticContextPropagation();
        System.setProperty("reactor.netty.http.server.accessLogEnabled", "true");
        SpringApplication.run(DemoApplication.class, args);
    }

}
