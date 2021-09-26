package controller;

import model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public String sendEmail(Model model) {
        model.addAttribute("email", new Email());
        return "email-form";
    }

    @RequestMapping(value="/sendEmail", method = RequestMethod.POST)
    public String checkEmail(Email email, Model model) {
        model.addAttribute("email", email);
        return "email-info";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateEmail(Email email, Model model) {
        model.addAttribute("email", email);
        return "update-form";
    }
}
