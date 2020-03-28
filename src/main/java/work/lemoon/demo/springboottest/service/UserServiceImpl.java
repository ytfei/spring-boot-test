package work.lemoon.demo.springboottest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.lemoon.demo.springboottest.mapper.UserMapper;
import work.lemoon.demo.springboottest.service.dto.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int countUser() {
        return userMapper.countUser() + 100;
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user) + 200;
    }
}
