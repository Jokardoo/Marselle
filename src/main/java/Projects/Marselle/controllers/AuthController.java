package Projects.Marselle.controllers;

import Projects.Marselle.dto.PersonDto;
import Projects.Marselle.models.Person;
import Projects.Marselle.services.PersonDetailsService;
import Projects.Marselle.services.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class AuthController {

    private final ModelMapper modelMapper;
    private final RegistrationService registrationService;
    private final PersonDetailsService personDetailsService;

    @Autowired
    public AuthController(ModelMapper modelMapper, RegistrationService registrationService, PersonDetailsService personDetailsService) {
        this.modelMapper = modelMapper;
        this.registrationService = registrationService;
        this.personDetailsService = personDetailsService;
    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView("auth/login");

        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView("auth/registration");
        modelAndView.addObject("person", new PersonDto());

        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registrationProcess(@ModelAttribute("person") @Valid PersonDto personDto,
                                            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("auth/registration");
            modelAndView.addObject("person", personDto);

            return modelAndView;
        }

        Person person = modelMapper.map(personDto, Person.class);
        System.out.println(person);
        person.setRole("ROLE_USER");
        registrationService.register(person);

        ModelAndView modelAndView = new ModelAndView("auth/login");
        return modelAndView;
    }
}
