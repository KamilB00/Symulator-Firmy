package symulator.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class VCController {

    @FXML
    private TextField textfieldVC1, textfieldVC2;

    @FXML
    private Button buttonVC1, buttonVC2;


    @FXML
    public void initialize()
    {

    }

    @FXML
    public void backToForm(MouseEvent mouseEvent) throws IOException {

        Stage stage = (Stage) buttonVC1 .getScene().getWindow();
        stage.close();
    }
}
