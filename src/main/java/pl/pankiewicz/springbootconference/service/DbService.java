package pl.pankiewicz.springbootconference.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pankiewicz.springbootconference.domain.User;
import pl.pankiewicz.springbootconference.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {
    private final UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUser(final Long userId) {
        return repository.findById(userId);
    }

    public User saveUser (final User user) {
        return repository.save(user);
    }

    public void deleteUser(final Long id) {
        repository.deleteById(id);
    }
}
