package pl.pankiewicz.springbootconference.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RESERVATION")
public class Reservation {

    private Long id;
    private User user;
    private LecturePath lecturePath;

    public Reservation(Long id, User user, LecturePath lecturePath) {
        this.id = id;
        this.user = user;
        this.lecturePath = lecturePath;
    }

    public Reservation() {
    }

    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    public User getUser() {
        return user;
    }

    @ManyToOne
    @JoinColumn(name = "LECTUREPATH_ID")
    public LecturePath getLecturePath() {
        return lecturePath;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLecturePath(LecturePath lecturePath) {
        this.lecturePath = lecturePath;
    }
}