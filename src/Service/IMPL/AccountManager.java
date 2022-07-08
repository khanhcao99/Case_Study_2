package Service.IMPL;

import Model.Account;
import Model.Customer;
import Model.LoanPackage;
import Model.SavingPackage;
import Service.CRUD;

import java.io.*;
import java.util.ArrayList;

public class AccountManager implements CRUD<Account> {
    private ArrayList<Account> accounts = new ArrayList<>();

    public AccountManager() {
        accounts.add(new Account("khanhcao", "Khanhcaok.1"));
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void updateIdAccount(){
        int setIdAccount = 1;
        for (int i = 0; i < accounts.size(); i++) {
            accounts.get(i).setId(setIdAccount);
            setIdAccount++;
        }
    }

    public int checkSizeAccount(){
        int size = accounts.size();
        return size + 1;
    }

    public boolean checkId(int id){
        for (Account account : accounts){
            if (account.getId() == id){
                return true;
            }
        }
        return false;
    }
    public boolean checkLogin(String  login){
        for (Account account : accounts){
            if (account.getLogIn().equals(login)){
                return true;
            }
        }
        return false;
    }

    public boolean checkRegister(String user, String password){
        accounts = readObject();
        for (Account account: accounts){
            if (account.getLogIn().equals(user) && account.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Account account) {
        accounts.add(account);
        writeObject(accounts);
    }

    @Override
    public Account getById(int id) {
        for (Account account : accounts){
            if (account.getId() == id){
                return account;
            }
        }
        return null;
    }

    @Override
    public Account getByName(String name) {
        for (Account account : accounts){
            if (account.getLogIn().equals(name)){
                return account;
            }
        }
        return null;
    }

    @Override
    public void updateById(Account account) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId() == account.getId()){
                accounts.set(i, account);
                writeObject(accounts);
            }
        }
    }

    @Override
    public void updateByName(Account account) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getLogIn().equals(account.getLogIn())){
                accounts.set(i, account);
                writeObject(accounts);
            }
        }
    }

    @Override
    public Account deleteById(int id) {
        for (Account account : accounts){
            if (account.getId() == id){
                accounts.remove(account);
                writeObject(accounts);
                return account;
            }
        }
        return null;
    }

    @Override
    public Account deleteByName(String name) {
        for (Account account: accounts){
            if (account.getLogIn().equals(name)){
                accounts.remove(account);
                writeObject(accounts);
                return account;
            }
        }
        return null;
    }

    @Override
    public Account deleteByAll() {
        accounts = new ArrayList<>();
        writeObject(accounts);
        return null;
    }

    @Override
    public void displayByid(int id) {
        for (Account account : accounts){
            if (account.getId() == id){
                System.out.println(account);
                break;
            }
        }
    }

    @Override
    public void displayByName(String name) {

    }

    @Override
    public void displayByLoanPackage(LoanPackage loanPackage) {

    }

    @Override
    public void displayBySavingPackage(SavingPackage savingPackage) {

    }

    @Override
    public void displayAll() {
        for (Account account : accounts){
            System.out.println(account);
        }
    }

    public static void writeObject(ArrayList<Account> accounts){
        try{
            File file = new File("C:\\Users\\ASUS\\Desktop\\CASE_STUDY_2\\src\\Data\\DataAccount.txt");
            if (!file.exists()){
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(accounts);
            objectOutputStream.close();
        }catch (IOException e){
            System.err.println("can't create file");
        }
    }

    public static ArrayList<Account> readObject(){
        ArrayList<Account> accounts1 = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\ASUS\\Desktop\\CASE_STUDY_2\\src\\Data\\DataAccount.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            accounts1 = (ArrayList<Account>)objectInputStream.readObject();
            objectInputStream.close();
        }catch (IOException| ClassNotFoundException e){
            System.out.println("Couldn't find a file to write to");
        }
        return accounts1;
    }
}
