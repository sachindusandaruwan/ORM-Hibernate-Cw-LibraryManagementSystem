package lk.ijse.repository.impl;

import lk.ijse.entity.Book;
import lk.ijse.projection.BookIdsAndAvailability;
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
    /*public List<BookIdsAndAvailability> getBookIdAndAvailability(String bookName) {

        String sqlQuery = "SELECT NEW lk.ijse.projection.BookIdsAndAvailability(B.b_Id, B.availability) \n" +
                "FROM Book AS B \n" +
                "WHERE B.b_Name = :b_Name";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();
        query.setParameter("b_Name", bookName);

        return list;
    }*/
    public List<BookIdsAndAvailability> getBookIdAndAvailability(String bookName) {
        String sqlQuery = "SELECT NEW lk.ijse.projection.BookIdsAndAvailability(B.b_Id, B.availability) " +
                "FROM Book AS B " +
                "WHERE B.b_Name = :b_Name";

        Query query = session.createQuery(sqlQuery);
        query.setParameter("b_Name", bookName); // Set the parameter before executing the query
        List<BookIdsAndAvailability> resultList = query.list();

        return resultList;
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
