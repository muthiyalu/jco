package org.jco.applications.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.Routes;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.cloud.gateway.handler.predicate.RoutePredicates.host;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
public class Tracks12GatewayService {
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        //@formatter:off
//        return builder.routes()
//                .route(r -> r.path("/")
//                        .addResponseHeader("X-AnotherHeader", "baz")
//                        .uri("http://localhost:8000")
//                ).route(r -> r.path("/auth")
//                        .addResponseHeader("X-AnotherHeader", "baz")
//                        .uri("http://royalseema.org:8080")
//        )
//
//                .build();
//        ////@formatter:on
//    }

    public static void main(String[] args) {
        SpringApplication.run(Tracks12GatewayService.class, args);
    }

}

