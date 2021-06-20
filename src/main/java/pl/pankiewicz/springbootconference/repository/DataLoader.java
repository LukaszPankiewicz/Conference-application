package pl.pankiewicz.springbootconference.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.pankiewicz.springbootconference.domain.Conference;
import pl.pankiewicz.springbootconference.domain.Lecture;
import pl.pankiewicz.springbootconference.domain.LecturePath;
import pl.pankiewicz.springbootconference.domain.User;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LecturePathRepository lecturePathRepository;

    @Autowired
    ConferenceRepository conferenceRepository;

    @Autowired
    LectureRepository lectureRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("user","test@test.com"));
        userRepository.save(new User("user1","test1@test.com"));
        userRepository.save(new User("user2","test2@test.com"));
        userRepository.save(new User("user3","test3@test.com"));
        userRepository.save(new User("user4","test4@test.com"));
        userRepository.save(new User("user5","test5@test.com"));
        userRepository.save(new User("user6","test6@test.com"));
        userRepository.save(new User("user7","test7@test.com"));
        userRepository.save(new User("user8","test8@test.com"));
        userRepository.save(new User("user9","test9@test.com"));
        userRepository.save(new User("user10","test10@test.com"));
        userRepository.save(new User("user11","test11@test.com"));
        userRepository.save(new User("user12","test12@test.com"));
        userRepository.save(new User("user13","test13@test.com"));
        userRepository.save(new User("user14","test14@test.com"));
        userRepository.save(new User("user15","test15test.com"));

        conferenceRepository.save(new Conference("Programming world"));

        lecturePathRepository.save(new LecturePath("Java"));
        lecturePathRepository.save(new LecturePath("Python"));
        lecturePathRepository.save(new LecturePath("JavaScript"));

        lectureRepository.save(new Lecture(LocalDate.of(2021,6,1)
                , LocalTime.of(10,0), LocalTime.of(11, 45), "Spring"));
        lectureRepository.save(new Lecture(LocalDate.of(2021,6,1)
                , LocalTime.of(10,0), LocalTime.of(11, 45), "Django"));
        lectureRepository.save(new Lecture(LocalDate.of(2021,6,1)
                , LocalTime.of(10,0), LocalTime.of(11, 45), "Angular"));
        lectureRepository.save(new Lecture(LocalDate.of(2021,6,1)
                , LocalTime.of(12,0), LocalTime.of(13, 45), "Hibernate"));
        lectureRepository.save(new Lecture(LocalDate.of(2021,6,1)
                , LocalTime.of(12,0), LocalTime.of(13, 45), "Web2py"));
        lectureRepository.save(new Lecture(LocalDate.of(2021,6,1)
                , LocalTime.of(12,0), LocalTime.of(13, 45), "React"));
        lectureRepository.save(new Lecture(LocalDate.of(2021,6,1)
                , LocalTime.of(14,0), LocalTime.of(15, 45), "Apache"));
        lectureRepository.save(new Lecture(LocalDate.of(2021,6,1)
                , LocalTime.of(14,0), LocalTime.of(15, 45), "TurboGears"));
        lectureRepository.save(new Lecture(LocalDate.of(2021,6,1)
                , LocalTime.of(14,0), LocalTime.of(15, 45), "Vue.js"));

    }
}
