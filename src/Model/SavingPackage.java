package Model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class SavingPackage implements Serializable {
    private static int ID_SAVINGPACKAGE = 1;
    private int id;
    private String savingPackageName;
    private int savingMoney;
    private int period;
    private double interestRate;

    public SavingPackage() {

    }

    public SavingPackage(String savingPackageName, int savingMoney, int period, double interestRate) {
        this.id = ID_SAVINGPACKAGE++;
        this.savingPackageName = savingPackageName;
        this.savingMoney = savingMoney;
        this.period = period;
        this.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSavingPackageName() {
        return savingPackageName;
    }

    public void setSavingPackageName(String savingPackageName) {
        this.savingPackageName = savingPackageName;
    }

    public int getSavingMoney() {
        return savingMoney;
    }

    public void setSavingMoney(int savingMoney) {
        this.savingMoney = savingMoney;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String changeSavingMoney(){
        double a = savingMoney;
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String savingMoney = numberFormat.format(a);
        return savingMoney;
    }

    @Override
    public String toString() {
        return "SavingPackage[" +
                "id= " + id +
                ", savingPackageName= '" + savingPackageName + '\'' +
                ", savingMoney= " + changeSavingMoney() +
                ", period= " + period + " months" +
                ", interestRate= " + interestRate +
                ']';
    }
}
