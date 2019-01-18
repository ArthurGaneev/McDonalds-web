package ru.itpark.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.itpark.service.ProductsService;

import java.util.List;


//Отвечает за то чтобы принять запрос,подготовить ответ, в этом случае это будет имя view,которая отображется пользователю
@Controller               //01
@RequestMapping("/products") //          03                  Работает по адресу /products
public class ProductController {//Эксплуатирует ProductsService
    private final ProductsService productsService;//   05  Alt+Enter созаем класс ProductsService                Бизнес логика,

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    } //    06

    @GetMapping             //02
    public String getAll(Model model) { //12 вставить Model model в скобки     //Нам необходимо просить Модель , в которую будем добавлять аттрибуты
        model.addAttribute("products", productsService.findAll());//13     //аттрибут только один:это спиок всех продуктов,
        // просто попросим у productsService найти все findAll Alt + Enter создать метод в productsService
        return "products"; // Возвращает строку products,
        // Идея понимает на какой view переходить "шар слева"
    }

    @GetMapping("/{id}") //33 метода,который позволит получать  одну страничку с породуктом  -> /products/1
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("product", productsService.findById(id)); //Создаем метод 35 Alt+Ent

        return "product"; //34 делаем страницу product.html
    }
}
