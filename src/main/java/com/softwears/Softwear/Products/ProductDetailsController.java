package com.softwears.Softwear.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductDetailsController {

    @Autowired
    private ProductService productService; // Service to fetch product data
    @Autowired
    private ProductDetailsService productDetailsService;

    @GetMapping("/product/{id}")
    public String getProductDetails(@PathVariable int id, Model model) {
        Product product = productService.getProductId(id);
        ProductDetails details = productDetailsService.getByProductId(product);
        model.addAttribute("product", product);
        model.addAttribute("details", details);
        return "ProductDetails";
    }
}
