package Projects.Marselle.services;

import Projects.Marselle.models.furniture.Saw;
import Projects.Marselle.repositories.SawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SawService {
    private final SawRepository sawRepository;

    @Autowired
    public SawService(SawRepository sawRepository) {
        this.sawRepository = sawRepository;
    }

    public SawRepository getSawRepository() {
        return sawRepository;
    }

    public Optional<Saw> findById(int id) {
        return sawRepository.findById(id);
    }

    public Optional<Saw> findByType(String type) {
        return sawRepository.findByType(type);
    }
}
