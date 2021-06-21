package pl.pankiewicz.springbootconference.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pankiewicz.springbootconference.domain.Conference;
import pl.pankiewicz.springbootconference.domain.ConferenceDto;
import pl.pankiewicz.springbootconference.domain.Lecture;
import pl.pankiewicz.springbootconference.domain.LecturePath;
import pl.pankiewicz.springbootconference.repository.ConferenceRepository;

import java.util.List;

@RestController
@RequestMapping("/v1/conference")
@RequiredArgsConstructor
public class ConferenceController {

    private final ConferenceRepository conferenceRepository;

    @GetMapping(value = "/{name}/plan")
    public ConferenceDto getConferencePlan(@PathVariable String name) {
        ConferenceDto conferenceDto = new ConferenceDto();
        Conference conference = conferenceRepository.findByName(name);
        List<Lecture> lectures = conference.getLecture();
        for (Lecture lecture : lectures) {
            List<LecturePath> lecturePaths = lecture.getLecturePaths();
            conferenceDto.getLecturePathList().addAll(lecturePaths);
        }
        conferenceDto.setId(conference.getId());
        conferenceDto.setName(conference.getName());
        return conferenceDto;
    }


}
