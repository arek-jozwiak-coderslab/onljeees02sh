package pl.coderslab.books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {

    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @RequestMapping("/validate")
    @ResponseBody
    public String validate (){
        Book book = new Book();
        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);
        if(constraintViolations.isEmpty()){
            System.out.println("oko oko ko ko k o ");
        }else {
            for (ConstraintViolation<Book> constraintViolation : constraintViolations) {
                System.out.println(" " + constraintViolation.getPropertyPath());
                System.out.println(" " + constraintViolation.getMessage());
            }
        }
        return "ok";
    }
}
