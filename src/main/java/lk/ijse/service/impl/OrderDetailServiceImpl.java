package lk.ijse.service.impl;

import lk.ijse.dto.OrderDetailDto;
import lk.ijse.dto.OrdersDto;
import lk.ijse.repository.OrderDetailRepository;
import lk.ijse.repository.RepositoryFactory;
import lk.ijse.service.OrderDetailService;
import lk.ijse.util.SessionFactoryConfig;
import org.hibernate.Session;

public class OrderDetailServiceImpl implements OrderDetailService {
    private Session session;
    OrderDetailRepository orderDetailRepository = (OrderDetailRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.ORDER_DETAIL);

    @Override
    public OrderDetailDto get(OrdersDto ordersDto) {
        session = SessionFactoryConfig.getInstance().getSession();
        orderDetailRepository.setSession(session);
        return orderDetailRepository.get(ordersDto.toEntity()).toDto();
    }

}
