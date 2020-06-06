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
import symulator.app.company.Company;
import symulator.app.finance.Bank;
import symulator.simulation.Randomise;
import java.io.IOException;


public class CreditController {
    Randomise randomise = Randomise.getInstance();
    Company company = Company.getInstance();

    @FXML
    private TextField textfieldAmount;
    @FXML
    private TextField textfieldPercentage;
    @FXML
    private TextField textfieldInstalments;
    @FXML
    private TextField textfieldPredictions;

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
    private Button buttonCredit1;
    @FXML
    private Button buttonCredit2;

    @FXML
    public void initialize() {
        Double percentage = randomise.generateBankPercentage()*100;


        textfieldPercentage.setText(percentage.toString());
        textfieldPredictions.setText(company.minimalCosts().toString());
    }

    @FXML
    public void backToForm(MouseEvent mouseEvent) throws IOException {

        Stage stage = (Stage) buttonCredit1 .getScene().getWindow();
        stage.close();
    }
    /**
     * Funkcja sprawdzająca  warunki kredytu, powiadomienia
     */
    @FXML
    public void confirmCreditConditions(MouseEvent mouseEvent) throws IOException {
            Bank bank = Bank.getInstance();
        if(validate(textfieldAmount.getText())){
            if(validate(textfieldInstalments.getText())){
                double amount = Double.parseDouble(textfieldAmount.getText());
                Integer instalments = Integer.parseInt(textfieldInstalments.getText());
                if ((instalments >= 12 && instalments <= 120)&&(amount >= 100000 && amount <= 10000000)){
                    bank.setAmount(amount);
                    bank.setInstallments(instalments);

                    Stage stage = (Stage) buttonCredit2 .getScene().getWindow();
                    stage.close();

                    Notifications notificationbuilder = Notifications.create()
                            .text("Zatwierdzono warunki")
                            .graphic(null)
                            .hideAfter(Duration.seconds(5))
                            .position(Pos.TOP_RIGHT);
                    notificationbuilder.showInformation();
                }

                if(instalments < 12 || instalments > 120) {
                    System.out.println("wyswietlam powiadomienie o instalments");
                    Notifications notificationbuilder = Notifications.create()
                            .title("Ostrzeżenie")
                            .text("Liczba rat musi zawieraćsięw przedziale 12 do 120")
                            .graphic(null)
                            .hideAfter(Duration.seconds(5))
                            .position(Pos.TOP_RIGHT);
                    notificationbuilder.showWarning();
                }
                 if(amount < 100000 || amount > 10000000) {
                    System.out.println("wyswietlam powiadomienie o amount");
                    Notifications notificationbuilder = Notifications.create()
                            .title("Ostrzeżenie")
                            .text("Podana kwota musi zawierać się w przedziale "+100000+"  do 10.000.000")
                            .graphic(null)
                            .hideAfter(Duration.seconds(5))
                            .position(Pos.TOP_RIGHT);
                    notificationbuilder.showWarning();
                }
            }
            else{
                Notifications notificationbuilder = Notifications.create()
                        .title("Błąd")
                        .text("wypełnij wszytkie pola aby zatwierdzić warunki umowy")
                        .graphic(null)
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.TOP_RIGHT);
                notificationbuilder.showError();
            }
        }
        else{
            Notifications notificationbuilder = Notifications.create()
                    .title("Błąd")
                    .text("wypełnij wszytkie pola aby zatwierdzić warunki umowy")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);
            notificationbuilder.showError();
        }
    }
    /**
     * Funkcja walidująca wpisane dane do textfieldAmount oraz textfieldInstalments
     */
    public boolean validate (String str){
        String regex = "\\d+";
        return str.matches(regex);
    }



}
