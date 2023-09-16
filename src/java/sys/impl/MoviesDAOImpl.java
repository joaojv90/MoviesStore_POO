package sys.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.MoviesDAO;
import sys.model.Movie;
import sys.util.HibernateUtil;


public class MoviesDAOImpl implements MoviesDAO{

    @Override
    public List<Movie> select() {
        List<Movie> movies = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        String hql = "FROM Movie";
        try{
            movies = session.createQuery(hql).list();
            trans.commit();
        } catch (Exception ex){
            ex.printStackTrace();
            trans.rollback();
        } finally{
            session.close();
        }
        return movies;
    }

    @Override
    public void insert(Movie movie) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(movie);
            session.getTransaction().commit();
        } catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally{
            session.close();
        }
    }

    @Override
    public void update(Movie movie) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(movie);
            session.getTransaction().commit();
        } catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Movie movie) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(movie);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally{
            session.close();
        }
    }
    
}
