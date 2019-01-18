package ru.itpark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //15 Аннотации  Project Lombok
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;            //16 все поля заполняем,не делаем Getters Setters ,так как это делает Lombok,потом идем в сервис
    public String name;
    private int price;
    private String picture;

}
