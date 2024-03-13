package lk.ijse.service;

import lk.ijse.service.impl.BookServiceImpl;
import lk.ijse.service.impl.BranchServiceImpl;
import lk.ijse.service.impl.LoginServiceImpl;
import lk.ijse.service.impl.UserServiceImpl;

public class ServiceFactory {
    static ServiceFactory serviceFactory;
    private ServiceFactory(){}

    public static ServiceFactory getServiceFactory(){
        return serviceFactory == null ? new ServiceFactory() : serviceFactory;
    }
    public enum ServiceTypes{
        LOGIN, USER,BOOK,BRANCH
    }

    public SuperService getService(ServiceTypes serviceTypes){
        switch (serviceTypes){
            case LOGIN: return new LoginServiceImpl();
            case USER: return new UserServiceImpl();
            case BOOK:return new BookServiceImpl();
            case BRANCH:return new BranchServiceImpl();
            default: return null;
        }
    }
}
