package pl.pankiewicz.springbootconference.repository;

import org.springframework.data.repository.CrudRepository;
import pl.pankiewicz.springbootconference.domain.Lecture;

public interface LectureRepository extends CrudRepository<Lecture, Long> {
}
