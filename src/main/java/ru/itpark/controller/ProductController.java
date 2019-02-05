package ru.itpark.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.itpark.service.ProductsService;

import java.util.List;



@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("products", productsService.findAll());

        return "products";

    }

    @GetMapping("/{id}")
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("product", productsService.findById(id));

        return "product";
    }
    @GetMapping(value = "/search", params = "name")
    public String search(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("items", productsService.findByName(name));
        return "all";
    }

}
