package Projects.Marselle.services;

import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.repositories.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccessoryService {
    private final AccessoryRepository accessoryRepository;

    @Autowired
    public AccessoryService(AccessoryRepository accessoryRepository) {
        this.accessoryRepository = accessoryRepository;
    }

    public Optional<Accessory> findByName(String name) {
        return accessoryRepository.findByName(name);
    }
}
