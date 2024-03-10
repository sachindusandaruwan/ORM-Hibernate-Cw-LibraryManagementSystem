package lk.ijse.service;

import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;
import lk.ijse.projection.UserIds;

import java.util.List;

public interface UserService extends SuperService{
    public Long saveUsers(UserDto user);
    public List<UserDto> getAllUsers();
    public List<UserIds> getAllIds();
    public User get(long id);
}
