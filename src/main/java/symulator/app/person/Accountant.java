package symulator.app.person;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import symulator.gui.FormController;

import java.io.IOException;

public class Accountant  extends Worker{

 /*
    TODO
    specjalna funkcja dla ACCOUNTANT
     */


    public Accountant() throws IOException {
    }


    public void setPosition() {
        super.setPosition("Accountant");

    }

  FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Form.fxml"));
    Parent root = loader.load();
  FormController formController = loader.<FormController>getController();

    @Override
    public void setEfficiency(Double efficiency) { setEfficiency(150.0); // do zmiany
    }

    @Override
    public void setNumberOfEmployees(Integer numberOfEmployees) {
        super.setNumberOfEmployees(numberOfEmployees);
    Double number = formController.getSliderFormEmployee1().getValue();


    }



}
