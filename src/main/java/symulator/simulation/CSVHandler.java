package symulator.simulation;

import com.opencsv.CSVWriter;
import symulator.app.company.Company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVHandler {
    Company company = Company.getInstance();

    public  void writeDataLineByLine(String filePath)
    {

        File file = new File(filePath);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] header = { "Budżet", "zrealizowane projekty"};
            writer.writeNext(header);
            String[] data1 = { company.dispalyAmount().toString(), company.getRealisedOrders().toString()};
            writer.writeNext(data1);
            writer.close();
        }
        catch (IOException e) {

            e.printStackTrace();
        }
    }
}
