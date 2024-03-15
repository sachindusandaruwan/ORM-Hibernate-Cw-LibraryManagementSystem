package lk.ijse.service.impl;

import lk.ijse.dto.OrdersDto;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.Orders;
import lk.ijse.repository.OrderRepository;
import lk.ijse.repository.RepositoryFactory;
import lk.ijse.service.OrderService;
import lk.ijse.service.ServiceFactory;
import lk.ijse.util.SessionFactoryConfig;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private Session session;

    OrderRepository orderRepository=(OrderRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.ORDER);
    @Override
    public int getOrderId() {
        session = SessionFactoryConfig.getInstance().getSession();
        orderRepository.setSession(session);
        System.out.println("mn mekata awa");
        List orderId = orderRepository.getOrderId();
        session.close();
        //System.out.println(orderId.get(0) == null ? 1 : Integer.parseInt(String.valueOf(orderId.get(0))));
        if (!orderId.isEmpty()){
            return Integer.parseInt(String.valueOf(orderId.get(0)))+1;
        }else {
            return -1;
        }
    }

    @Override
    /*public List<OrdersDto> getOrderByUserId(UserDto userDto) {
        session = SessionFactoryConfig.getInstance().getSession();
        orderRepository.setSession(session);
        System.out.println("3333333333333");
        List<Orders> orderByUserId = orderRepository.getOrderByUserId(userDto.toEntity());
        System.out.println("4444444444444444444");
        List<OrdersDto> dtoList = new ArrayList<>();
        for (Orders order : orderByUserId){
            dtoList.add(order.toDto());
        }
        session.close();
        return dtoList;
    }*/
    public List<OrdersDto> getOrderByUserId(UserDto userDto) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            orderRepository.setSession(session);
            System.out.println("3333333333333");
            System.out.println(userDto);
            List<Orders> orderByUserId = orderRepository.getOrderByUserId(userDto.toEntity());
            System.out.println("4444444444444444444");
            List<OrdersDto> dtoList = new ArrayList<>();
            for (Orders order : orderByUserId) {
                dtoList.add(order.toDto());
            }
            return dtoList;
        } catch (Exception e) {
            // Properly handle exceptions
            // Log the exception or re-throw it depending on your application's requirements
            e.printStackTrace();
            return Collections.emptyList(); // or throw a custom exception
        }
    }

    @Override
    public List<OrdersDto> getAllOrders() {
        session = SessionFactoryConfig.getInstance().getSession();
        orderRepository.setSession(session);
        List<Orders> all = orderRepository.getAll();
        List<OrdersDto> dtoList = new ArrayList<>();
        for (Orders orders : all){
            dtoList.add(orders.toDto());
        }
        return dtoList;
    }

    @Override
    public OrdersDto get(long orderId) {
        session = SessionFactoryConfig.getInstance().getSession();
        orderRepository.setSession(session);
        return orderRepository.get(orderId).toDto();
    }

    @Override
    public boolean updateOrder(OrdersDto ordersDto) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            orderRepository.setSession(session);
            orderRepository.update(ordersDto.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }

    }

}
