package symulator.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import symulator.app.finance.VC;
import symulator.simulation.Randomise;

import java.io.IOException;

public class VCController {
    VC vc = VC.getInstance();
    @FXML
    private TextField textfieldVC1, textfieldVC2;

    @FXML
    private Button buttonVC1, buttonVC2;

    /**
     * INICJALIZACJA WARTOŚCI PO WŁĄCZENIU OKNA VC
     */
    @FXML
    public void initialize()
    {
        Randomise randomise = Randomise.getInstance();
        textfieldVC1.setText(randomise.randomVCAmount().toString());
        textfieldVC2.setText(randomise.randomVCShares().toString());
    }

    /**
     * POWRÓT DO FORMULARZA GŁÓWNEGO
     * @param mouseEvent
     * @throws IOException
     */
    @FXML
    public void backToForm(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) buttonVC1 .getScene().getWindow();
        stage.close();
    }

    /**
     * ZATWIERDZENIE WARUNKÓW UMOWY VC
     */
    @FXML
    public void confirmVCConditions(){
        String amount =  textfieldVC1.getText();
        vc.setAmount(Double.parseDouble(amount));
        String shares = textfieldVC2.getText();
        Double sharesD = Double.parseDouble(shares);
        vc.setShares(sharesD);
        Stage stage = (Stage) buttonVC2 .getScene().getWindow();
        stage.close();
    }

}
