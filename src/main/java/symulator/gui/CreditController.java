package symulator.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import symulator.app.finance.Bank;


import javax.management.Notification;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Random;

public class CreditController extends Bank {

    @FXML
    private TextField textfieldAmount, textfieldPercentage, textfieldInstalments,textfieldPredictions;

    public void setTextfieldAmount(TextField textfieldAmount) {
        this.textfieldAmount = textfieldAmount;
    }
    public void setTextfieldInstalments(TextField textfieldInstalments) {
        this.textfieldInstalments = textfieldInstalments;
    }
    public void setTextfieldPercentage(TextField textfieldPercentage) {
        this.textfieldPercentage = textfieldPercentage;
    }
    public void setTextfieldPredictions(TextField textfieldPredictions) {
        this.textfieldPredictions = textfieldPredictions;
    }

    @FXML
    private Button buttonCredit1, buttonCredit2;

    @FXML
    public void initialize() {}
    
    @FXML
    public void backToForm(MouseEvent mouseEvent) throws IOException {

        Stage stage = (Stage) buttonCredit1 .getScene().getWindow();
        stage.close();
    }

    @FXML
    public void confirmCreditConditions(MouseEvent mouseEvent) throws IOException {

        if (validate(textfieldAmount.getText())){
           double amount = Double.parseDouble(textfieldAmount.getText());
           if((amount>=100000)&&(amount<=10000000)){
               setTextfieldAmount(textfieldAmount);
               Stage stage = (Stage) buttonCredit1 .getScene().getWindow();
               stage.close();
           }
           else {
               System.out.println("wyswietlam powiadomienie");
               Notifications notificationbuilder = Notifications.create()
               .title("Powiadomienie")
               .text("Podana kwota musi zawierać się w przedziale 100.000 do 10.000.000")
                       .graphic(null)
                       .hideAfter(Duration.seconds(5))
                       .position(Pos.TOP_RIGHT);
               notificationbuilder.showWarning();
               }

        }
        else {
            System.out.println("znaki niezgodne z regex");
        }

    }

    public boolean validate (String str){
        String regex = "\\d+";
        return str.matches(regex);

    }

}
