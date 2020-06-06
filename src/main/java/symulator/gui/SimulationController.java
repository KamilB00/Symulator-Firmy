package symulator.gui;

import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javafx.stage.Modality;
import javafx.stage.Stage;
import symulator.simulation.SimulationClock;

import javax.swing.event.ChangeEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public   class SimulationController implements Initializable {
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
        private Separator mainSeparator;

        @FXML
        private JFXButton finalDataButton;

        //FetchData fetchData = new FetchData();

        public void setProgressBarSim0(ProgressBar progressBarSim0) {
                this.progressBarSim0 = progressBarSim0;
        }

        class DoWork extends Task<Integer>{

                @Override
                public Integer call() throws Exception {
                       SimulationClock simulationClock = SimulationClock.getInstance();

                       simulationClock.setYears(simulationClock.getYears());
                       int week = simulationClock.simulationTime();
                        System.out.println("czas w tygodniach -->" + week);
                        for(int i=0;i< week;i++){
                                System.out.println(i+1);
                                updateProgress(i+1,week);
                               Thread.sleep(1000);
                                if(isCancelled()){

                                        return i;
                                }
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

                DoWork task = new DoWork();
                progressBarSim0.progressProperty().bind(task.progressProperty());
                new Thread(task).start();




        }

        @FXML
        public void switchToSummary() throws IOException, InterruptedException {
                Parent view2 = FXMLLoader.load(getClass().getResource("/gui/FinalData.fxml"));
                Scene scene2 = new Scene(view2);
                Stage window = new Stage();

                //window.initModality(Modality.APPLICATION_MODAL);
                // window.initStyle(StageStyle.UNDECORATED);
                window.setScene(scene2);
                window.show();
        }

        }






