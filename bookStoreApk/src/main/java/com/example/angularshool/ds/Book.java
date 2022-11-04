package com.example.angularshool.ds;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Book extends IdClass{

    private String title;
    private String author;
    private double price;
    private String imageUrl;

@ManyToOne
private Category category;


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", category=" + category +
                '}';
    }

    public void setBook(Category category) {
        this.category = category;
    }
}
