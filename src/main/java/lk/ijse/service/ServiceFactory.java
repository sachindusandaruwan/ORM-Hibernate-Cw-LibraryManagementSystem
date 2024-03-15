package lk.ijse.service;

import lk.ijse.service.impl.*;

public class ServiceFactory {
    static ServiceFactory serviceFactory;
    private ServiceFactory(){}

    public static ServiceFactory getServiceFactory(){
        return serviceFactory == null ? new ServiceFactory() : serviceFactory;
    }
    public enum ServiceTypes{
        LOGIN, USER,BOOK,BRANCH,ORDER,ORDER_DETAIL,PLACE_ORDER,RETURN_BOOK
    }

    public SuperService getService(ServiceTypes serviceTypes){
        switch (serviceTypes){
            case LOGIN: return new LoginServiceImpl();
            case USER: return new UserServiceImpl();
            case BOOK:return new BookServiceImpl();
            case BRANCH:return new BranchServiceImpl();
            case ORDER:return new OrderServiceImpl();
            case ORDER_DETAIL:return new OrderDetailServiceImpl();
            case PLACE_ORDER:return new PlaceOrderServiceImpl();
            case RETURN_BOOK: return new ReturnBookServiceImpl();
            default: return null;
        }
    }
}
