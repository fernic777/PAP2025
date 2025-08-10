// PERSISTENCIA COMENTADA - Se implementará más adelante con Hibernate
/*
package pap2025.persistencia;

import pap2025.interfaz.IPersistenciaLector;
import pap2025.logica.Lector;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PersistenciaLector implements IPersistenciaLector {
    
    private SessionFactory sessionFactory;
    
    public PersistenciaLector(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public boolean guardarLector(Lector lector) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(lector);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public Lector obtenerLector(String email) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query<Lector> query = session.createQuery(
                "FROM Lector l WHERE l.email = :email", Lector.class);
            query.setParameter("email", email);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public boolean existeLector(String email) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query<Long> query = session.createQuery(
                "SELECT COUNT(l) FROM Lector l WHERE l.email = :email", Long.class);
            query.setParameter("email", email);
            Long count = query.uniqueResult();
            return count != null && count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
*/
