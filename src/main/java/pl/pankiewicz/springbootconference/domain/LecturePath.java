package pl.pankiewicz.springbootconference.domain;

import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "LECTUREPATH")
public class LecturePath {

    private Long id;
    private String title;

    public LecturePath() {
    }

    public LecturePath(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
