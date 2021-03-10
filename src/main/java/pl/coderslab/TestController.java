package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/test")
    public String showForm() {
        System.out.println("test showForm");
        return "test";
    }

    @PostMapping("/test")
    public String firstPost() {
        System.out.println("test post");
        return "forward:/test1";
    }

    @GetMapping("/test1")
    @ResponseBody
    public String first11() {

        System.out.println("test1 post");
        return "test post";
    }
}
