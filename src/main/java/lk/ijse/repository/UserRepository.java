package lk.ijse.repository;

import lk.ijse.entity.User;
import lk.ijse.projection.UserIds;
import org.hibernate.Session;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {
    public void setSession(Session session);
    public List<User> getAll();
    public List<UserIds> getAllIds();

    Long isExists(String userName);

    User getCustomerUsingUsername(String userName);
}
