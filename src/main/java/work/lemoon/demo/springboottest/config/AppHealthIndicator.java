package work.lemoon.demo.springboottest.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.AbstractReactiveHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * Tengfei Yang 4/15/20
 **/
@Slf4j
@Component
public class AppHealthIndicator extends AbstractReactiveHealthIndicator {
    @Override
    protected Mono<Health> doHealthCheck(Health.Builder builder) {
        log.info("check app health");
        return Mono.just(builder.up().build());
    }
}
