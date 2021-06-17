package pl.pankiewicz.springbootconference.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CONFERENCE")
public class Conference {

    private Long id;
    private String name;
    private List<Lecture> lecture;

    public Conference() {
    }

    public Conference(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(
            targetEntity = Lecture.class,
            mappedBy = "conference",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Lecture> getLecture() {
        return lecture;
    }

    public void setLecture(List<Lecture> lecture) {
        this.lecture = lecture;
    }
}
