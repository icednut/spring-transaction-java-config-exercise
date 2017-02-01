package io.icednut.exercise.api.support;

import io.icednut.exercise.infra.entity.User;
import io.icednut.exercise.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-01-24
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUsers() {
        List<User> users = userRepository.findAll();
        User user = users.get(0);

        user.setUsername("Kim");
        return toUserResponse(users);
    }

    private UserResponse toUserResponse(List<User> users) {
        UserResponse response = new UserResponse();

        response.setUsers(users.stream()
                               .map(user -> new UserDto(user.getUsername(), user.getAge()))
                               .collect(Collectors.toList()));
        return response;
    }
}
