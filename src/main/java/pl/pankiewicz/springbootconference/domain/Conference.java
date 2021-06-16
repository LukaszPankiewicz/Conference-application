package pl.pankiewicz.springbootconference.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CONFERENCE")
public class Conference {

    private Long id;
    private List<Lecture> lecture;

    public Conference(Long id) {
        this.id = id;
    }

    public Conference() {
    }

    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(
            targetEntity = Lecture.class,
            mappedBy = "lecture",
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
