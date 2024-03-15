package lk.ijse.service.impl;

import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;
import lk.ijse.projection.UserIds;
import lk.ijse.repository.RepositoryFactory;
import lk.ijse.repository.UserRepository;
import lk.ijse.service.UserService;
import lk.ijse.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private Session session;
    UserRepository userRepository = (UserRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.USER);

    @Override
    public Long saveUsers(UserDto user) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            userRepository.setSession(session);
            Long id = userRepository.save(user.toEntity());;
            transaction.commit();
            session.close();
            return id;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return -1L;
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        session = SessionFactoryConfig.getInstance().getSession();
        userRepository.setSession(session);
        List<User> allUsers = userRepository.getAll();
        List<UserDto> dtoList = new ArrayList<>();
        for (User user : allUsers){
            dtoList.add(user.toDto());
        }
        return dtoList;
    }

    @Override
    public List<UserIds> getAllIds() {
        return null;
    }

    @Override
    public UserDto getUser(long id) {
         session=SessionFactoryConfig.getInstance().getSession();
         userRepository.setSession(session);
        System.out.println("tea 1");
        System.out.println(id);
         UserDto userDto= userRepository.get(id).toDto();
         session.close();
         return userDto;
    }

    @Override
    public boolean deleteUser(UserDto userDto) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userRepository.setSession(session);
            userRepository.delete(userDto.toEntity()); // We pass it to the repository by converting it to an entity
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close();
            return false;
        }
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            userRepository.setSession(session);
            userRepository.update(userDto.toEntity());
            transaction.commit();
            session.close();
            return  true;

        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close();
            return false;
        }
    }

    @Override
    public boolean isExists(String userName) {
        session = SessionFactoryConfig.getInstance().getSession();
        userRepository.setSession(session);
        Long exists = userRepository.isExists(userName);
        return exists!=0;
    }

    @Override
    public UserDto getUserUsingUsername(String userName) {
        session = SessionFactoryConfig.getInstance().getSession();
        userRepository.setSession(session);
        User user = userRepository.getCustomerUsingUsername(userName);
        session.close();
        return user.toDto();
    }

    @Override
    public long getCustomerCount() {
        session = SessionFactoryConfig.getInstance().getSession();
        userRepository.setSession(session);
        Long customerCount = userRepository.getCustomerCount();
        session.close();
        return customerCount;
    }


}
