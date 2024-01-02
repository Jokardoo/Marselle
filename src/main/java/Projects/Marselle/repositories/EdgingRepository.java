package Projects.Marselle.repositories;

import Projects.Marselle.models.furniture.EdgingWork;
import Projects.Marselle.models.furniture.Saw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EdgingRepository extends JpaRepository<EdgingWork, Integer> {
    Optional<EdgingWork> findById(int id);
}
