package lk.ijse.repository.impl;

import lk.ijse.entity.Book;
import lk.ijse.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private Session session;

    public void setSession(Session session){
        this.session = session;
    }

    @Override
    public List<Book> getAll() {
        String sqlQuery="From Book";
        Query query=session.createQuery(sqlQuery);
        List list=query.list();
        System.out.println("hiii");
        return list;
    }


    @Override
    public Long save(Book book) {
        System.out.println(book);
        System.out.println("Hiii mn awa");

        return (Long) session.save(book);
//        return (Long) session.save(book);
    }

    @Override
    public void update(Book book) {
        session.update(book);

    }

    @Override
    public Book get(Long id) {
        return session.get(Book.class,id);
    }

    @Override
    public void delete(Book book) {
        session.delete(book);

    }
}
