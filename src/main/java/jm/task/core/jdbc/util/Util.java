package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class Util implements AutoCloseable{

    public static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        try {
            sessionFactory = new Configuration()
                    .configure(new File("src\\main\\resources\\hibernate.cfg.xml"))
                    .buildSessionFactory();
            return sessionFactory;
        } catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Override
    public void close() throws Exception {
        sessionFactory.close();
    }
}
