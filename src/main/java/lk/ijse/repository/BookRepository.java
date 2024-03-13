package lk.ijse.repository;

import lk.ijse.entity.Book;
import org.hibernate.Session;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long>{
    public void setSession(Session session);

    List<Book> getAll();
}
