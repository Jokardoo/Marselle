package Projects.Marselle.controllers;

import Projects.Marselle.dto.PersonDto;
import Projects.Marselle.models.Person;
import Projects.Marselle.services.PeopleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PeopleController {
    private final PeopleService peopleService;
    private final ModelMapper modelMapper;

    @Autowired
    public PeopleController(PeopleService peopleService, ModelMapper modelMapper) {
        this.peopleService = peopleService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/workers")
    public ModelAndView workers() {
        ModelAndView modelAndView = new ModelAndView("people/workers");

        List<Person> workers = peopleService.findByIsWorkerTrue();
        List<PersonDto> workersDto = new ArrayList<>();

        for (Person person : workers) {
            workersDto.add(modelMapper.map(person, PersonDto.class));
        }

        modelAndView.addObject("currentWorker", new PersonDto());
        modelAndView.addObject("workersDto", workersDto);
        return modelAndView;
    }

    @GetMapping("/worker")
    public ModelAndView worker(@RequestParam(name = "user", required = true) String username) {
        System.out.println(username);
        ModelAndView modelAndView = new ModelAndView("people/worker");
        Optional<Person> person = peopleService.findByUsername(username);

        if (person.isEmpty()) { // Если не нашли в БД
            ModelAndView redirectModelAndView = new ModelAndView("people/workers");
            List<Person> workers = peopleService.findByIsWorkerTrue();
            List<PersonDto> workersDto = new ArrayList<>();

            for (Person p : workers) {
                workersDto.add(modelMapper.map(p, PersonDto.class));
            }

            modelAndView.addObject("currentWorker", new PersonDto());
            modelAndView.addObject("workersDto", workersDto);

            return redirectModelAndView;
        }

        Person foundPerson = person.get();
        PersonDto foundPersonDto = modelMapper.map(foundPerson, PersonDto.class);

        modelAndView.addObject("personDto", foundPersonDto);

        return modelAndView;
    }
}
