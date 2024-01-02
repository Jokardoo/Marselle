package Projects.Marselle.services;

import Projects.Marselle.models.furniture.EdgingWork;
import Projects.Marselle.repositories.EdgingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EdgingService {
    private final EdgingRepository edgingRepository;

    @Autowired
    public EdgingService(EdgingRepository edgingRepository) {
        this.edgingRepository = edgingRepository;
    }

    public EdgingRepository getEdgingRepository() {
        return edgingRepository;
    }

    public Optional<EdgingWork> findById(int id) {
        return edgingRepository.findById(id);
    }
}
