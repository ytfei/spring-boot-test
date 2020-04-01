package work.lemoon.demo.springboottest.base;

import lombok.Data;

/**
 * Tengfei Yang 4/1/20
 **/
@Data
public class Result<T> {
    private String error;

    private int code;

    private T data;

    public Result() {
        this.error = null;
        this.code = 0;
        this.data = null;
    }

    public static <V> Result<V> of(V data) {
        Result<V> r = new Result<>();
        r.setData(data);

        return r;
    }

}
