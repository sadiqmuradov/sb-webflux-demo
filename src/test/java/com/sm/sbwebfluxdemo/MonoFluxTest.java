package com.sm.sbwebfluxdemo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<?> sm = Mono.just("sm")
                .then(Mono.error(new RuntimeException("Exception occurred")))
                .log();
        sm.subscribe(System.out::println, e -> System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux() {
        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "microservice")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occurred in Flux")))
                .concatWithValues("cloud")
                .log();
        fluxString.subscribe(System.out::println, e -> System.out.println(e.getMessage()));
    }
}
