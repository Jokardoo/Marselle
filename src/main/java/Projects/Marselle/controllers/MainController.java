package Projects.Marselle.controllers;

import Projects.Marselle.dto.PersonDto;
import Projects.Marselle.models.Person;
import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.security.PersonDetails;
import Projects.Marselle.services.PeopleService;
import Projects.Marselle.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    private final ModelMapper modelMapper;
    private final PeopleService personService;

    @Autowired
    public MainController(ModelMapper modelMapper, PeopleService personService) {
        this.modelMapper = modelMapper;
        this.personService = personService;
    }

    @GetMapping("/main")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView("main/main");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) auth.getPrincipal();

        PersonDto personDto = modelMapper.map(personDetails.getPerson(), PersonDto.class);
        modelAndView.addObject("personDto", personDto);

        return modelAndView;
    }



}
