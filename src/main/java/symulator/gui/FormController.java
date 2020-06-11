package symulator.gui;

import dataBase.WorkerDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import symulator.app.company.Company;
import symulator.app.finance.Bank;
import symulator.app.finance.Investor;
import symulator.app.finance.OwnCapital;
import symulator.app.finance.VC;
import symulator.simulation.SimulationClock;
import java.io.IOException;
import java.sql.SQLException;


public  class FormController {
    Company company = Company.getInstance();
    SimulationController simulationController=null;
    WorkerDAO workerDAO = new WorkerDAO();
    Bank bank = Bank.getInstance();
    Investor investor = Investor.getInstance();
    OwnCapital ownCapital = OwnCapital.getInstance();
    VC vc = VC.getInstance();

    @FXML
    private ComboBox<String> comboboxForm1;
    ObservableList<String> list = FXCollections.observableArrayList("Kredyt","Własne środki","Venture Capitals","Inwestor");
    @FXML
    private Button startSimulationButton;
    @FXML
    private Button presentationButton;
    @FXML
    private Button buttonForm1;
    @FXML
    private Slider sliderFormTime;
    @FXML
    private Slider sliderFormEmployee1;
    @FXML
    private Slider sliderFormEmployee2;
    @FXML
    private Slider sliderFormEmployee3;
    @FXML
    private Slider sliderFormEmployee4;
    @FXML
    private Slider sliderFormEmployee5;
    @FXML
    private Slider sliderFormEmployee6;
    @FXML
    private Slider sliderFormProjects;
    @FXML
    private RadioButton radioButtonLeasing;
    @FXML
    private RadioButton radioButtonBuy;
    @FXML
    private RadioButton radioButtonInstallments;
    @FXML
    private RadioButton radioButtonOffice;
    @FXML
    private RadioButton radioButtonRemote;

    //================================================================================================================
    @FXML
    public Slider getSliderFormEmployee1() {
        return sliderFormEmployee1;
    }
    @FXML
    public Slider getSliderFormEmployee2() {
        return sliderFormEmployee2;
    }
    @FXML
    public Slider getSliderFormEmployee3() {
        return sliderFormEmployee3;
    }
    @FXML
    public Slider getSliderFormEmployee4() {
        return sliderFormEmployee4;
    }
    @FXML
    public Slider getSliderFormEmployee5() {
        return sliderFormEmployee5;
    }
    @FXML
    public Slider getSliderFormEmployee6() {
        return sliderFormEmployee6;
    }
    @FXML
    public Slider getSliderFormProjects() {
        return sliderFormProjects;
    }
    @FXML
    public Slider getSliderFormTime() {
        return sliderFormTime;
    }
    //================================================================================================================
    @FXML
    public void setSliderFormEmployee1(Slider sliderFormEmployee1) {
        this.sliderFormEmployee1 = sliderFormEmployee1;
    }
    @FXML
    public void setSliderFormTime(Slider sliderFormTime) {
        this.sliderFormTime = sliderFormTime;
    }
    @FXML
    public void setSliderFormEmployee2(Slider sliderFormEmployee2) {
        this.sliderFormEmployee2 = sliderFormEmployee2;
    }
    @FXML
    public void setSliderFormEmployee3(Slider sliderFormEmployee3) {
        this.sliderFormEmployee3 = sliderFormEmployee3;
    }
    @FXML
    public void setSliderFormEmployee4(Slider sliderFormEmployee4) {
        this.sliderFormEmployee4 = sliderFormEmployee4;
    }
    @FXML
    public void setSliderFormEmployee5(Slider sliderFormEmployee5) {
        this.sliderFormEmployee5 = sliderFormEmployee5;
    }
    @FXML
    public void setSliderFormEmployee6(Slider sliderFormEmployee6) {
        this.sliderFormEmployee6 = sliderFormEmployee6;
    }
    @FXML
    public void setSliderFormProjects(Slider sliderFormProjects) {
        this.sliderFormProjects = sliderFormProjects;
    }

    //================================================================================================================


