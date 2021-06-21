package pl.pankiewicz.springbootconference.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "LECTURE")
public class Lecture {

    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String title;
    private List<LecturePath> lecturePaths;
    private Conference conference;

    public Lecture() {
    }
    public Lecture(LocalDate date, LocalTime startTime, LocalTime endTime, String title, Conference conference) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.conference = conference;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    public Long getId() {
        return id;
    }

    @NonNull
    @Column(name = "DATE")
    public LocalDate getDate() {
        return date;
    }

    @NonNull
    @Column(name = "STARTTIME")
    public LocalTime getStartTime() {
        return startTime;
    }

    @NonNull
    @Column(name = "ENDTIME")
    public LocalTime getEndTime() {
        return endTime;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    @OneToMany(
            targetEntity = LecturePath.class,
            mappedBy = "lecture",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<LecturePath> getLecturePaths() {
        return lecturePaths;
    }

    @ManyToOne
    @JoinColumn(name = "CONFERENCE_ID")
    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public void setLecturePaths(List<LecturePath> lecturePaths) {
        this.lecturePaths = lecturePaths;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
