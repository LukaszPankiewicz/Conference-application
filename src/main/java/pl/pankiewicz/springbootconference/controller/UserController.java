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
import pl.pankiewicz.springbootconference.service.EmailSender;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final LecturePathRepository lecturePathRepository;
    private final EmailSender emailSender;

    @GetMapping(value = "/users")
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.mapToUserDtoList(users);
    }

    @GetMapping(value = "/users/{userId}")
    public UserDto getUser(@PathVariable Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return userMapper.mapToUserDto(user);
    }


    @PostMapping(value = "/user")
    public void createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userRepository.save(user);
    }

    @PostMapping(value = "/users/{userId}/lecture/{title}/reservation")
    public void createReservation(@PathVariable Long userId, @PathVariable String title) throws UserNotFoundException, IOException {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        LecturePath lecturePath = lecturePathRepository.findByTitle(title);
        List<Reservation> reservations = lecturePath.getReservation();
        if (reservations.size() > 5) {
            System.out.println("There are no more places on this lecture path");
        } else {
            Reservation reservation = new Reservation(user, lecturePath);
            reservations.add(reservation);
            emailSender.sendEmail(user.getEmail());
        }
    }

    @PutMapping(value = "/user")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.mapToUserDto(savedUser);
    }

    @PutMapping(value = "/user/{userId}/updateEmail")
    public void updateEmail(@PathVariable Long userId, @RequestBody UserDto dto) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        user.setEmail(dto.getEmail());
        userRepository.save(user);
    }

    @DeleteMapping(value = "/user/{userId}/lecture/{title}/reservationCancel")
    public void reservationCancel(@PathVariable Long userId, @PathVariable String title) {
        LecturePath lecturePath = lecturePathRepository.findByTitle(title);
        List<Reservation> reservations = lecturePath.getReservation();
        reservations.stream()
                .filter(e -> e.getUser().getId().equals(userId))
                .findFirst()
                .ifPresent(reservations::remove);
    }

}



