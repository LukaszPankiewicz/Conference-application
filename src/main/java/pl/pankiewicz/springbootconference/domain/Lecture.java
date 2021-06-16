package pl.pankiewicz.springbootconference.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LECTURE")
public class Lecture {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "DATE")
    private LocalDate date;

    @NotNull
    @Column(name = "STARTTIME")
    private LocalTime startTime;

    @NotNull
    @Column(name = "ENDTIME")
    private LocalTime endTime;

    @Column(name = "TITLE")
    private String title;


    public Lecture() {
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getTitle() {
        return title;
    }

}
