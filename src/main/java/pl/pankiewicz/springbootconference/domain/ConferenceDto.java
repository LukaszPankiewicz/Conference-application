package pl.pankiewicz.springbootconference.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConferenceDto {

    private Long id;
    private String name;
    private List<LecturePath> lecturePathList;
}
