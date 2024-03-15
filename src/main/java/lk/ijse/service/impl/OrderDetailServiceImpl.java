package lk.ijse.service.impl;

import lk.ijse.dto.OrderDetailDto;
import lk.ijse.dto.OrdersDto;
import lk.ijse.entity.OrderDetail;
import lk.ijse.repository.OrderDetailRepository;
import lk.ijse.repository.RepositoryFactory;
import lk.ijse.service.OrderDetailService;
import lk.ijse.util.SessionFactoryConfig;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {
    private Session session;
    OrderDetailRepository orderDetailRepository = (OrderDetailRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.ORDER_DETAIL);

    @Override
    public OrderDetailDto get(OrdersDto ordersDto) {
        session = SessionFactoryConfig.getInstance().getSession();
        orderDetailRepository.setSession(session);
        return orderDetailRepository.get(ordersDto.toEntity()).toDto();
    }

    @Override
    public List<OrderDetailDto> getAllOD() {
        session = SessionFactoryConfig.getInstance().getSession();
        orderDetailRepository.setSession(session);
        List<OrderDetail> all = orderDetailRepository.getAll();
        List<OrderDetailDto> dtoList = new ArrayList<>();
        for (OrderDetail orderDetail : all){
            dtoList.add(orderDetail.toDto());
        }
        return dtoList;
    }

}
