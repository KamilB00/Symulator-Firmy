package symulator.gui;

import com.jfoenix.controls.JFXButton;
import dataBase.WorkerDAO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import symulator.app.accountOffice.AccountOffice;
import symulator.app.company.Company;
import symulator.app.finance.Bank;
import symulator.app.finance.Investor;
import symulator.app.finance.OwnCapital;
import symulator.app.finance.VC;
import symulator.app.person.Worker;
import symulator.simulation.SimulationClock;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.*;


public   class  SimulationController implements Initializable {
        Company company = Company.getInstance();
        Bank bank = Bank.getInstance();
        Investor investor = Investor.getInstance();
        VC vc = VC.getInstance();
        OwnCapital ownCapital = OwnCapital.getInstance();
        SimulationClock simulationClock = SimulationClock.getInstance();
        WorkerDAO workerDAO = new WorkerDAO();
        AccountOffice office = new AccountOffice();
        DecimalFormat df = new DecimalFormat("###,###.###");
        DecimalFormat df2 = new DecimalFormat("#");
        @FXML
        private AnchorPane simulationPane;

        @FXML
        private TextField kTextField12;

        @FXML
        private TextField kTextField3;

        @FXML
        private TextField fTextField10;

        @FXML
        private ProgressBar progressBarSim0;

        @FXML
        private ProgressBar progressBarSim1;

        @FXML
        private ProgressBar progressBarSim2;

        @FXML
        private ProgressBar progressBarSim3;

        @FXML
        private ProgressBar progressBarSim4;

        @FXML
        private TextField fTextField0;

        @FXML
        private TextField bTextField0;

        @FXML
        private TextField sTextField0;

        @FXML
        private TextField kTextField0;

        @FXML
        private TextField gTextField0;

        @FXML
        private TextField fTextField1;

        @FXML
        private TextField fTextField2;

        @FXML
        private TextField fTextField3;

        @FXML
        private TextField fTextField4;

        @FXML
        private TextField fTextField6;

        @FXML
        private TextField fTextField7;

        @FXML
        private TextField fTextField8;

        @FXML
        private TextField fTextField9;

        @FXML
        private TextField fTextField14;

        @FXML
        private TextField fTextField13;

        @FXML
        private TextField fTextField12;

        @FXML
        private TextField fTextField11;

        @FXML
        private Label fLabel2;

        @FXML
        private Label fLabel1;

        @FXML
        private TextField bTextField1;

        @FXML
        private TextField bTextField2;

        @FXML
        private TextField bTextField3;

        @FXML
        private TextField bTextField4;

        @FXML
        private TextField bTextField5;

        @FXML
        private TextField bTextField6;

        @FXML
        private TextField bTextField7;

        @FXML
        private TextField bTextField8;

        @FXML
        private TextField bTextField9;

        @FXML
        private TextField bTextField11;

        @FXML
        private TextField bTextField12;

        @FXML
        private TextField bTextField13;

        @FXML
        private Label bLabel1;

        @FXML
        private Label bLabel3;

        @FXML
        private Label bLabel4;

        @FXML
        private Label bLabel5;

        @FXML
        private Label bLabel2;

        @FXML
        private TextField kTextField1;

        @FXML
        private PieChart sPieChart;

        @FXML
        private LineChart<?, ?> sLineChart;

        @FXML
        private LineChart<?, ?> gLineChart;

        @FXML
        private TextField kTextField2;

        @FXML
        private TextField kTextField5;

        @FXML
        private TextField kTextField6;

        @FXML
        private TextField kTextField7;

        @FXML
        private TextField kTextField8;

        @FXML
        private TextField kTextField9;

        @FXML
        private TextField kTextField16;

        @FXML
        private TextField kTextField17;

        @FXML
        private Label kLabel6;

        @FXML
        private Label kLabel7;

        @FXML
        private TextField kTextField18;

        @FXML
        private Label kLabel8;

        @FXML
        private TextField kTextField10;

        @FXML
        private TextField kTextField11;

        @FXML
        private Label kLabel1;

        @FXML
        private Label kLabel2;

        @FXML
        private Label kLabel3;

        @FXML
        private TextField kTextField13;

        @FXML
        private Label kLabel4;

        @FXML
        private TextField kTextField15;

