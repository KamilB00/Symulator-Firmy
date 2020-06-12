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
    public ArrayList<WorkerEntity> getAllWorkers() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/simulationDataBase?serverTimezone=UTC", "admin", "pass");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from worker");
        ArrayList<WorkerEntity> workersList = new ArrayList<>();
        while (rs.next()) {
            WorkerEntity worker = new WorkerEntity(rs.getString("POSITION"),rs.getDouble("SALARY"),rs.getDouble("EFFICIENCY"), rs.getBoolean("AVAILABILITY") );
            worker.setId(rs.getInt("ID"));
            workersList.add(worker);
        }
        return workersList;
    }

    public void showDB() throws SQLException, ClassNotFoundException {

        ArrayList<WorkerEntity> workersList = getAllWorkers();

        for(int i=0; i<workersList.size(); i++){

            System.out.print(workersList.get(i).getId()+" ");
            System.out.print(workersList.get(i).getPosition()+" ");
            System.out.print(workersList.get(i).getEfficiency()+" ");
            System.out.println(workersList.get(i).getSalary()+" ");


        }

    }


}
