package work.lemoon.demo.springboottest.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("work.lemoon.demo.springboottest.mapper")
public class AppConfig {
}
