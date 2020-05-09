package symulator.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import java.io.IOException;


public class FormController {


    @FXML
    private ComboBox comboboxForm1;
    @FXML
    private Button startSimulationButton;

    @FXML
    private Button presentationButton;

    @FXML
    private Button buttonForm1;

    @FXML
    public void initialize()
    {
        comboboxForm1.getItems().add("Kredyt");
        comboboxForm1.getItems().add("Venture Capitals");
        comboboxForm1.getItems().add("Inwestor");
        comboboxForm1.getItems().add("Własne środki");

    }
    @FXML
    private void addScene(ActionEvent event)throws IOException{
        Parent view2 = FXMLLoader.load(getClass().getResource("/gui/VC.fxml"));
        Scene scene2 = new Scene(view2);
        Stage window = new Stage();
        window.initStyle(StageStyle.UNDECORATED);
        window.setScene(scene2);
        window.show();
    }

}
