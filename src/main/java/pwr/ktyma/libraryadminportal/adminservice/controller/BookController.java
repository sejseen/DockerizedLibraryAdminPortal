package pwr.ktyma.libraryadminportal.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import pwr.ktyma.libraryadminportal.adminservice.domain.Book;
import pwr.ktyma.libraryadminportal.adminservice.service.BookService;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final String STATIC_RESOURCES_PATH = "src/main/resources/static/image/book";

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);

        return "addBook";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
        bookService.save(book);

        if(book.getBookImage() != null) {
            try {
                uploadImage(book);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:bookList";
    }

    @RequestMapping("/bookList")
    public String bookList(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);

        return "bookList";
    }

    private void uploadImage(@ModelAttribute("book") Book book) throws IOException {
        MultipartFile bookImage = book.getBookImage();
        byte[] bytes = bookImage.getBytes();
        String name = "/book" + book.getId() + ".png";
        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(new File(STATIC_RESOURCES_PATH) + name));
        stream.write(bytes);
        stream.close();
    }
}