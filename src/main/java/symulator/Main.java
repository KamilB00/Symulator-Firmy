package symulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import symulator.app.company.Company;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Form.fxml"));
        primaryStage.setTitle("Symulacja firmy");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        Company company = new Company();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
