package lk.ijse.service;

import lk.ijse.dto.BookDto;

import java.util.List;

public interface BookService extends  SuperService{
    Long saveBook(BookDto bookDto);

    List<BookDto> getAllBooks();

    BookDto getBook(long id);

    boolean deleteBook(BookDto bookDto);


    boolean updateBook(BookDto bookDto);
}
