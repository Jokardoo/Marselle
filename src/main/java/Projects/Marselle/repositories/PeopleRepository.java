package Projects.Marselle.repositories;

import Projects.Marselle.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String username);

    List<Person> findByIsWorkerTrue(); // Метод должен искать конкретно работников
}
