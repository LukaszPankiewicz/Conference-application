package pl.pankiewicz.springbootconference.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LECTUREPATH")
public class LecturePath {

    private Long id;
    private String title;
    private List<Reservation> reservation;
    private Lecture lecture;

    public LecturePath() {
    }

    public LecturePath(String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    public Long getId() {
        return id;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    @OneToMany(
            targetEntity = Reservation.class,
            mappedBy = "lecturePath",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Reservation> getReservation() {
        return reservation;
    }

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    public Lecture getLecture() {
        return lecture;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
}
