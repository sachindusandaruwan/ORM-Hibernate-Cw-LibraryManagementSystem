package lk.ijse.repository;

import lk.ijse.entity.Orders;
import lk.ijse.entity.User;
import org.hibernate.Session;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders,Long>{
    void setSession(Session session);

    List getOrderId();

    List<Orders> getOrderByUserId(User entity);
}
