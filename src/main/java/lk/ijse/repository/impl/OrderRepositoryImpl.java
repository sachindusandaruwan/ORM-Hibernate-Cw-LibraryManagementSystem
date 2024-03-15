package lk.ijse.repository.impl;

import lk.ijse.entity.Orders;
import lk.ijse.entity.User;
import lk.ijse.repository.OrderRepository;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private Session session;

    @Override
    public Long save(Orders orders) {
        return (Long) session.save(orders);
    }

    @Override
    public void update(Orders orders) {
        session.update(orders);

    }

    @Override
    public Orders get(Long oId) {
        return session.get(Orders.class,oId);
    }

    @Override
    public void delete(Orders object) {

    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public List getOrderId() {

        System.out.println("test x");
        String hql = "SELECT orderId FROM Orders WHERE id = (SELECT MAX(id) FROM Orders)";
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        return query.list();
    }

    @Override
    public List<Orders> getOrderByUserId(User user) {
        /*System.out.println("88888888888888888888888");
        CriteriaBuilder builder = session.getCriteriaBuilder();
        System.out.println("555555555555555555");
        CriteriaQuery<Orders> criteria = builder.createQuery(Orders.class);
        System.out.println("666666666666666666666666666666666");
        Root<Orders> root = criteria.from(Orders.class);

        criteria.select(root);
        criteria.where(builder.equal(root.get("user"), user));
        System.out.println("777777777777777777777777777");

        List<Orders> resultList = session.createQuery(criteria).getResultList();
        return resultList;*/
        try {
            System.out.println("88888888888888888888888");
            CriteriaBuilder builder = session.getCriteriaBuilder();
            System.out.println("555555555555555555");
            CriteriaQuery<Orders> criteria = builder.createQuery(Orders.class);
            System.out.println("666666666666666666666666666666666");
            Root<Orders> root = criteria.from(Orders.class);

            criteria.select(root);
            criteria.where(builder.equal(root.get("user"), user));
            System.out.println("777777777777777777777777777");

            List<Orders> resultList = session.createQuery(criteria).getResultList();
            return resultList;
        } catch (Exception e) {
            // Properly handle exceptions
            // Log the exception or re-throw it depending on your application's requirements
            e.printStackTrace();
            return Collections.emptyList(); // or throw a custom exception
        }
    }

    @Override
    public List<Orders> getAll() {
        String hql = "FROM Orders ";
        org.hibernate.query.Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
    }


}
