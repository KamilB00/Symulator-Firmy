package symulator.gui;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import symulator.app.company.Company;
import symulator.app.finance.OwnCapital;

import java.io.IOException;

public class OwnCapitalController {
    OwnCapital ownCapital = OwnCapital.getInstance();
    Company company = Company.getInstance();

    @FXML
    private TextField textfieldOwnCapital1;

    @FXML
    private Button buttonOwnCapital1;

    @FXML
    private Button buttonOwnCapital2;


    @FXML
    public void backToForm(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) buttonOwnCapital1.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void confirmOwnCapital() {
        if (validate(textfieldOwnCapital1.getText())) {
            double amount = Double.parseDouble(textfieldOwnCapital1.getText());
            if (amount >= company.minimalCosts() && amount <=10000000) {
                ownCapital.setAmount(amount);
                Notifications notificationbuilder = Notifications.create()
                        .text("Zatwierdzono warunki")
                        .graphic(null)
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.TOP_RIGHT);
                notificationbuilder.showInformation();
                Stage stage = (Stage) buttonOwnCapital2 .getScene().getWindow();
                stage.close();
            }
            else if(amount<company.minimalCosts() || amount>company.minimalCosts()) {
                Notifications notificationbuilder = Notifications.create()
                        .text("kwota musi zawierać się w przedziale od "+company.minimalCosts()+" do 10.000.000.0")
                        .graphic(null)
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.TOP_RIGHT);
                notificationbuilder.showInformation();
            }
        }
        else {
            Notifications notificationbuilder = Notifications.create()
                    .text("Podano nieprawidłowy znak")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);
            notificationbuilder.showError();
        }
    }

    public boolean validate (String str){
        String regex = "\\d+";
        return str.matches(regex);
    }
}
