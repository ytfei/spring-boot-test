package work.lemoon.demo.springboottest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import work.lemoon.demo.springboottest.base.WrapResultHandlerMethodProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Tengfei Yang 4/1/20
 **/
@EnableWebMvc
@Configuration
public class WebConfigure implements WebMvcConfigurer {

    // // FIXME: 4/1/20 因为加载顺序的原因，这里没有生效
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        handlers.add(0, new WrapResultHandlerMethodProcessor(messageConverters));
    }

}
