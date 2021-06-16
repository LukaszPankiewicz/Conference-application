package pl.pankiewicz.springbootconference.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "EMAIL")
    private String email;

}
