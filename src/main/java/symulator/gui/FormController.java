package symulator.gui;

import dataBase.WorkerDAO;
import dataBase.WorkerEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import symulator.app.company.Company;
import symulator.simulation.SimulationClock;


import java.io.IOException;
import java.sql.SQLException;


public  class FormController {
    Company company = Company.getInstance();
    SimulationController simulationController=null;
    WorkerDAO workerDAO = new WorkerDAO();
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
    private TextField counter1;
    @FXML
    private TextField counter2;
    @FXML
    private TextField counter3;
    @FXML
    private TextField counter4;
    @FXML
    private TextField counter5;
    @FXML
    private TextField counter6;

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

        counter1.setText(String.valueOf((int)getSliderFormEmployee1().getValue()));
        counter2.setText(String.valueOf((int)getSliderFormEmployee2().getValue()));
        counter3.setText(String.valueOf((int)getSliderFormEmployee3().getValue()));
        counter4.setText(String.valueOf((int)getSliderFormEmployee4().getValue()));
        counter5.setText(String.valueOf((int)getSliderFormEmployee5().getValue()));
        counter6.setText(String.valueOf((int)getSliderFormEmployee6().getValue()));


        company.setJuniorProgrammersNumber(0);
        company.setRegularProgrammersNumber(0);
        company.setSeniorProgrammersNumber(0);
        company.setMarketersNumber(0);
        company.setProjectManagersNumber(0);
        company.setAccountantsNumber(0);


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
       // window.initStyle(StageStyle.UNDECORATED);
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
       // window.initStyle(StageStyle.UNDECORATED);
        window.setScene(scene2);
        window.show();
    }
    @FXML
    public void addSceneVC()throws IOException{
        Parent view2 = FXMLLoader.load(getClass().getResource("/gui/VC.fxml"));
        Scene scene2 = new Scene(view2);
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
       // window.initStyle(StageStyle.UNDECORATED);
        window.setScene(scene2);
        window.show();
    }
    @FXML
    public void switchStageStart(ActionEvent event) throws IOException, InterruptedException, SQLException, ClassNotFoundException {
        Parent view2 = FXMLLoader.load(getClass().getResource("/gui/Simulation.fxml"));
        Scene scene2 = new Scene(view2);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
       // window.setFullScreen(true);
        setData();
        //System.out.println(simulationClock.simulationTime(simulationClock.getYears()));

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
        counter1.setText(String.valueOf(sE1.intValue()));
        if(company!=null)
            company.setJuniorProgrammersNumber(sE1.intValue());
    }
    public void sliderRegularProgrammer()throws IOException
    {
        Double sE2 = getSliderFormEmployee2().getValue();
        counter2.setText(String.valueOf(sE2.intValue()));
        if(company!=null)
            company.setRegularProgrammersNumber(sE2.intValue());
    }
    public void sliderSeniorProgrammer()throws IOException
    {
        Double sE3 = getSliderFormEmployee3().getValue();
        counter3.setText(String.valueOf(sE3.intValue()));
        if(company!=null)
            company.setSeniorProgrammersNumber(sE3.intValue());
    }
    public void sliderProjectManager()throws IOException
    {
        Double sE4 = getSliderFormEmployee4().getValue();
        counter4.setText(String.valueOf(sE4.intValue()));
        if(company!=null)
            company.setProjectManagersNumber(sE4.intValue());
    }
    public void sliderMarketer()throws IOException
    {
        Double sE5 = getSliderFormEmployee5().getValue();
        counter5.setText(String.valueOf(sE5.intValue()));
        if(company!=null)
            company.setMarketersNumber(sE5.intValue());
    }
    public void sliderAccountant()throws IOException
    {
        Double sE6 = getSliderFormEmployee6().getValue();
        counter6.setText(String.valueOf(sE6.intValue()));
        if(company!=null)
            company.setAccountantsNumber(sE6.intValue());
    }
    public void sliderProjects()throws IOException
    {
        Double sP = getSliderFormProjects().getValue();
        if(company!=null)
            company.setProjectNumber(sP.intValue());
    }

    //================================================================================================================
    @FXML
    public void confirmation() throws IOException {
        if(comboboxForm1.getValue()=="Kredyt") {
            addSceneCredit();
        }
        else if(comboboxForm1.getValue()=="Własne środki"){
            addSceneOwnCapital();
        }
        else if (comboboxForm1.getValue()=="Inwestor"){
            addSceneInvestor();
        }
        else if (comboboxForm1.getValue()=="Venture Capitals"){
            addSceneVC();
        }
        else if (comboboxForm1.getValue() == null){
            System.out.println("Brak wybrej wartosci w comboBoxForm1");
        }
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



}
