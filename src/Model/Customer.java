package Model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Customer implements Serializable {
    private static int ID_CUSTOMER = 1;
    private int id;
    private String name;
    private String age;
    private String gender;
    private String dayOfBirth;
    private String address;
    private String phoneNumber;
    private String email;
    private String work;
    private double accountBalance;
    private String password;
    private SavingPackage savingPackage;
    private LoanPackage loanPackage;

    public Customer() {

    }

    public Customer(String name, String age, String gender, String dayOfBirth, String address, String phoneNumber, String email, String work, double accountBalance, String password, SavingPackage savingPackage, LoanPackage loanPackage) {
        this.id = ID_CUSTOMER++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.work = work;
        this.accountBalance = accountBalance;
        this.password = password;
        this.savingPackage = savingPackage;
        this.loanPackage = loanPackage;
    }
    public Customer(String name, String age, String gender, String dayOfBirth, String address, String phoneNumber, String email, String work, double accountBalance, String password, SavingPackage savingPackage) {
        this.id = ID_CUSTOMER++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.work = work;
        this.password = password;
        this.accountBalance = accountBalance;
        this.savingPackage = savingPackage;
    }

    public Customer(String name, String age, String gender, String dayOfBirth, String address, String phoneNumber, String email, String work, double accountBalance, String password, LoanPackage loanPackage) {
        this.id = ID_CUSTOMER++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.work = work;
        this.password = password;
        this.accountBalance = accountBalance;
        this.loanPackage = loanPackage;
    }
    public Customer(String name, String age, String gender, String dayOfBirth, String address, String phoneNumber, String email, String work, double accountBalance, String password) {
        this.id = ID_CUSTOMER++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.work = work;
        this.accountBalance = accountBalance;
    }


    public static int getIdCustomer() {
        return ID_CUSTOMER;
    }

    public static void setIdCustomer(int idCustomer) {
        ID_CUSTOMER = idCustomer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public double getaccountBalance() {
        return accountBalance;
    }

    public void setaccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public SavingPackage getSavingPackage() {
        return savingPackage;
    }

    public void setSavingPackage(SavingPackage savingPackage) {
        this.savingPackage = savingPackage;
    }

    public LoanPackage getLoanPackage() {
        return loanPackage;
    }

    public void setLoanPackage(LoanPackage loanPackage) {
        this.loanPackage = loanPackage;
    }

    public String changeBalanceCustomer(){
        double a = accountBalance;
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String accountBalance = numberFormat.format(a);
        return accountBalance;
    }

    @Override
    public String toString() {
        return "Customer[" +
                "Id= " + id +
                ", Name= " + name +
                ", Age= " + age +
                ", Gender= " + gender +
                ", DayOfBirth= " + dayOfBirth +
                ", Address= " + address +
                ", PhoneNumber= " + phoneNumber +
                ", Email= " + email +
                ", Work= " + work +
                ", Password= " + password +
                ", AccountBalance= " + changeBalanceCustomer() +
                ", SavingPackage= " + savingPackage +
                ", LoanPackage= " + loanPackage +
                ']' + "\n";
    }
}
