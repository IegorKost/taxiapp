package com.iegor.itlabs.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Iegor on 06.08.2014.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
