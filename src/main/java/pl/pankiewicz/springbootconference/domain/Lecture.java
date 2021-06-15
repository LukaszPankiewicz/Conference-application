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


public class Lecture implements ConferencePlan {

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
        this.endTime = startTime.plusMinutes(duration.toMinutes());
    }

    public int get_PARTICIPANT() {
        return _PARTICIPANT;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public LocalTime getStartTime() {
        return startTime;
    }

    public Duration getDuration() {
        return duration;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public String getExpert() {
        return expert;
    }

    public List<Long> getParticipants() {
        return participants;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public LocalTime getEndTime() {
        return endTime;
    }

    public int getReservedPaths() {
        return participants.size();
    }

    public boolean addNewParticipant() {
        return participants.add(id);
    }

    public boolean checkFreeSlots() {
        return get_PARTICIPANT() > getReservedPaths();
    }

    public boolean avoidSameTimeReservation(Optional<Lecture> lecture) {
        return lecture.map(optionalLecture ->
                (this.getDate().isEqual(optionalLecture.getDate())) &&
                        (this.getStartTime().isBefore(optionalLecture.getEndTime())) &&
                        (this.getEndTime().isAfter(optionalLecture.getStartTime()))).orElse(false);
    }
}
