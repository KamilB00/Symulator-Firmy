package dataBase;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import symulator.app.person.Worker;

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
    private ArrayList<Worker> getAllWorkers() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/simulationDataBase?serverTimezone=UTC", "admin", "pass");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from worker");
        ArrayList<Worker> workersList = new ArrayList<>();
        while (rs.next()) {
            Worker worker = Worker.getInstance();
            worker.setId(rs.getInt("ID"));
            worker.setEfficiency(rs.getDouble("EFFICIENCY"));
            worker.setPosition(rs.getString("POSITION"));
            worker.setSalary(rs.getDouble("SALARY"));

            workersList.add(worker);
        }
        return workersList;
    }
    public void showDB() throws SQLException, ClassNotFoundException {
        ArrayList<Worker> workersList = getAllWorkers();

        for(int i=0; i<workersList.size(); i++){
            System.out.print(workersList.get(i).getPosition()+" ");
            System.out.println(workersList.get(i).getEfficiency());
        }

    }

}
