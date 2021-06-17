package pl.pankiewicz.springbootconference.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    private Long id;
    private String username;
    private String email;
    private Reservation reservation;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    public Long getId() {
        return id;
    }

    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "RESERVATION_ID")
    public Reservation getReservation() {
        return reservation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
