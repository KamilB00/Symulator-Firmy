package symulator.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class InvestorController {

    @FXML
    private TextField textfieldInvestor1, textfieldInvestor2;

    @FXML
    private Button buttonInvestor1, buttonInvestor2;


    @FXML
    public void initialize()
    {

    }

    @FXML
    public void backToForm(MouseEvent mouseEvent) throws IOException {

        Stage stage = (Stage) buttonInvestor1 .getScene().getWindow();
        stage.close();
    }
}
