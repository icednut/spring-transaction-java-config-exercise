package io.icednut.exercise.api;

import io.icednut.exercise.api.support.UserResponse;
import io.icednut.exercise.api.support.UserService;
import io.icednut.exercise.api.support.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-01-24
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public UserResponse getUsers() {
        return userService.getUsers();
    }
}
