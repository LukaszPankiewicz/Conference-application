package pl.pankiewicz.springbootconference.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pankiewicz.springbootconference.domain.Conference;
import pl.pankiewicz.springbootconference.domain.LecturePath;

@Repository
public interface ConferenceRepository extends CrudRepository<Conference, String> {

    ConferenceRepository findByName(String name);
}
