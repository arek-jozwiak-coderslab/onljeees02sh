package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonTestRepositoryController {
    private final PersonRepository personRepository;

    public PersonTestRepositoryController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/testrepo")
    public void test(){

        List<Person> all = personRepository.findAll();
        Person one = personRepository.getOne(1l);
        Optional<Person> byId = personRepository.findById(1l);

        Person person = new Person();
        personRepository.save(person);
    }
}
