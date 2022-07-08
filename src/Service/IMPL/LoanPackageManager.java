package Service.IMPL;

import Model.Account;
import Model.LoanPackage;
import Model.SavingPackage;
import Service.CRUD;

import java.io.*;
import java.util.ArrayList;

public class LoanPackageManager implements CRUD<LoanPackage> {
    private ArrayList<LoanPackage> loanPackages = new ArrayList<>();

    public LoanPackageManager() {
        loanPackages.add(new LoanPackage("Gói A", 10000000, 12, 1));
        loanPackages.add(new LoanPackage("Gói B", 20000000, 16, 2));
        loanPackages.add(new LoanPackage("Gói C", 30000000, 24, 3));
    }

    public ArrayList<LoanPackage> getLoanPackages() {
        return loanPackages;
    }

    public void setLoanPackages(ArrayList<LoanPackage> loanPackages) {
        this.loanPackages = loanPackages;
    }

    public void updateIdLoanPackage(){
        int setIdLoanPackage = 1;
        for (int i = 0; i < loanPackages.size(); i++) {
            loanPackages.get(i).setId(setIdLoanPackage);
            setIdLoanPackage++;
        }
    }

    public int checkSizeLoanPackage(){
        int size = loanPackages.size();
        return size + 1;
    }
    public boolean checkId(int id){
        for (LoanPackage ld : loanPackages){
            if (ld.getId() == id){
                return true;
            }
        }
        return false;
    }

    public boolean checkName(String string){
        for (LoanPackage ld : loanPackages){
            if (ld.getLoanPackageName().equals(string)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(LoanPackage loanPackage) {
        loanPackages.add(loanPackage);
        writeObject(loanPackages);
    }

    @Override
    public LoanPackage getById(int id) {
        for (int i = 0; i < loanPackages.size(); i++) {
            if (loanPackages.get(i).getId() == id) {
                return loanPackages.get(i);
            }
        }
        return null;
    }

    @Override
    public LoanPackage getByName(String name) {
        for (LoanPackage ld : loanPackages) {
            if (ld.getLoanPackageName().equals(name)) {
                return ld;
            }
        }
        return null;
    }

    @Override
    public void displayByLoanPackage(LoanPackage loanPackage) {

    }

    @Override
    public void displayBySavingPackage(SavingPackage savingPackage) {

    }

    @Override
    public void updateById(LoanPackage loanPackage) {
        for (int i = 0; i < loanPackages.size(); i++) {
            if (loanPackages.get(i).getId() == loanPackage.getId()) {
                loanPackages.set(i, loanPackage);
                writeObject(loanPackages);
            }
        }
    }

    @Override
    public void updateByName(LoanPackage loanPackage) {
        for (int i = 0; i < loanPackages.size(); i++) {
            if (loanPackages.get(i).getLoanPackageName().equals(loanPackage.getLoanPackageName())){
                loanPackages.set(i, loanPackage);
                writeObject(loanPackages);
            }
        }
    }

    @Override
    public LoanPackage deleteById(int id) {
        for (LoanPackage ld : loanPackages){
            if (ld.getId() == id){
                loanPackages.remove(ld);
                updateIdLoanPackage();
                writeObject(loanPackages);
                return ld;
            }
        }
        return null;
    }

    @Override
    public LoanPackage deleteByName(String name) {
        for (LoanPackage ld : loanPackages){
            if (ld.getLoanPackageName().equals(name)){
                loanPackages.remove(ld);
                updateIdLoanPackage();
                writeObject(loanPackages);
                return ld;
            }
        }
        return null;
    }

    @Override
    public LoanPackage deleteByAll() {
        loanPackages = new ArrayList<>();
        writeObject(loanPackages);
        return null;
    }

    @Override
    public void displayByid(int id) {
        for (LoanPackage ld : loanPackages){
            if (ld.getId() == id){
                System.out.println(ld);
                break;
            }
        }
    }

    @Override
    public void displayByName(String name) {
        for (LoanPackage ld : loanPackages){
            if (ld.getLoanPackageName().equals(name)){
                System.out.println(ld);
                break;
            }
        }
    }

    @Override
    public void displayAll() {
        for (LoanPackage ld : loanPackages){
            System.out.println(ld);
        }
    }

    public void writeObject(ArrayList<LoanPackage> loanPackages){
        try{
            File file = new File("C:\\Users\\ASUS\\Desktop\\CASE_STUDY_2\\src\\Data\\DataLoanPackage.txt");
            if (!file.exists()){
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(loanPackages);
            objectOutputStream.close();
        }catch (IOException e){
            System.err.println("can't create file");
        }
    }

    public ArrayList<LoanPackage> readObject(){
        ArrayList<LoanPackage> loanPackages1 = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\ASUS\\Desktop\\CASE_STUDY_2\\src\\Data\\DataLoanPackage.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            loanPackages1 = (ArrayList<LoanPackage>)objectInputStream.readObject();
            objectInputStream.close();
        }catch (IOException| ClassNotFoundException e){
            System.out.println("Couldn't find a file to write to");
        }
        return loanPackages1;
    }
}