    @FXML
    public void initialize()
    {

        simulationController = new SimulationController();
        comboboxForm1.setItems(list);

        setSliderFormTime(sliderFormTime);
        setSliderFormEmployee1(sliderFormEmployee1);
        setSliderFormEmployee2(sliderFormEmployee2);
        setSliderFormEmployee3(sliderFormEmployee3);
        setSliderFormEmployee4(sliderFormEmployee4);
        setSliderFormEmployee5(sliderFormEmployee5);
        setSliderFormEmployee6(sliderFormEmployee6);
        setSliderFormProjects(sliderFormProjects);

        company.setJuniorProgrammersNumber(1);
        company.setRegularProgrammersNumber(1);
        company.setSeniorProgrammersNumber(1);
        company.setMarketersNumber(1);
        company.setProjectManagersNumber(1);
        company.setAccountantsNumber(1);
        company.setOrderAtOnce(1);



    }
    //================================================================================================================
    @FXML
    public void addSceneCredit()throws IOException{
        Parent view2 = FXMLLoader.load(getClass().getResource("/gui/Credit.fxml"));
        Scene scene2 = new Scene(view2);
        Stage window = new Stage();
        window.setAlwaysOnTop(true);
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.UNDECORATED);
        window.setScene(scene2);
        window.show();
    }
    @FXML
    public void addSceneOwnCapital()throws IOException{
        Parent view2 = FXMLLoader.load(getClass().getResource("/gui/OwnCapital.fxml"));
        Scene scene2 = new Scene(view2);
        Stage window = new Stage();
        window.setAlwaysOnTop(true);
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.UNDECORATED);
        window.setScene(scene2);
        window.show();
    }
    @FXML
    public void addSceneInvestor()throws IOException{
        Parent view2 = FXMLLoader.load(getClass().getResource("/gui/Investor.fxml"));
        Scene scene2 = new Scene(view2);
        Stage window = new Stage();
        window.setAlwaysOnTop(true);
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.UNDECORATED);
        window.setScene(scene2);
        window.show();
    }
    @FXML
    public void addSceneVC()throws IOException{
        Parent view2 = FXMLLoader.load(getClass().getResource("/gui/VC.fxml"));
        Scene scene2 = new Scene(view2);
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.UNDECORATED);
        window.setScene(scene2);
        window.show();
    }
    @FXML
    public void switchStageStart(ActionEvent event) throws IOException, InterruptedException, SQLException, ClassNotFoundException {
        if((comboboxForm1.getValue()!= null)&&(bank.getAmount()!=0||investor.getOfferedAmount()!=0||ownCapital.getAmount()!=0||vc.getAmount()!=0) ){
            Parent view2 = FXMLLoader.load(getClass().getResource("/gui/Simulation.fxml"));
            Scene scene2 = new Scene(view2);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene2);
            window.show();
            setData();
        }
        else {
            confirmNotification();
        }


    }

//================================================================================================================

public void sliderTime(){
    Double sT = getSliderFormTime().getValue();
    SimulationClock simulationClock = SimulationClock.getInstance();
    simulationClock.setYears(sT.intValue());

}

    public void sliderJuniorProgrammer()throws IOException
    {
        Double sE1 = getSliderFormEmployee1().getValue();

        if(company!=null)
            company.setJuniorProgrammersNumber(sE1.intValue());
    }
    public void sliderRegularProgrammer()throws IOException
    {
        Double sE2 = getSliderFormEmployee2().getValue();

        if(company!=null)
            company.setRegularProgrammersNumber(sE2.intValue());
    }
    public void sliderSeniorProgrammer()throws IOException
    {
        Double sE3 = getSliderFormEmployee3().getValue();

        if(company!=null)
            company.setSeniorProgrammersNumber(sE3.intValue());
    }
    public void sliderProjectManager()throws IOException
    {
        Double sE4 = getSliderFormEmployee4().getValue();

        if(company!=null)
            company.setProjectManagersNumber(sE4.intValue());
    }
    public void sliderMarketer()throws IOException
    {
        Double sE5 = getSliderFormEmployee5().getValue();

        if(company!=null)
            company.setMarketersNumber(sE5.intValue());
    }
    public void sliderAccountant()throws IOException
    {
        Double sE6 = getSliderFormEmployee6().getValue();

        if(company!=null)
            company.setAccountantsNumber(sE6.intValue());
    }
    public void sliderProjects()throws IOException
    {
        Double sP = getSliderFormProjects().getValue();
        if(company!=null)
            company.setOrderAtOnce(sP.intValue());
    }

    //================================================================================================================
    @FXML
    public void confirmation() throws IOException {
        if (comboboxForm1.getValue() == null) {
            chooseConditions();
            }

        else {
            switch (comboboxForm1.getValue()) {
                case "Kredyt":
                    addSceneCredit();
                    refreshFinance();
                    break;
                case "Własne środki":
                    addSceneOwnCapital();
                    refreshFinance();
                    break;
                case "Inwestor":
                    addSceneInvestor();
                    refreshFinance();
                    break;
                case "Venture Capitals":
                    addSceneVC();
                    refreshFinance();
                    break;
            }
        }
    }
    public void refreshFinance(){
        bank.setInstallments(0);
        bank.setAmount(0.0);
        investor.setOfferedAmount(0.0);
        investor.setTime(0);
        investor.setYearProfit(0.0);
        vc.setAmount(0.0);
        vc.setShares(0.0);
        ownCapital.setAmount(0.0);
    }

    @FXML
    public void setData() throws IOException, SQLException, ClassNotFoundException {
    company.createJuniorProgrammers();
    company.createRegularProgrammers();
    company.createSeniorProgrammers();
    company.createAccountants();
    company.createMarketers();
    company.createProjectManagers();
    workerDAO.showDB();
    }
    public void confirmNotification(){
        Notifications notificationbuilder = Notifications.create()
                .title("Błąd")
                .text("Aby rozpocząć musisz zatwierdzić warunki umowy")
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.TOP_RIGHT);
        notificationbuilder.darkStyle();
        notificationbuilder.showError();
    }
    public void chooseConditions(){
        Notifications notificationbuilder = Notifications.create()
                .title("Błąd")
                .text("Wybierz rodzaj umowy")
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.TOP_RIGHT);
        notificationbuilder.darkStyle();
        notificationbuilder.showWarning();
    }

}
