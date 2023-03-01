package com.example.demo;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private final MyFilter myFilter;

    public Config(MyFilter myFilter) {
        this.myFilter = myFilter;
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("r1", r ->
                r.path("/anything")
                    .filters(f -> f.filters(myFilter))
                    .uri("https://httpbin.org/anything")
            )
            .build();
    }

}
