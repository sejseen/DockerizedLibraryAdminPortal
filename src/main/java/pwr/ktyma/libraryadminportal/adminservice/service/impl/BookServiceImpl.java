package pwr.ktyma.libraryadminportal.adminservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwr.ktyma.libraryadminportal.adminservice.domain.Book;
import pwr.ktyma.libraryadminportal.adminservice.repo.BookRepository;
import pwr.ktyma.libraryadminportal.adminservice.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book findOne(Long id) {
        return bookRepository.findOne(id);
    }

}
