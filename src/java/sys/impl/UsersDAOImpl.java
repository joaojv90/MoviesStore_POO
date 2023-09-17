package sys.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import sys.components.EncryptPassword;
import sys.dao.UsersDAO;
import sys.model.Users;
import sys.util.HibernateUtil;


public class UsersDAOImpl implements UsersDAO{

    @Override
    public Users search(Users users) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql="FROM Users WHERE mail=:userMail";
        Query query = session.createQuery(hql);
        query.setParameter("userMail", users.getMail());
        return (Users) query.uniqueResult();
    }

    @Override
    public Users login(Users users) {
        Users usersLogin = search(users);
        if(usersLogin != null){
            if(!usersLogin.getPassword().equals(EncryptPassword.sha512(users.getPassword()))){
                usersLogin = null;
            }
        }
        return usersLogin;
    }
    
}
