package work.lemoon.demo.springboottest.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 包装返回的结果数据
 * <p>
 * Tengfei Yang 4/1/20
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WrapResult {
}
