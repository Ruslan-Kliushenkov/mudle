package dao;

import org.hibernate.SessionFactory;
import entities.Horse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import entities.Trace;
import utils.HibernateUtil;

import java.util.List;

public class HorseDao {
    public void saveHorse(Horse horse) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(horse);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Horse getHorse(int id) {

        Transaction transaction = null;
        Horse horse = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            horse = session.get(Horse.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return horse;
    }

    public List<Trace> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from HORSEs");
        List traces = query.list();
        session.getTransaction().commit();
        sessionFactory.close();
        return traces;
    }
}