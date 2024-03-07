package lk.ijse.repository.impl;

import lk.ijse.entity.User;
import lk.ijse.projection.UserIds;
import lk.ijse.repository.UserRepository;
import org.hibernate.Session;

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
        return null;
    }

    @Override
    public List<UserIds> getAllIds() {
        return null;
    }
}
