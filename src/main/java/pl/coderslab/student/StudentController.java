package pl.coderslab.student;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @ModelAttribute("languages")
    public List<String> checkOptions() {
        String[] a = new String[] {"java", "php", "ruby", "python"};

        System.out.println("RRRRRRRRRRRRRRRRRRRRRRR");
        return Arrays.asList(a);
    }

    @GetMapping("/testo")
    @ResponseBody
    public String testBindingo() {

        return "ok";
    }

    @GetMapping("/test")
    public String testBindingForm(Model model) {
        Student student = new Student("dddd", "ffff");
        model.addAttribute("student", student);
        return "student/form";
    }

    @PostMapping("/test")
    @ResponseBody
    public String testBinding(Student student) {
        System.out.println(student);
        return "ok";
    }
}
