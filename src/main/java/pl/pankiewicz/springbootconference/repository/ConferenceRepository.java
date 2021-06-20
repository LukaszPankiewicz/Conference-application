package pl.pankiewicz.springbootconference.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pankiewicz.springbootconference.domain.Conference;

@Repository
public interface ConferenceRepository extends CrudRepository<Conference, Long> {

    Conference findByName(String name);
}
