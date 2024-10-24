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
    public String getAllProducts(@RequestParam("type") String type, Model model){
        List<Product> products;
        products = switch (type.toLowerCase()) {
            case "shirts" -> productservice.getShirts(); 
            case "pants" -> productservice.getPants();
            case "shoes" -> productservice.getShoes();
            /*Implement Cases for mens and womens */
            default ->  productservice.getProducts();
        }; 
        model.addAttribute("products", products);
        return "catalog";
    }
   
}
