package pl.pankiewicz.springbootconference.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private List<Reservation> reservationList;
}
