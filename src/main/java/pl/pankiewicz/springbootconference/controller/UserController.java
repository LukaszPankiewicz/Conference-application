package pl.pankiewicz.springbootconference.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.pankiewicz.springbootconference.domain.User;
import pl.pankiewicz.springbootconference.domain.UserDto;
import pl.pankiewicz.springbootconference.service.DbService;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final DbService dbService;
    private final UserMapper userMapper;

    @GetMapping(value = "/users")
    public List<UserDto> getUsers() {
        List<User> users = dbService.getAllUsers();
        return userMapper.mapToUserDtoList(users);
    }

    @GetMapping(value = "/users/{userId}")
    public UserDto getUser(@PathVariable Long userId) throws UserNotFoundException {
        return userMapper.mapToUserDto(
                dbService.getUser(userId).orElseThrow(UserNotFoundException::new)
        );
    }

    @PostMapping(value = "/user")
    public void createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        dbService.saveUser(user);
    }

    @PutMapping(value = "/user")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User savedUser = dbService.saveUser(user);
        return userMapper.mapToUserDto(savedUser);
    }

    @DeleteMapping(value = "/user/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        dbService.deleteUser(userId);
    }
}



