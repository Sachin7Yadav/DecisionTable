//package com.demo.drool.DecisionTable.config;
//
//import com.demo.drool.DecisionTable.model.Request;
//import com.demo.drool.DecisionTable.service.DroolExecutionService;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Mono;
//
//import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
//import static org.springframework.web.reactive.function.server.RouterFunctions.route;
//import static org.springframework.web.reactive.function.server.ServerResponse.ok;
//
//@Component
//@RequiredArgsConstructor
//public class Routes {
//
//    private final DroolExecutionService droolExecutionService;
//
//    @Bean
//    public RouterFunction<ServerResponse> routerFunction() {
//        return route(POST("/executeRule"),
//                request -> request.bodyToMono(Request.class)
//                        .flatMap(r -> Mono.just(droolExecutionService.executeRule(r)))
//                        .map(response -> ok().body(BodyInserters.fromValue(response)).block()))
//                ;
//
//    }
//
//}
