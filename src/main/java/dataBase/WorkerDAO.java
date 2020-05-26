package dataBase;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class WorkerDAO {
    public void saveWorker(WorkerEntity workerEntity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(workerEntity);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public List < WorkerEntity > getWorkers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from WorkerEntity", WorkerEntity.class).list();
        }
    }
}
