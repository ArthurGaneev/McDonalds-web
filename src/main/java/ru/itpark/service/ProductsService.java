package ru.itpark.service;

import org.springframework.stereotype.Service;
import ru.itpark.domain.Product;
import ru.itpark.repository.ProductsRepository;


import java.util.List;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;


    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAll() {

        return productsRepository.findAll();
    }

    public Product findById(int id) {
        return productsRepository.findById(id);
    }



    public List<Product> findByName(String name) {
        return productsRepository.findByName(name);
    }
}
