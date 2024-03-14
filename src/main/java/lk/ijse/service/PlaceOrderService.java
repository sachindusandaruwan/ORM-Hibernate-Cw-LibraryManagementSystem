package lk.ijse.service;

import lk.ijse.dto.PlaceOrderDto;

public interface PlaceOrderService extends SuperService{
    boolean placeOrder(PlaceOrderDto placeOrderDto);
}
