package symulator.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import symulator.app.finance.Investor;
import symulator.simulation.Randomise;

import java.io.IOException;

public class InvestorController {

    @FXML
    private TextField textfieldInvestor1, textfieldInvestor2,textfieldInvestor3;

    @FXML
    private Button buttonInvestor1, buttonInvestor2;

    Investor investor = Investor.getInstance();
    Randomise randomise = Randomise.getInstance();

    private Integer time = randomise.randomInvestorTime();
    private Double offeredAmount = randomise.randomInvestorAmount();
    private Double yearProfit = randomise.randomInvestorYearProfit();

    /**
     * INICJALIZACJA WARTOŚCI W FORMULARZU INWESTORA
     */
    @FXML
    public void initialize()
    {
        Integer t = time*12;
        Double yp = yearProfit*100;

        textfieldInvestor1.setText(offeredAmount.toString());
        textfieldInvestor2.setText(yp.toString());
        textfieldInvestor3.setText(t.toString());
    }

    /**
     * POWRÓT DO FORMULARZA GŁÓWNEGO
     * @param mouseEvent
     * @throws IOException
     */
    @FXML
    public void backToForm(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) buttonInvestor1 .getScene().getWindow();
        stage.close();
    }

    /**
     * ZATWIERDZENIE WARUNKÓW UMOWY Z INWESTOREM
     */
    @FXML
    public void confirmInvestorsConditions(){
       investor.setYearProfit(yearProfit);
       investor.setTime(time);
       investor.setOfferedAmount(offeredAmount);
        Stage stage = (Stage) buttonInvestor2 .getScene().getWindow();
        stage.close();
    }


}
