package symulator.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public   class SimulationController {

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

        public void initialize(){
                Thread th = new Thread(new bg_Thread());
                th.start();
        }

   class bg_Thread extends Thread{

          @Override
        public void run() {
                for(int i=0;i<100;i++){
                        try{
                                progressBarSim0.setProgress(i/100);
                                Thread.sleep(100);

                        }catch (InterruptedException ex){
                                Logger.getLogger(SimulationController.class.getName()).log(Level.SEVERE,null,ex);
                        }
                }
        }
}


    }
