package ru.itpark.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.domain.Product;

import java.util.List;
import java.util.Map;

@Repository
public class ProductsRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProductsRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findAll() {
        return jdbcTemplate.query(
                "SELECT id,name,price FROM products",
                (rs, i) -> new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price")
                )
        );
    }

    public Product findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT id,name,price FROM products WHERE id = :id ",
                Map.of("id",id),
                (rs, i) -> new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price")
                )
        );
    }
}
