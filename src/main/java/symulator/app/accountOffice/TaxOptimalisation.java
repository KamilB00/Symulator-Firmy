package symulator.app.accountOffice;

public class TaxOptimalisation extends AccountOffice{

private Double optimisedAmount;

    public Double costsOfEquipment(){
        double computerEquipment = 3500.0;
        double desk = 1500.0;
        double chair = 700.0;
        double softwareLicence = 1000.0;
        return computerEquipment+desk+chair+softwareLicence;
    }
    public Double equipmentVatTaxMonthly(){
        return  (costsOfEquipment()*23)/123.0;
    }


}
