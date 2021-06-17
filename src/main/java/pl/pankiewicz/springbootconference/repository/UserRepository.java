package pl.pankiewicz.springbootconference.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pankiewicz.springbootconference.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    List<User> findAll();

    @Override
    User save(User user);

    @Override
    Optional<User> findById(Long id);

    @Override
    void deleteById(Long id);
}
