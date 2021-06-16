package pl.pankiewicz.springbootconference.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pankiewicz.springbootconference.service.DbService;

@RestController
@RequestMapping("/v1/conference")
@RequiredArgsConstructor
public class ConferenceController {

    private final DbService dbService;

}
