package pl.coderslab.person;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/person")
public class PersonController {


    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("people", personDao.getAll());
        return "person/list";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String showForm(){
        return "person/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String performForm(
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam String email) {

        Person person = new Person();
        person.setLogin(login);
        person.setEmail(email);
        person.setPassword(password);

        personDao.save(person);
        return "redirect:/person/list";
    }


}
