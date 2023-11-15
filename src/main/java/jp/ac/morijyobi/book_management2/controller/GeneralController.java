package jp.ac.morijyobi.book_management2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GeneralController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}
