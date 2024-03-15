package lk.ijse.service;

import lk.ijse.dto.OrderDetailDto;
import lk.ijse.dto.OrdersDto;

import java.util.List;

public interface OrderDetailService extends SuperService{
    OrderDetailDto get(OrdersDto ordersDto);

    List<OrderDetailDto> getAllOD();
}
