package pl.pankiewicz.springbootconference.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATION")
public class Reservation {

    private Long id;
    private User user;
    private LecturePath lecturePath;

    public Reservation() {
    }

    public Reservation(User user, LecturePath lecturePath) {
        this.user = user;
        this.lecturePath = lecturePath;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
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
