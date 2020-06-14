package symulator.simulation;

import com.opencsv.CSVWriter;
import symulator.app.accountOffice.AccountOffice;
import symulator.app.company.Company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * KLASA ODPOWIEDZIALNA ZA ZAPIS DO PLIKU CSV
 */
public class CSVHandler {
    Company company = Company.getInstance();
    AccountOffice office = AccountOffice.getInstance();

    public  void writeDataLineByLine(String filePath)
    {

        File file = new File(filePath);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] header = { "Budżet", "zrealizowane projekty","realizowane projekty w jednym czasie","vat z tytułu przyjętych zleceń", "odliczony vat", "koszta", "zyski" };
            writer.writeNext(header);
            String[] data1 = { company.dispalyAmount().toString(), company.getRealisedOrders().toString(), company.getOrderAtOnce().toString(), office.getVat().toString(),office.getOdliczonyVat().toString(),company.getCompanyCosts().toString(),company.getCompanyProfit().toString() };
            writer.writeNext(data1);
            writer.close();
        }
        catch (IOException e) {

            e.printStackTrace();
        }
    }
}
