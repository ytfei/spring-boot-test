package work.lemoon.demo.springboottest.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;

import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tengfei Yang 3/29/20
 **/
@DataRedisTest
@Import(CacheServiceImpl.class)
@ActiveProfiles("unittest")
class CacheServiceImplTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private CacheService cacheService;

    @Test
    public void testCache() {
        final String k = "key";
        final String v = "value";

        redisTemplate.opsForValue().set(k, v);
        assertEquals(v, redisTemplate.opsForValue().get(k));

        cacheService.put(k, v);
        assertEquals(v, cacheService.get(k));
    }

    @TestConfiguration
    static class TestCacheConfig {

        private RedisServer redisServer;

        public TestCacheConfig(@Value("${spring.redis.port}") int redisPort,
                               @Value("${spring.redis.host}") String redisHost) throws IOException {
            this.redisServer = new RedisServer(redisPort);
        }

        @PostConstruct
        public void postConstruct() {
            redisServer.start();
        }

        @PreDestroy
        public void preDestroy() {
            redisServer.stop();
        }
    }
}