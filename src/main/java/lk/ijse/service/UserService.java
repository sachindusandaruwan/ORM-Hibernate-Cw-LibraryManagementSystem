package lk.ijse.service;

import lk.ijse.entity.User;
import lk.ijse.projection.UserIds;

import java.util.List;

public interface UserService extends SuperService{
    public Long save(User user);
    public List<User> getAll();
    public List<UserIds> getAllIds();
    public User get(long id);
}
