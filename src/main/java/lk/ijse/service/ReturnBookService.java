package lk.ijse.service;

import lk.ijse.dto.BookDto;
import lk.ijse.dto.OrdersDto;

public interface ReturnBookService extends SuperService{
    boolean returnBook(OrdersDto ordersDto, BookDto bookDto);
}
