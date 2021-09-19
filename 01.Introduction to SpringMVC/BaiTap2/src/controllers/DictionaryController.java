package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("translate")
public class DictionaryController {

    @PostMapping
    public String translateWord(@RequestParam String english, Model model) {
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("smartphone", "điện thoại thông minh");
        dictionary.put("study", "học");
        dictionary.put("japanese", "tiếng nhật");
        dictionary.put("compiler", "trình biên dịch");
        dictionary.put("interpreter", "trình thông dịch");
        model.addAttribute("english", english);
        model.addAttribute("vietnamese", dictionary.getOrDefault(english, "Not exist in dictionary"));
        return "dictionary";
    }


}
