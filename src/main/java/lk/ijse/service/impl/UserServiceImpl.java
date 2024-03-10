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
    public User get(long id) {
        return null;
    }
}
