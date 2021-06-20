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

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final LecturePathRepository lecturePathRepository;

    @GetMapping(value = "/users")
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.mapToUserDtoList(users);
    }

    @GetMapping(value = "/users/{userId}")
    public User getUser(@PathVariable Long userId) throws UserNotFoundException {
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    @GetMapping(value = "/user/{userId}/reservation")
    public UserDto getUserReservation(@PathVariable Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return userMapper.mapToUserDto(user);
    }

    @PostMapping(value = "/user")
    public void createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userRepository.save(user);
    }

    @PostMapping(value = "user/{userId}/lecture/{name}/reservation")
    public void createReservation(@PathVariable Long userId, String title) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        LecturePath lecturePath = lecturePathRepository.findByTitle(title);
        List<Reservation> reservations = lecturePath.getReservation();
        if (reservations.size() > 5) {
            System.out.println("There are no more places on this lecture path");
        } else {
            Reservation reservation = new Reservation(user, lecturePath);
            reservations.add(reservation);
        }
    }

    @PutMapping(value = "/user")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
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
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        LecturePath lecturePath = lecturePathRepository.findByTitle(title);
        List<Reservation> reservations = lecturePath.getReservation();
        reservations.stream()
                .filter(e->e.getUser().getId().equals(userId))
                .findFirst()
                .ifPresent(reservations::remove);
    }

}



