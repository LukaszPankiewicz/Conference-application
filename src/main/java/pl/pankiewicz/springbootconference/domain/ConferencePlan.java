package pl.pankiewicz.springbootconference.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ConferencePlan {

    Long getId();
    String getTitle();
    LocalTime getStartTime();
    LocalTime getEndTime();
}
