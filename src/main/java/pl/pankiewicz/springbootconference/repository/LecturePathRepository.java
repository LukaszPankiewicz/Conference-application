package pl.pankiewicz.springbootconference.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pankiewicz.springbootconference.domain.LecturePath;

@Repository
public interface LecturePathRepository extends CrudRepository<LecturePath, String> {

    LecturePath findByTitle(String title);
}
