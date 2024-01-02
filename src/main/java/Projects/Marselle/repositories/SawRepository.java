package Projects.Marselle.repositories;

import Projects.Marselle.models.Person;
import Projects.Marselle.models.furniture.Saw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SawRepository extends JpaRepository<Saw, Integer> {
    Optional<Saw> findById(int id);

    Optional<Saw> findByType(String type);
}
