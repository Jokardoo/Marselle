package Projects.Marselle.repositories;

import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccessoryRepository extends JpaRepository<Accessory, Integer> {
    Optional<Accessory> findByName(String name);
}
