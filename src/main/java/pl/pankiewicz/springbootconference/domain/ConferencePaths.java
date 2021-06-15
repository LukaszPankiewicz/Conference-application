package pl.pankiewicz.springbootconference.domain;


import java.time.LocalDate;
import java.util.List;

public class ConferencePaths {

    private Long id;
    private String title;
    private LocalDate date;
    private List<ConferencePlan> planOfConference;

    public ConferencePaths(Long id, String title, LocalDate date) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.planOfConference = planOfConference;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<ConferencePlan> getPlanOfConference() {
        return planOfConference;
    }

}
