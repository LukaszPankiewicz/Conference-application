package pl.pankiewicz.springbootconference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pankiewicz.springbootconference.repository.SchedulerRepository;

@Service
public class SchedulerService {

    @Autowired
    private SchedulerRepository schedulerRepository;

}
