package work.lemoon.demo.springboottest.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import work.lemoon.demo.springboottest.service.UserService;
import work.lemoon.demo.springboottest.service.dto.User;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/count")
    public String count() {
        return String.valueOf(userService.countUser());
    }

    @GetMapping("/add")
    public String add(@RequestParam("name") String name) {
        User u = new User();
        u.setName(name);

        int affect = userService.addUser(u);
        return String.valueOf(affect);
    }
}
