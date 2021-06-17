package pl.pankiewicz.springbootconference.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ConferenceDto {

    private Long id;
    private String name;
}
