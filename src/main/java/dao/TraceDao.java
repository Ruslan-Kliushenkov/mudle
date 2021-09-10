package dao;

import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entities.Trace;
import utils.HibernateUtil;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class TraceDao {

    @SneakyThrows
    public void createTrace(Trace trace) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Object object = session.save(trace);
            session.get(Trace.class, (Serializable) object);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Trace getTraceById(int id) {

        Transaction transaction = null;
        Trace trace = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = " FROM Trace C WHERE C.id = :traceId";
            Query query = session.createQuery(hql);
            query.setParameter("traceId", id);
            List results = query.getResultList();

            if (results != null && !results.isEmpty()) {
                trace = (Trace) results.get(0);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return trace;
    }

    public List<Trace> getTraces() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Trace", Trace.class).list();
        }
    }

}
