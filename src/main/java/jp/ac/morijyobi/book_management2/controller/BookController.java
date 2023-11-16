package jp.ac.morijyobi.book_management2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping("/register")
    public String registerBook(Model model) {
        return "book/register-book";
    }
}
