package com.example.requesttracing.config;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.WebFilter;

@Configuration(proxyBeanMethods = false)
public class TracerConfiguration {
    @Bean
    WebFilter traceIdAndSpanIdInResponseFilter(Tracer tracer) {
        return (exchange, chain) -> {
            Span currentSpan = tracer.currentSpan();
            if (currentSpan != null) {
                exchange.getResponse().getHeaders().add("traceId", currentSpan.context().traceId());
                exchange.getResponse().getHeaders().add("spanId", currentSpan.context().spanId());
            }
            return chain.filter(exchange);
        };
    }
}
