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
import symulator.simulation.CSVHandler;
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
        AccountOffice office = AccountOffice.getInstance();
        DecimalFormat df = new DecimalFormat("###,###.###");
        DecimalFormat df2 = new DecimalFormat("#");
        CSVHandler csvHandler = new CSVHandler();

        private static final String CSV_FILE_PATH
                = "./result.csv";


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
        private TextField bTextField0;

        @FXML
        private TextField fTextField14;

        @FXML
        private TextField fTextField13;

        @FXML
        private TextField fTextField12;

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
        private TextField kTextField16;

        @FXML
        private TextField kTextField17;


        @FXML
        private TextField kTextField18;


        @FXML
        private TextField kTextField10;


        @FXML
        private TextField kTextField15;


        @FXML
        private TextField fTextField00;

        @FXML
        private TextField fTextField16;

        @FXML
        private TextField textfieldDate;

        @FXML
        private TableView myTable;

        @FXML
        private PieChart pieChart;


        /**
         * WYCZYSZCZENIE TABELI ORAZ DODANIE  GRUP
         */
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
                                df.setMaximumFractionDigits(10);

                                /**
                                 * PĘTLA GŁÓWNA SYMULACJI
                                 */
                                for (int i = 1; i <= days; i++) {
//--------------------------------------------------------------------------------------------------------------------
                                        /**
                                         * AKCJE ZWIĄZANE Z FUNKCJONOWANIEM BANKU, VATU, BUDŻETU( CO MIESIĄC)
                                         */
                                        if(i%30==0){
                                                company.setCompanyBudget(company.getCompanyBudget()-company.costsOfEmployees());
                                                company.setCompanyCosts(company.getCompanyCosts()+company.costsOfEmployees());

                                        if(company.dispalyAmount()>0){

                                                if(bank.getReturnAmount()>0){
                                                        company.setCompanyBudget(company.getCompanyBudget()-bank.countInstallmentPrice());
                                                        bank.setReturnAmount(bank.getReturnAmount() + bank.getInterest()-bank.countInstallmentPrice());
                                                        if(bank.getInstallments()>0) {
                                                                bank.setInstallments(bank.getInstallments() - 1);
                                                        }else
                                                                bank.setInstallments(0);
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
                                        office.setOdliczonyVat(office.getOdliczonyVat()+(office.equipmentVatTax()*company.workerEntities.size()));
                                                office.setVat(office.getVat()+(company.getCompanyProfit()*23)/123);
                                        }
                                        if(i%360 == 0){
                                                office.setVat(0.0);
                                                office.setOdliczonyVat(0.0);
                                        }
//--------------------------------------------------------------------------------------------------------------------
                                        int finalI = i;
                                        Double income = company.dailyIncome()/i;
                                        Platform.runLater(new Runnable() {
                                                public void run() {
                                                        //data
                                                        textfieldDate.setText(simulationClock.timeFormat(simulationClock.timeUpdate((finalI))));
                                                        //budżet
                                                        fTextField00.setText(df2.format(company.dispalyAmount()));
                                                        // dzieny zysk
                                                        fTextField10.setText(df2.format(income));
                                                        //zrealizowane zamówienia
                                                        fTextField16.setText(company.getRealisedOrders().toString());
                                                        //realizowane obecnie zamówienia
                                                        fTextField13.setText(company.getOrderAtOnce().toString());
                                                        // kwota do zapłaty
                                                        bTextField9.setText(df2.format(bank.getReturnAmount()));
                                                        //raty
                                                        bTextField11.setText(bank.getInstallments().toString());
                                                        //odsetki
                                                        bTextField12.setText(df2.format(bank.getInterest()));
                                                        //koszta
                                                         kTextField16.setText(df2.format(company.getCompanyCosts()));
                                                        //zyski
                                                        kTextField17.setText(df2.format(company.getCompanyProfit()));
                                                        //bilans
                                                        kTextField18.setText(df2.format(company.getCompanyProfit() - company.getCompanyCosts()));
                                                        //odliczony Vat
                                                        kTextField15.setText(df2.format(office.getOdliczonyVat()));
                                                        //vat z projektów
                                                        kTextField10.setText(df2.format(office.getVat()));
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
                        csvHandler.writeDataLineByLine(CSV_FILE_PATH);
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

        /**
         * INICJALIZACJA WARTOŚCI PODCZAS URUCHOMIENIA OKNA SYMULACJI
         * @param url
         * @param resourceBundle
         */
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

                sizeOfCompany();
                financing();

        }

        /**
         * OKREŚLANIE NA PODSTAWIE ILOŚĆI PRACOWNIKÓW RODZAJU PRZEDSIĘBIORSTWA (MIKRO,MAŁE,ŚREDNIE,DUŻE)
         */
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

        /**
         * WYŚWIETLANIE RODZAJU FINANSOWANIA
         */
        public void financing(){
                if((bank.getAmount()!= 0)){

                        bank.countReturnAmount();
                        fTextField14.setText("KREDYT");
                        bTextField7.setText(bank.getAmount().toString());
                        bTextField11.setText(bank.getInstallments().toString());
                        bTextField9.setText(bank.getReturnAmount().toString());
                        bTextField8.setText(df.format(bank.getPercent()));
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

        /**
         * WYŁĄCZENIE NAPISU BANK
         */
        public void disableBank(){
                bTextField0.setDisable(true);

        }

        }







