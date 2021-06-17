package pl.pankiewicz.springbootconference.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.pankiewicz.springbootconference.domain.LecturePath;
import pl.pankiewicz.springbootconference.domain.Reservation;
import pl.pankiewicz.springbootconference.domain.User;
import pl.pankiewicz.springbootconference.domain.UserDto;
import pl.pankiewicz.springbootconference.mapper.UserMapper;
import pl.pankiewicz.springbootconference.repository.LecturePathRepository;
import pl.pankiewicz.springbootconference.repository.UserRepository;
import pl.pankiewicz.springbootconference.service.DbService;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final DbService dbService;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final LecturePathRepository lecturePathRepository;

    @GetMapping(value = "/users")
    public List<UserDto> getUsers() {
        List<User> users = dbService.getAllUsers();
        return userMapper.mapToTaskDtoList(users);
    }

    @GetMapping(value = "/users/{userId}")
    public User getUser(@PathVariable Long userId) throws UserNotFoundException {
        return dbService.getUser(userId).orElseThrow(UserNotFoundException::new);
    }

    @GetMapping(value = "/user/{userId}/lectures")
    public User getUserLectures(@PathVariable Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        Reservation reservation = user.getReservation();
        LecturePath lecturePath = reservation.getLecturePath();
        return

        //metoda musi zwrócić wyżej wypisany lecturePath. Brak pomysłu

    }

    @PostMapping(value = "/user")
    public void createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        dbService.saveUser(user);
    }

    @PostMapping(value = "user/{userId}/lecture/{name}/reservation")
    public void createReservation(@PathVariable Long userId, String title) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        LecturePath lecturePath = lecturePathRepository.findByTitle(title);
        List<Reservation> reservations = lecturePath.getReservation();
        reservations.add(user) //błąd, niezgodność typów
    }

    @PutMapping(value = "/user")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User savedUser = dbService.saveUser(user);
        return userMapper.mapToUserDto(savedUser);

    }

    @PatchMapping(value = "/user/{userId}/updateEmail")
    public User updateEmail(@PathVariable Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        user.setEmail("");
        return user;
    }

    @DeleteMapping(value = "/user/{userId/lecture/{name}/reservationCancel")
    public void reservationCancel(@PathVariable Long userId, String title) throws UserNotFoundException {
        //dbService.deleteUser(userId);
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        LecturePath lecturePath = lecturePathRepository.findByTitle(title);
        List<Reservation> reservations = lecturePath.getReservation();
        reservations.remove(user); //niezgodność typów

    }
}



