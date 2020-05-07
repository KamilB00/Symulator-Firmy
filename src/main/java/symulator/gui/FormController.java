package symulator.gui;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class FormController {


    @FXML
    private ComboBox comboboxForm1;


    @FXML
    public void initialize()
    {
        comboboxForm1.getItems().add("Kredyt");
        comboboxForm1.getItems().add("Venture Capitals");
        comboboxForm1.getItems().add("Inwestor");
        comboboxForm1.getItems().add("Własne środki");
    }


}
