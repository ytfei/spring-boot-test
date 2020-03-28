package work.lemoon.demo.springboottest.service;

import work.lemoon.demo.springboottest.service.dto.User;

public interface UserService {
    int countUser();

    int addUser(User user);
}
