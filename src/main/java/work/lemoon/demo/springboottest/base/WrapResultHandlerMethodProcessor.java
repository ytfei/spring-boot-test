package work.lemoon.demo.springboottest.base;

import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.io.IOException;
import java.util.List;

/**
 * Tengfei Yang 4/1/20
 **/
public class WrapResultHandlerMethodProcessor extends RequestResponseBodyMethodProcessor {
    public WrapResultHandlerMethodProcessor(List<HttpMessageConverter<?>> converters) {
        super(converters);
    }

    public WrapResultHandlerMethodProcessor(final List<HttpMessageConverter<?>> messageConverters, final ContentNegotiationManager contentNegotiationManager) {
        super(messageConverters, contentNegotiationManager);
    }

    @Override
    public boolean supportsReturnType(final MethodParameter returnType) {
        return returnType.getMethodAnnotation(WrapResult.class) != null;
    }

    @Override
    public void handleReturnValue(final Object returnValue, final MethodParameter returnType, final ModelAndViewContainer mavContainer, final NativeWebRequest webRequest) throws IOException, HttpMediaTypeNotAcceptableException {
        super.handleReturnValue(Result.of(returnValue), returnType, mavContainer, webRequest);
    }
}