        @FXML
        private Label kLabel5;

        @FXML
        private TextField kTextField4;

        @FXML
        private TextField fTextField5;

        @FXML
        private TextField fTextField00;

        @FXML
        private TextField fTextField16;

        @FXML
        private Separator mainSeparator;

        @FXML
        private JFXButton finalDataButton;
        // clock---------------------------
        @FXML
        private TextField textfieldDate;

       //-----------------------------------
        @FXML
        private TableView myTable;

        @FXML
        private PieChart pieChart;



        public void setProgressBarSim0(ProgressBar progressBarSim0) {
                this.progressBarSim0 = progressBarSim0;
        }


        public void updateTable(){
                myTable.getItems().clear();
                if(company.displayProjectsWorkersAndGroupsInTable() != null) {
                        for (Groups group : company.displayProjectsWorkersAndGroupsInTable()) {
                                myTable.getItems().add(group);
                        }
                }
        }


        class DoWork extends Task<Integer> {

                @Override
                public Integer call() {
                        try {
                                SimulationClock simulationClock = SimulationClock.getInstance();
                                simulationClock.setYears(simulationClock.getYears());
                                int days = simulationClock.simulationTime();
                                System.out.println("week --> " + days);
                                df.setMaximumFractionDigits(10);
                                System.out.println("all employees "+ company.allEmployees());
                                System.out.println("costs of employess"+ company.costsOfEmployees());
                                for (int i = 1; i <= days; i++) {

                                        if(i%30==0){
                                                company.setCompanyBudget(company.getCompanyBudget()-company.costsOfEmployees());
                                                company.setCompanyCosts(company.getCompanyCosts()+company.costsOfEmployees());

                                        if(company.dispalyAmount()>0){
                                                if(bank.getReturnAmount()>0){
                                                        company.setCompanyBudget(company.getCompanyBudget()-bank.countInstallmentPrice());
                                                        bank.setReturnAmount(bank.getReturnAmount()-bank.countInstallmentPrice() + bank.getInterest());
                                                        bank.setInstallments(bank.getInstallments()-1);
                                                        if(bank.getInterest()>0){
                                                                bank.setInterest(0.0);
                                                        }

                                                }
                                                else if(bank.getReturnAmount()<=0){
                                                        bank.setReturnAmount(0.0);
                                                        disableBank();
                                                }
                                        }
                                        else if (company.dispalyAmount()<0){
                                                bank.setInterest(bank.getInterest()+bank.countInterest());
                                        }

                                        }
                                        int finalI = i;
                                        Double income = company.dailyIncome()/i;
                                        Platform.runLater(new Runnable() {
                                                public void run() {

                                                        textfieldDate.setText(simulationClock.timeFormat(simulationClock.timeUpdate((finalI))));
                                                        textfieldDate.requestFocus();

                                                        fTextField00.setText(df2.format(company.dispalyAmount()));
                                                        fTextField00.requestFocus();

                                                        fTextField10.setText(df2.format(income));
                                                        fTextField00.requestFocus();

                                                        fTextField16.setText(company.getRealisedOrders().toString());
                                                        fTextField16.requestFocus();

                                                        fTextField13.setText(company.getOrderAtOnce().toString());
                                                        fTextField13.requestFocus();

                                                        bTextField9.setText(bank.getReturnAmount().toString());
                                                        bTextField11.setText(bank.getInstallments().toString());
                                                        bTextField12.setText(bank.getInterest().toString());
                                                        //koszta
                                                         kTextField16.setText(df2.format(company.getCompanyCosts()));
                                                        //zyski
                                                        kTextField17.setText(df.format(company.getCompanyProfit()));
                                                        //bilans
                                                        kTextField18.setText(df.format(company.getCompanyProfit() - company.getCompanyCosts()));
                                                        updateTable();
                                                        try {
                                                                company.runProjectsManagerInDay();
                                                        } catch (InterruptedException e) {
                                                                e.printStackTrace();
                                                        }

                                                }
                                        });

                                        updateProgress(i , days);
                                        Thread.sleep(100);

                                        if (isCancelled()) {
                                                return i;
                                        }

                                }

                        } catch (Exception e) {
                                System.out.println(e);
                        }
                        return 1;
                }

