package symulator;

import dataBase.HibernateUtil;
import dataBase.WorkerDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.hibernate.Session;
import symulator.app.person.Worker;
import dataBase.WorkerEntity;
import symulator.simulation.Randomise;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Form.fxml"));
        primaryStage.setTitle("Symulacja firmy");
        primaryStage.setScene(new Scene(root));
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }



}
