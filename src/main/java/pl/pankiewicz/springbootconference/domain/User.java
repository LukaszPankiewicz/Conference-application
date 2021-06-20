package pl.pankiewicz.springbootconference.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    private Long id;
    private String username;
    private String email;
    private List<Reservation> reservationList;

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

    @OneToMany(
            targetEntity = Reservation.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user"
    )
    public List<Reservation> getReservationList() {
        return reservationList;
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

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