                @Override
                public boolean cancel(boolean mayInterruptIfRunning) {
                        updateMessage("Cancelled!");
                        return super.cancel(mayInterruptIfRunning);
                }
                @Override
                protected void updateProgress(long workDone, long max) {
                        updateMessage("progress!"+ workDone);
                        super.updateProgress(workDone, max);
                }
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
        office.countCosts();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Twoje Udziały",100-vc.getShares()),
                new PieChart.Data("Venture Capitals",vc.getShares()));
pieChart.setData(pieChartData);
pieChart.setStartAngle(90);
                DoWork task = new DoWork();
                progressBarSim0.progressProperty().bind(task.progressProperty());
                TableColumn  group = new TableColumn("GRUPA");
                TableColumn  project = new TableColumn("PROJEKT");
                TableColumn  time = new TableColumn("CZAS");
                TableColumn  efficiency = new TableColumn("WYDAJNOŚĆ");

                group.setCellValueFactory(new PropertyValueFactory<>("group"));
                project.setCellValueFactory(new PropertyValueFactory<>("project"));
                time.setCellValueFactory(new PropertyValueFactory<>("time"));
                efficiency.setCellValueFactory(new PropertyValueFactory<>("efficiency"));

                myTable.getColumns().addAll(group, project, time, efficiency);



                new Thread(task).start();
                //programiści
                progressBarSim1.setProgress((float)(company.getJuniorProgrammersNumber()+company.getRegularProgrammersNumber()+company.getSeniorProgrammersNumber()) /(company.allEmployees()));
                // project manager
                progressBarSim2.setProgress((float)company.getProjectManagersNumber()/company.allEmployees());
                // księgowi
                progressBarSim3.setProgress((float)company.getAccountantsNumber()/company.allEmployees());
                //marketerzy
                progressBarSim4.setProgress((float)company.getMarketersNumber()/company.allEmployees());
                System.out.println("progressBarSim1 programista --> "+ progressBarSim1.getProgress());
                System.out.println("progressBarSim2 PM --> "+ progressBarSim2.getProgress());
                System.out.println("progressBarSim3 księgowy --> "+ progressBarSim3.getProgress());
                System.out.println("progressBarSim4 marketer --> "+ progressBarSim4.getProgress());
                sizeOfCompany();
                financing();

        }

        @FXML
        public void switchToSummary() throws IOException {
                Parent view2 = FXMLLoader.load(getClass().getResource("/gui/FinalData.fxml"));
                Scene scene2 = new Scene(view2);
                Stage window = new Stage();

                //window.initModality(Modality.APPLICATION_MODAL);
                // window.initStyle(StageStyle.UNDECORATED);
                window.setScene(scene2);
                window.show();
        }

        public void sizeOfCompany(){
                if(company.allEmployees()>=1 && company.allEmployees()<=10){
                        fTextField12.setText("Mikro przedsiębiorstwo");
                }
                else if(company.allEmployees()>=10 && company.allEmployees()<=50){
                        fTextField12.setText("Małe przedsiębiorstwo");
                }
                else if (company.allEmployees()>=50 && company.allEmployees()<=250){
                        fTextField12.setText("Średnie przedsiębiorstwo");
                }
                else if (company.allEmployees()>250)
                        fTextField12.setText("Duże przedsiębiorstwo");
        }

        public void financing(){
                if((bank.getAmount()!= 0)){


                        bank.countReturnAmount();
                        fTextField14.setText("KREDYT");
                        bTextField7.setText(bank.getAmount().toString());
                        bTextField11.setText(bank.getInstallments().toString());
                        bTextField9.setText(bank.getReturnAmount().toString());
                        bTextField8.setText(df.format(bank.percent()));
                        bTextField12.setText(bank.getInterest().toString());
                }
                else if((investor.getOfferedAmount()!= 0)){
                        fTextField14.setText("INWESTOR");
                        disableBank();
                }
                else if ((ownCapital.getAmount()!= 0)){
                        fTextField14.setText("KAPITAŁ WŁASNY");
                        disableBank();
                }
                else if((vc.getAmount()!= 0)){
                        fTextField14.setText("VENTURE CAPITALS");
                       disableBank();
                }

        }
        public void disableBank(){
                bTextField0.setDisable(true);

        }

        }







