package com.softwears.Softwear.Products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class menController {

    @GetMapping("/men")
    public String getMethodName(Model model) {
        return "men";
    }
    

}
