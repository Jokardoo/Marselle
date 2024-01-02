package Projects.Marselle.repositories;

import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChipboardRepository extends JpaRepository<Chipboard, Integer> {
}
