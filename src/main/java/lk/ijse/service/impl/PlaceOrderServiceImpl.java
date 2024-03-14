package lk.ijse.service.impl;

import lk.ijse.dto.PlaceOrderDto;
import lk.ijse.embeded.OrderDetailPrimaryKey;
import lk.ijse.entity.Book;
import lk.ijse.entity.OrderDetail;
import lk.ijse.entity.Orders;
import lk.ijse.repository.*;
import lk.ijse.service.PlaceOrderService;
import lk.ijse.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlaceOrderServiceImpl implements PlaceOrderService {
    private Session session;
    BookRepository bookRepository = (BookRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.BOOK);
    OrderRepository orderRepository = (OrderRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.ORDER);
    OrderDetailRepository orderDetailRepository = (OrderDetailRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.ORDER_DETAIL);
    UserRepository userRepository=(UserRepository)  RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.USER);
    @Override
    public boolean placeOrder(PlaceOrderDto placeOrderDto) {

        System.out.println("mala magulai");

        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();



        userRepository.setSession(session);
        Orders orders = new Orders(placeOrderDto.getOrderId(), placeOrderDto.getDueDate(), userRepository.get(placeOrderDto.getU_Id()), null, null);


        bookRepository.setSession(session);
        Book book = bookRepository.get(placeOrderDto.getB_Id());

        orderRepository.setSession(session);
        Long saveOrder = orderRepository.save(orders);



        orderDetailRepository.setSession(session);
        boolean savedOrderDetail = orderDetailRepository.saveOrderDetail(new OrderDetail(new OrderDetailPrimaryKey(placeOrderDto.getOrderId(), placeOrderDto.getB_Id()), orders, book));

        //book.setQty(book.getQty()-1);
        book.setAvailability("NotAvailable");
        bookRepository.update(book);

        if (saveOrder > 0){
            if (savedOrderDetail){
                transaction.commit();
                return true;
            }
        }else
            transaction.rollback();
        session.close();
        return false;

    }
}
