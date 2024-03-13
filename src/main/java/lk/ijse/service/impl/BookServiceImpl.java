package lk.ijse.service.impl;

import lk.ijse.dto.BookDto;
import lk.ijse.entity.Book;
import lk.ijse.repository.BookRepository;
import lk.ijse.repository.RepositoryFactory;
import lk.ijse.service.BookService;
import lk.ijse.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    BookRepository bookRepository = (BookRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.BOOK);
    private Session session;
    @Override
    public Long saveBook(BookDto bookDto) {

        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            bookRepository.setSession(session);
            System.out.println("Check3");
            Long id = bookRepository.save(bookDto.toEntity());
            System.out.println("amme amme");
            System.out.println(id);
            System.out.println("Check4");
            transaction.commit();
            System.out.println("Check5");
            session.close();
            return id;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return -1L;
        }

    }

    @Override
    public List<BookDto> getAllBooks() {
        session=SessionFactoryConfig.getInstance().getSession();

        bookRepository.setSession(session);
        List<Book> allBooks=bookRepository.getAll();
        List<BookDto> dtoList=new ArrayList<>();
        for (Book book: allBooks){
            dtoList.add(book.toDto());
        }
        return dtoList;
    }

    @Override
    public BookDto getBook(long id) {
        session=SessionFactoryConfig.getInstance().getSession();
        bookRepository.setSession(session);
        BookDto bookDto= bookRepository.get(id).toDto();
        session.close();
        return bookDto;
    }

    @Override
    public boolean deleteBook(BookDto bookDto) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            bookRepository.setSession(session);
            bookRepository.delete(bookDto.toEntity()); // We pass it to the repository by converting it to an entity
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close();
            return false;
        }
    }

    @Override
    public boolean updateBook(BookDto bookDto) {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            bookRepository.setSession(session);
            bookRepository.update(bookDto.toEntity());
            transaction.commit();
            session.close();
            return  true;

        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close();
            return false;
        }
    }


//    public Long saveUsers(UserDto user) {
//        session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        try{
//            userRepository.setSession(session);
//            Long id = userRepository.save(user.toEntity());;
//            transaction.commit();
//            session.close();
//            return id;
//        } catch (Exception e) {
//            transaction.rollback();
//            session.close();
//            e.printStackTrace();
//            return -1L;
//        }
//    }
}
