package com.example.angularshool.ds;

import com.example.angularshool.validator.NotAdmin;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category extends IdClass{
    @NotAdmin()
    @NotEmpty(message = "{book.name.valid.empty}")//is HardCode
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Book> bookList=new ArrayList<>();

    public Book addBook(Book book){
        book.setBook(this);
        bookList.add(book);
        return book;
    }

    public void remove(){
        bookList.remove(this);
    }

}
