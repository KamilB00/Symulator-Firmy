package symulator.gui;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;

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


}
