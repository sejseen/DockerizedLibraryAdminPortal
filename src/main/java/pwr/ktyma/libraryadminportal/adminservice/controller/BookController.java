package pwr.ktyma.libraryadminportal.adminservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pwr.ktyma.libraryadminportal.adminservice.domain.Book;

@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping("/add")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);

        return "addBook";
    }
}
