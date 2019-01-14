package ru.itpark.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itpark.service.ProductsService;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("products",productsService.findAll());
        return "products";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable int id,Model model) {
        model.addAttribute("product",productsService.findById(id));

        return "product";

    }

}
