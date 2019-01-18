package ru.itpark.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//Отвечает за хранение данных
@Repository  //10
public class ProductsRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;// Компонет private final NamedParameterJdbcTemplate jdbcTemplate
    // Чтобы репозиторию работать с БД,нужен еще один компонент ,
    // который умеет отправлять запросы в БД.

    public ProductsRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    } // 11         Просим через конструктор у Spring, он понимает откуда взять куда подставить, затем возвращемся
    // в контроллер и просим

    public List<Product> findAll() {
        //Вернем целый запрос
        return jdbcTemplate.query(
                "SELECT id,name,price,picture FROM products",
                (rs, i) -> new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("picture")
                )
        );// 19  new Rowmapper +enter, 20 new Product 21 result set.getInt("id") и тд,меняем на лямбду
        // 22 Дважды Shift Plugins ->Lombok-> Install-> перезапуск
        //23 идем в products.html



        // Rowmapper это такой объект ,который позволяет сопоставить результат result set к нашему объекту
    }

    public Product findById(int id) {  // 38 Будет просить jdbcTemplate сходить за объектом ,пишем SQL запрос
        return jdbcTemplate.queryForObject(
                "SELECT id,name,price,picture FROM products WHERE id = :id ",
                Map.of("id",id),
                (rs, i) -> new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("picture")
                )
        );// 39 Используем Map из параметров,затем создаем fragments -> layout.html
    }
}
