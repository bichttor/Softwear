package com.softwears.Softwear.Products;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CatalogController {

    @Autowired
    private ProductService productservice;
    
    @GetMapping("/catalog")
    public String getProducts(@RequestParam(required = false) String type ,@RequestParam(required = false) String gender
    ,@RequestParam(required = false) String query, Model model){
        List<Product> products;
        if (query != null && !query.isEmpty()) {
            products = productservice.searchProducts(query); // Call search method
            model.addAttribute("products", products);
            return "catalog";
        }
        else if(!gender.equals("all") && !type.equals("all")){
            products = productservice.getTypeGender(type, gender);
        }
        else if(!gender.equals("all")){
            products = productservice.getGender(gender);
        }
        else if(!type.equals("all")){
            products = productservice.getType(type);
        }
        else{
            products = productservice.getProducts();
        }
        model.addAttribute("products", products);
        return "catalog";
    }
   

}
