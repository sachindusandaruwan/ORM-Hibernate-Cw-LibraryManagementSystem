package lk.ijse.repository.impl;

import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;
import lk.ijse.projection.UserIds;
import lk.ijse.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private Session session;
    public void setSession(Session session){
        this.session = session;
    }
    @Override
    public Long save(User user) {
        return (Long) session.save(user);
    }

    @Override
    public void update(User object) {

    }

    @Override
    public User get(Long id) {
        return session.get(User.class, id);
    }

    @Override
    public void delete(User object) {

    }


    @Override
    public List<User> getAll() {
        String sqlQuery = "FROM User";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<UserIds> getAllIds() {
        return null;
    }
}
