package pl.pankiewicz.springbootconference.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Lecture {

    private final int _PARTICIPANT = 5;

    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Duration duration;
    private String title;
    private String expert;
    private List<Long> participants;

    public Lecture(Long id, LocalDate date, LocalTime time, Duration duration, String title, String expert) {
        super();
        this.id = id;
        this.date = date;
        this.startTime = time;
        this.duration = duration;
        this.title = title;
        this.expert = expert;
        this.participants = new ArrayList<Long>();

    }

}
