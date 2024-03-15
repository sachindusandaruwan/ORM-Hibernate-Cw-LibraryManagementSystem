package lk.ijse.service;

import lk.ijse.dto.OrdersDto;
import lk.ijse.dto.UserDto;

import java.util.List;

public interface OrderService extends SuperService{

    int getOrderId();



    List<OrdersDto> getOrderByUserId(UserDto userDto);

    List<OrdersDto> getAllOrders();

    OrdersDto get(long orderId);

    boolean updateOrder(OrdersDto ordersDto);
}
