package lk.ijse.service;

import lk.ijse.dto.UserDto;
import lk.ijse.projection.UserIds;

import java.util.List;

public interface UserService extends SuperService{
    public Long saveUsers(UserDto user);
    public List<UserDto> getAllUsers();
    public List<UserIds> getAllIds();
    public UserDto getUser(long id);
    public boolean deleteUser(UserDto userDto);
    public boolean updateUser(UserDto userDto);
}
