package work.lemoon.demo.springboottest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import work.lemoon.demo.springboottest.mapper.User2Mapper;

/**
 * Tengfei Yang 3/29/20
 **/
@Component
public class UserDao {

    @Autowired
    private User2Mapper user2Mapper;

    public int countUser() {
        int i = user2Mapper.countUser();
        return i + 100;
    }
}
