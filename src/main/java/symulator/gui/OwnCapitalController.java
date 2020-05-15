package symulator.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class OwnCapitalController {

    @FXML
    private TextField textfieldOwnCapital1;

    @FXML
    private Button buttonOwnCapital1, buttonOwnCapital2;


    @FXML
    public void initialize()
    {

    }

    @FXML
    public void backToForm(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) buttonOwnCapital1 .getScene().getWindow();
        stage.close();
    }
}
