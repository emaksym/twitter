package services;

import pl.sda.twitter.exceptions.IncorrectLoginOrPasswordException;
import pl.sda.twitter.persistance.dao.UserDao;
import pl.sda.twitter.persistance.entities.TbUser;

public class UserService {

    private UserDao userDao = new UserDao();

    public TbUser getUser (String username, String password)
            throws IncorrectLoginOrPasswordException {


        final TbUser user = userDao.getUserByLogin(username);

        if (user==null || !user.getPassword().equals(password)){
            throw new IncorrectLoginOrPasswordException("password or username does not match");
        }


        return user;

    }
}
