package symulator.gui;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class FormController {


    @FXML
    private ComboBox comboBox;


    @FXML
    public void initialize()
    {
        comboBox.getItems().add("Kredyt");
    }
}
