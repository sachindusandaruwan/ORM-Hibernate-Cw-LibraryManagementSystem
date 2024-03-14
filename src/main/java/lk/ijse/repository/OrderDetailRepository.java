package lk.ijse.repository;

import lk.ijse.entity.OrderDetail;
import lk.ijse.entity.Orders;
import org.hibernate.Session;

public interface OrderDetailRepository extends CrudRepository<OrderDetail,Long>{
    void setSession(Session session);


    public OrderDetail get(Orders orders);

    boolean saveOrderDetail(OrderDetail orderDetail);
}
