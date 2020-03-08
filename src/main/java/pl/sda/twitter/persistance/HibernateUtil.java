package pl.sda.twitter.persistance;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    @Getter
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static  SessionFactory buildSessionFactory() {
        try{
            return new Configuration()
                    .configure()
                    .buildSessionFactory();
        } catch (Throwable e){
            System.err.println("Initial SessionFactory creation failed" + e);
            throw new ExceptionInInitializerError(e);
        }
    }
}
