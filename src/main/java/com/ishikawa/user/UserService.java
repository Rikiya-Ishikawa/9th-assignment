package com.ishikawa.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserMapper userMapper;
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public User findUser(int id) {
        Optional<User> user = this.userMapper.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("user_id : " + id + " not found");
        }

    }

    public User insert(String name, String email) {
        User user = new User(null, name, email);
        userMapper.insert(user);
        return user;
    }
}
