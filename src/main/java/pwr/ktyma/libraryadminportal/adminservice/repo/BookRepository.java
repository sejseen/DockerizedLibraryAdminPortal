package pwr.ktyma.libraryadminportal.adminservice.repo;

import org.springframework.data.repository.CrudRepository;
import pwr.ktyma.libraryadminportal.adminservice.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
