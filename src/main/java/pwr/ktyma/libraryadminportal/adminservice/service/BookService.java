package pwr.ktyma.libraryadminportal.adminservice.service;


import pwr.ktyma.libraryadminportal.adminservice.domain.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();

    Book findOne(Long id);
}
