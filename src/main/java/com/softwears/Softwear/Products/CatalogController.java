package com.softwears.Softwear.Products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class CatalogController {

    @GetMapping("/catalog")
    public String getMethodName(Model model) {
        return "Catalog";
    }
    

}
