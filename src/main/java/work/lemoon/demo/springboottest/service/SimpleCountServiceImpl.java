package work.lemoon.demo.springboottest.service;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SimpleCountServiceImpl implements CountingService {
    @Override
    public int count(Collection<?> collection) {
        if (collection == null)
            return 0;

        return collection.size();
    }
}
