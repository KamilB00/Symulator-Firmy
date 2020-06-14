package dataBase;


import java.sql.*;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class WorkerDAO {
    /**
     * ZAPIS OBIEKTÓW DO BAZY DANYCH
     * @param workerEntity
     */
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

    /**
     * Lista wyciągająca pracowników z bazy
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<WorkerEntity> getAllWorkers() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/simulationDataBase?serverTimezone=UTC", "admin", "pass");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from worker");
        ArrayList<WorkerEntity> workersList = new ArrayList<>();
        while (rs.next()) {
            WorkerEntity worker = new WorkerEntity(rs.getString("POSITION"),rs.getDouble("SALARY"),rs.getDouble("EFFICIENCY"), rs.getBoolean("AVAILABILITY"), rs.getString("GRP"));
            worker.setId(rs.getInt("ID"));
            workersList.add(worker);
        }
        return workersList;
    }

    /**
     * usuwanie zawartości tabeli
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void refreshDB() throws ClassNotFoundException, SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/simulationDataBase?serverTimezone=UTC";
        String username = "admin";
        String password = "pass";
        String sql = "delete from worker";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement();) {

            stmt.executeUpdate(sql);
            System.out.println("Record deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    }



