package lk.ijse.repository;

import lk.ijse.repository.impl.*;

public class RepositoryFactory {
    static RepositoryFactory repositoryFactory;
    private RepositoryFactory(){}

    public static RepositoryFactory getRepositoryFactory(){
        return repositoryFactory == null ? new RepositoryFactory() : repositoryFactory;
    }

    public enum RepositoryTypes{
        LOGIN, USER , BOOK ,BRANCH ,ORDER,ORDER_DETAIL
    }

    public SuperRepository getRepository(RepositoryTypes repositoryTypes){
        switch (repositoryTypes){
           // case LOGIN:return new LoginRepositoryImpl();
            case USER: return new UserRepositoryImpl();
            case BOOK:return new BookRepositoryImpl();
            case BRANCH:return new BranchRepositoryImpl();
            case ORDER:return new OrderRepositoryImpl();
            case ORDER_DETAIL:return new OrderDetailRepositoryImpl();
            default:return null;
        }
    }
}
