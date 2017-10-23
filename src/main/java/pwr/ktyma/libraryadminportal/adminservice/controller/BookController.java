package pwr.ktyma.libraryadminportal.adminservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pwr.ktyma.libraryadminportal.adminservice.domain.Book;
import pwr.ktyma.libraryadminportal.adminservice.service.BookService;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
@Slf4j
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
        MultipartFile bookImage = book.getBookImage();

        if(!bookImage.isEmpty()) {
            try {
                uploadImage(book, false);
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

    @RequestMapping("/bookInfo")
    public String bookInfo(@RequestParam("id") Long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);

        return "bookInfo";
    }

    @RequestMapping("/updateBook")
    public String updateBook(@RequestParam("id") Long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);

        return "updateBook";
    }

    @RequestMapping(value = "/deleteBook", method =RequestMethod.POST)
    public String deleteBook(@ModelAttribute("id") String id, Model model) {
        bookService.removeOne(Long.parseLong(id.substring(8)));
        log.info("Removing book ID");
        List<Book> allBooks = bookService.findAll();
        model.addAttribute("allBooks", allBooks);

        return "redirect:/book/bookList";
    }

    @RequestMapping(value="/updateBook", method = RequestMethod.POST)
    public String updateBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
        bookService.save(book);

        MultipartFile bookImage = book.getBookImage();
        if(!bookImage.isEmpty()) {
            try {
                uploadImage(book, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:bookInfo?id=" + book.getId();
    }

    private void uploadImage(Book book, Boolean isUpdated) throws IOException {
        MultipartFile bookImage = book.getBookImage();
        byte[] bytes = bookImage.getBytes();
        String name = "/book" + book.getId() + ".png";

        if(isUpdated && Files.exists(Paths.get(STATIC_RESOURCES_PATH + name))) {
            Files.delete(Paths.get(STATIC_RESOURCES_PATH + name));
        }

        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(new File(STATIC_RESOURCES_PATH) + name));
        stream.write(bytes);
        stream.close();
    }

}
