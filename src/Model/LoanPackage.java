package Model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class LoanPackage implements Serializable {
    private static int ID_LOANPACKAGE = 1;
    private int id;
    private String loanPackageName;
    private int loanMoney;
    private int period;
    private double interestRate;

    public LoanPackage() {

    }

    public LoanPackage(String loanPackageName, int loanMoney, int period, double interestRate) {
        this.id = ID_LOANPACKAGE++;
        this.loanPackageName = loanPackageName;
        this.loanMoney = loanMoney;
        this.period = period;
        this.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoanPackageName() {
        return loanPackageName;
    }

    public void setLoanPackageName(String loanPackageName) {
        this.loanPackageName = loanPackageName;
    }

    public int getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(int loanMoney) {
        this.loanMoney = loanMoney;
    }

    public double getPeriod() {
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


    public String changeLoanMoney(){
        double a = loanMoney;
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String loanMoney = numberFormat.format(a);
        return loanMoney;
    }

    @Override
    public String toString() {
        return "LoanPackage[" +
                "id= " + id +
                ", loanPackageName= '" + loanPackageName + '\'' +
                ", loanMoney= " + changeLoanMoney() +
                ", period= " + period + " months" +
                ", interestRate= " + interestRate +
                ']';
    }
}
