package Projects.Marselle.services;

import Projects.Marselle.models.Person;
import Projects.Marselle.repositories.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository personRepository) {
        this.peopleRepository = personRepository;
    }


    public void save(Person person) {
        peopleRepository.save(person);
    }

    public List<Person> findByIsWorkerTrue() {
        return peopleRepository.findByIsWorkerTrue();
    }

    public Optional<Person> findByUsername(String username) {
        return peopleRepository.findByUsername(username);
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }



}
