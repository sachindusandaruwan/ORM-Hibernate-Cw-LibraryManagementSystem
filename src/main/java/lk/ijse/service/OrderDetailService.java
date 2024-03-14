package lk.ijse.service;

import lk.ijse.dto.OrderDetailDto;
import lk.ijse.dto.OrdersDto;

public interface OrderDetailService extends SuperService{
    OrderDetailDto get(OrdersDto ordersDto);
}
