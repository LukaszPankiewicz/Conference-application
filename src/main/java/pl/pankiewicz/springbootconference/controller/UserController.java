package pl.pankiewicz.springbootconference.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.pankiewicz.springbootconference.domain.UserDto;
import pl.pankiewicz.springbootconference.service.DbService;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final DbService dbService;


    @GetMapping(value = "/users")
    public void getUsers() {

    }

    @GetMapping(value = "/users/{userId}")
    public void getUser(@PathVariable Long userId) throws UserNotFoundException {


    }

    @PostMapping(value = "/user")
    public void createUser(@RequestBody UserDto userDto) {

    }

    @PutMapping(value = "/user")
    public void updateUser(@RequestBody UserDto userDto) {

    }

    @DeleteMapping(value = "/user/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        dbService.deleteUser(userId);
    }
}



