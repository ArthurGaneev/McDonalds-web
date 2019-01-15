package ru.itpark.service;

import org.springframework.stereotype.Service;
import ru.itpark.domain.Product;
import ru.itpark.repository.ProductsRepository;

import java.util.List;
//Отвечает за бизнес-логику
@Service  //       07
public class ProductsService {//Эксплуатирует ProductsRepository
    private final ProductsRepository productsRepository;   // 08 Alt+Enter созаем класс ProductsRepository  Хранение данных


    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }// 09

    public List<Product> findAll() {//   14     Будем возвращать из List из Product  Alt+enter создать класс Product
        //17  Импортируем List  Alt+enter
        return productsRepository.findAll(); //18 попросит у репозитория все эти продукты создадим метод в productsRepository
    }

    public Product findById(int id) {
        return productsRepository.findById(id);
    }

}
