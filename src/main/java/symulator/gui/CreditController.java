package symulator.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class CreditController {

    @FXML
    private TextField textfieldCredit1, textfieldCredit2, textfieldCredit3;

    @FXML
    private Button buttonCredit1, buttonCredit2;


    @FXML
    public void initialize()
    {

    }


    @FXML
    public void backToForm(MouseEvent mouseEvent) throws IOException {

        Stage stage = (Stage) buttonCredit1 .getScene().getWindow();
        stage.close();
    }
}
