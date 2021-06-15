package pl.pankiewicz.springbootconference.repository;

import org.springframework.stereotype.Repository;
import pl.pankiewicz.springbootconference.domain.ConferencePaths;
import pl.pankiewicz.springbootconference.domain.ConferencePlan;
import pl.pankiewicz.springbootconference.domain.Lecture;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
public class SchedulerRepository {

    private Map<LocalDate, List<ConferencePaths>> schedule = new HashMap<>();

    private List<ConferencePlan> conferenceSchedule;


    public Map<LocalDate, List<ConferencePaths>> getSchedule() {
        return schedule;
    }

    private void initializeConferenceDay() {
        LocalDate conferenceDay = LocalDate.of(2021, 6, 1);
        schedule.put(conferenceDay, new LinkedList<>());

        schedule.get(conferenceDay).add(new ConferencePaths(0L, "Python", conferenceDay));
        schedule.get(conferenceDay).add(new ConferencePaths(0L, "Ruby On Rails", conferenceDay));
        schedule.get(conferenceDay).add(new ConferencePaths(0L, "Java", conferenceDay));

        conferenceSchedule = schedule.get(conferenceDay).get(0).getPlanOfConference();
        conferenceSchedule.add(new Lecture(0L, conferenceDay, LocalTime.of(10,00),
                Duration.ofHours(1).plus(Duration.ofMinutes(45)), "Django", "Adrian Holovaty"));
        conferenceSchedule.add(new Lecture(1L, conferenceDay, LocalTime.of(10,00),
                Duration.ofHours(1).plus(Duration.ofMinutes(45)), "Sinatra", "Blake Mizerany"));
        conferenceSchedule.add(new Lecture(2L, conferenceDay, LocalTime.of(10,00),
                Duration.ofHours(1).plus(Duration.ofMinutes(45)), "Spring", "Rod Johnson"));

        conferenceSchedule = schedule.get(conferenceDay).get(1).getPlanOfConference();
        conferenceSchedule.add(new Lecture(3L, conferenceDay, LocalTime.of(12,00),
                Duration.ofHours(1).plus(Duration.ofMinutes(45)), "Flask", "Adrian Holovaty"));
        conferenceSchedule.add(new Lecture(4L, conferenceDay, LocalTime.of(12,00),
                Duration.ofHours(1).plus(Duration.ofMinutes(45)), "Hanami", "Philip Arndt"));
        conferenceSchedule.add(new Lecture(5L, conferenceDay, LocalTime.of(12,00),
                Duration.ofHours(1).plus(Duration.ofMinutes(45)), "Grails", "David Heinemeier Hansson"));

        conferenceSchedule = schedule.get(conferenceDay).get(2).getPlanOfConference();
        conferenceSchedule.add(new Lecture(6L, conferenceDay, LocalTime.of(14,00),
                Duration.ofHours(1).plus(Duration.ofMinutes(45)), "Web2py", "Adrian Holovaty"));
        conferenceSchedule.add(new Lecture(7L, conferenceDay, LocalTime.of(14,00),
                Duration.ofHours(1).plus(Duration.ofMinutes(45)), "Padrino", "Philip Arndt"));
        conferenceSchedule.add(new Lecture(8L, conferenceDay, LocalTime.of(14,00),
                Duration.ofHours(1).plus(Duration.ofMinutes(45)), "JSF", "David Heinemeier Hansson"));
    }
}
