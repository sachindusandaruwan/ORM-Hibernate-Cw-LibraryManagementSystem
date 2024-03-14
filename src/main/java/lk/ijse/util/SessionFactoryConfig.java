package lk.ijse.util;

import lk.ijse.entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

public class SessionFactoryConfig {
    private static SessionFactoryConfig factoryConfiguration;
    private final SessionFactory sessionFactory;

    /**
     * Private Default Constructor
     * Restricts creating new instances again and again
     * from this class from outside this class
     */
    private SessionFactoryConfig() {
        sessionFactory = new Configuration()
                .mergeProperties(Utility.getProperties())
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Branch.class)
                .addAnnotatedClass(Orders.class)
                .addAnnotatedClass(OrderDetail.class)
                .buildSessionFactory();
    }

    /**
     * @return lk.ijse.gdse.hibernate.util.SessionFactoryConfiguration
     * Purpose of this method is to get an Instance of this same class
     * by limiting the object recreation (Limiting again and again Object creation)
     */
    public static SessionFactoryConfig getInstance() {
        return (null == factoryConfiguration)
                ? factoryConfiguration = new SessionFactoryConfig()
                : factoryConfiguration;
    }

    /**
     * @return org.hibernate.Session
     * @throws HibernateException
     * Purpose of this method is to get a Session from the Session Factory
     */
    public Session getSession() throws HibernateException {
        // Opens a new Session through the Session Factory & returns the Session created
        return sessionFactory.openSession();
    }
}
