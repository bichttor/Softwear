package com.softwears.Softwear.Homepage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class aboutController {

    @GetMapping("/about")
    public String getMethodName(Model model) {
        return "about";
    }
    
}
