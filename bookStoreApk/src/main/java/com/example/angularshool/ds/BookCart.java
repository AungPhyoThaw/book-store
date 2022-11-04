package com.example.angularshool.ds;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class BookCart {

    private List<BookDto> books=new ArrayList<>();
    public void addBook(Book book){
        books.add(bookToDto(book));
    }

    private BookDto bookToDto(Book book){
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getImageUrl()
        );

    }

    public void removeBook(Book book){
        books.remove(bookToDto(book));
    }
    public void clearCart(){
        books.clear();
    }

    public List<BookDto> getBooks() {
        return books;
    }
    public int getCartSize(){
        return books.size();

    }
}
