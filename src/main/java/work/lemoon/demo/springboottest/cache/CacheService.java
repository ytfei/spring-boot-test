package work.lemoon.demo.springboottest.cache;

/**
 * Tengfei Yang 3/29/20
 **/
public interface CacheService {
    String get(String key);

    void put(String key, String value);
}
