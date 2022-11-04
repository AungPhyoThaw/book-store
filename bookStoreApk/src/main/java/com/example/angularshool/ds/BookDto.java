package com.example.angularshool.ds;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class BookDto {
    private int id;
    private String title;
    private String author;
    private double price;
    private String imageUrl;


    public BookDto() {
    }

    public BookDto(int id, String title, String author, double price, String imageUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
