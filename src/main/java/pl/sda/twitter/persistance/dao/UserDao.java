package pl.sda.twitter.persistance.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.sda.twitter.exceptions.IncorrectLoginOrPasswordException;
import pl.sda.twitter.persistance.HibernateUtil;
import pl.sda.twitter.persistance.entities.TbUser;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import java.io.Serializable;

public class UserDao implements Serializable {
    public TbUser getUserByLogin (String login) throws IncorrectLoginOrPasswordException {
        try (final Session session = HibernateUtil
                .getSESSION_FACTORY()
                .openSession()) {

            final Query q = session.createQuery("select e from "
                    + TbUser.class.getName() + " e where e.login = :username");

            q.setParameter("username", login);
            session.beginTransaction();
            final TbUser singleResult = (TbUser) q.getSingleResult();
            return singleResult;

        } catch (NoResultException | NonUniqueResultException e){
            throw new IncorrectLoginOrPasswordException(e.getMessage());
        }
    }
}
