package com.example.angularshool.controller;

import com.example.angularshool.ds.Users;
import com.example.angularshool.service.CartService;
import com.example.angularshool.service.BookService;
import com.example.angularshool.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CartService cartService;
    @Autowired
    private UsersService usersService;

    @GetMapping("/user/allbooks")
    public String allBooks(Model model){
        model.addAttribute("books",bookService.findAll());
        model.addAttribute("cartSize",cartService.cartSize);
      return "user/allbooks";
    }

    @GetMapping("/user/book-details")
    public String detailsBook(@RequestParam("bookId") int bookId, Model model){

        model.addAttribute("book",bookService.findBook(bookId));
        model.addAttribute("cartSize",cartService.cartSize);
        return "user/book-details";
    }
    @GetMapping("/user/add/cart")
    public String addToCart(@RequestParam("bookId")int bookId, Model model,
                            RedirectAttributes attributes){
        cartService.addToCart(bookService.findBook(bookId));

        return "redirect:/user/book-details?bookId="+bookId;

    }
   @GetMapping("/user/cart/view")
    public String cartView(Model model){
        model.addAttribute("books",cartService.allBooksInCart());
        return "user/cart-view";

    }
    @GetMapping("/user/cart/clear")
    public String clearCart(){
       cartService.clearCart();
       return "redirect:/user/cart/view";
    }

    @GetMapping("/user/cart/remove")
    public String removeBookFromCart(@RequestParam("bookId")int bookId,Model model){
        cartService.removeCartBook(bookService.findBook(bookId));
        model.addAttribute("cartSize",cartService.cartSize);
        return "redirect:/user/cart/view";

    }
    @GetMapping("/user/cart/checkout")
    public String checkOut(Model model){
       model.addAttribute("users",new Users());
       return "user/user-form";
    }
    @PostMapping("/user/cart/checkout")
    public String processUserCheckout(Users users, BindingResult result){
        if (result.hasErrors()){
            return "user/user-form";
        }else {
            usersService.checkOut(users,cartService.allBooksInCart());
        }
        return "redirect:/user/allbooks";
    }
    @GetMapping("/user/search")
    public String search(@RequestParam("userId") int userId,Model model){
        model.addAttribute("books",usersService.getBooksByUserId(userId));

        return "user/allbooks";
    }
}
