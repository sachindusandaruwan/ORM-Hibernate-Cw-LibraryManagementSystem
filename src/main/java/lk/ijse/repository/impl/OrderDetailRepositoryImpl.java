package lk.ijse.repository.impl;

import lk.ijse.entity.OrderDetail;
import lk.ijse.entity.Orders;
import lk.ijse.repository.OrderDetailRepository;
import lk.ijse.repository.OrderRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class OrderDetailRepositoryImpl implements OrderDetailRepository {
    private Session session;
    @Override
    public Long save(OrderDetail object) {
        return null;
    }

    @Override
    public void update(OrderDetail object) {

    }

    @Override
    public OrderDetail get(Long aLong) {
        return null;
    }

    @Override
    public void delete(OrderDetail object) {

    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public OrderDetail get(Orders orders) {
        String hql = "FROM OrderDetail WHERE order = :order";
        Query<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
        query.setParameter("order", orders);
        return query.uniqueResult();
    }

    @Override
    public boolean saveOrderDetail(OrderDetail orderDetail) {
        session.save(orderDetail);
        return true;
    }


}
