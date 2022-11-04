package com.example.angularshool.controller;

import com.example.angularshool.ds.Book;
import com.example.angularshool.service.BookService;
import com.example.angularshool.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class BookController {
    private final BookService bookService;
    private final CategoryService categoryService;


    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }


    @GetMapping("/create-book")
    public String create(Model model){
        model.addAttribute("book",new Book());
        model.addAttribute("categories",categoryService.findAllCategory());
        return "admin/book-form";

    }

    @PostMapping("/create-book")
    public String save(@Valid Book book, @RequestParam("cadId") int categoryId,
                       BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "admin/book-form";

        }else{
            bookService.saveBook(categoryId,book);
            redirectAttributes.addFlashAttribute("success",true);
        }
       return "redirect:/all-books" ;
    }

    @GetMapping("/all-books")
    public String allBook(Model model){
        model.addAttribute("books",bookService.findAll());
        model.addAttribute("success",model.containsAttribute("success"));
        model.addAttribute("delete",model.containsAttribute("delete"));
        return "admin/all-books";
    }

    @GetMapping("/all-books/delete")
    public String removeBook(@RequestParam("bookId") int bookId,
                               RedirectAttributes redirectAttributes){
        bookService.removeBook(bookId);
        redirectAttributes.addFlashAttribute("delete",true);
        return "redirect:/all-books" ;
    }

    @GetMapping("/all-book/update")
    public String updateBook(@RequestParam("bid") int bookId,Model model){
        model.addAttribute("categories",categoryService.findAllCategory());
        model.addAttribute("book",bookService.findBook(bookId));
        this.bookId = bookId;
        return "admin/book-update";
    }

    @PostMapping("/all-books/process")
    public String processUpdate(@RequestParam("cadId") int catId , Book book, BindingResult result){
        if(result.hasErrors()){
            return "admin/book-update";
        }else {
            bookService.updateBook(bookId,book,catId);
        }
        return "redirect:/all-books";
    }

    private int bookId;

}
