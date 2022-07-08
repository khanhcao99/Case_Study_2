package Service.IMPL;

import Model.Account;
import Model.Customer;
import Model.LoanPackage;
import Model.SavingPackage;
import Service.CRUD;

import java.io.*;
import java.util.ArrayList;

public class SavingPackageManager implements CRUD<SavingPackage> {
    private ArrayList<SavingPackage> savingPackages = new ArrayList<>();

    public SavingPackageManager() {
        savingPackages.add(new SavingPackage("Gói D", 1000000000, 12, 0.7));
        savingPackages.add(new SavingPackage("Gói E", 1500000000, 16, 0.8));
        savingPackages.add(new SavingPackage("Gói F", 2000000000, 24, 0.9));
    }

    public ArrayList<SavingPackage> getSavingPackages() {
        return savingPackages;
    }

    public void setSavingPackages(ArrayList<SavingPackage> savingPackages) {
        this.savingPackages = savingPackages;
    }

    public void updateIdSavingPackage(){
        int setIdSavingPackage = 1;
        for (int i = 0; i < savingPackages.size(); i++) {
            savingPackages.get(i).setId(setIdSavingPackage);
            setIdSavingPackage++;
        }
    }

    public int checkSizeSavingPackage(){
        int size = savingPackages.size();
        return size + 1;
    }
    public boolean checkId(int id){
        for (SavingPackage sv : savingPackages){
            if (sv.getId() == id){
                return true;
            }
        }
        return false;
    }

    public boolean checkName(String name){
        for (SavingPackage sv : savingPackages){
            if (sv.getSavingPackageName().equals(name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(SavingPackage savingPackage) {
        savingPackages.add(savingPackage);
        writeObject(savingPackages);
    }

    @Override
    public SavingPackage getById(int id) {
        for (SavingPackage sv : savingPackages) {
            if (sv.getId() == id) {
                return sv;
            }
        }
        return null;
    }

    @Override
    public SavingPackage getByName(String name) {
        for (SavingPackage sv : savingPackages) {
            if (sv.getSavingPackageName().equals(name)) {
                return sv;
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
    public void updateById(SavingPackage savingPackage) {
        for (int i = 0; i < savingPackages.size(); i++) {
            if (savingPackages.get(i).getId() == savingPackage.getId()) {
                savingPackages.set(i, savingPackage);
                writeObject(savingPackages);
            }
        }
    }

    @Override
    public void updateByName(SavingPackage savingPackage) {
        for (int i = 0; i < savingPackages.size(); i++) {
            if (savingPackages.get(i).getSavingPackageName().equals(savingPackage.getSavingPackageName())){
                savingPackages.set(i, savingPackage);
                writeObject(savingPackages);
            }
        }
    }

    @Override
    public SavingPackage deleteById(int id) {
        for (SavingPackage sv : savingPackages) {
            if (sv.getId() == id) {
                savingPackages.remove(sv);
                updateIdSavingPackage();
                writeObject(savingPackages);
                return sv;
            }
        }
        return null;
    }

    @Override
    public SavingPackage deleteByName(String name) {
        for (SavingPackage sv : savingPackages) {
            if (sv.getSavingPackageName().equals(name)) {
                savingPackages.remove(sv);
                updateIdSavingPackage();
                writeObject(savingPackages);
                return sv;
            }
        }
        return null;
    }

    @Override
    public SavingPackage deleteByAll() {
        savingPackages = new ArrayList<>();
        writeObject(savingPackages);
        return null;
    }

    @Override
    public void displayByid(int id) {
        for (SavingPackage sv : savingPackages){
            if (sv.getId() == id){
                System.out.println(sv);
                break;
            }
        }
    }

    @Override
    public void displayByName(String name) {
        for (SavingPackage sv : savingPackages){
            if (sv.getSavingPackageName().equals(name)){
                System.out.println(sv);
                break;
            }
        }
    }

    @Override
    public void displayAll() {
        for (SavingPackage sv : savingPackages){
            System.out.println(sv);
        }
    }

    public void writeObject(ArrayList<SavingPackage> savingPackages){
        try{
            File file = new File("C:\\Users\\ASUS\\Desktop\\CASE_STUDY_2\\src\\Data\\DataSavingPackage.txt");
            if (!file.exists()){
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(savingPackages);
            objectOutputStream.close();
        }catch (IOException e){
            System.err.println("can't create file");
        }
    }

    public ArrayList<SavingPackage> readObject(){
        ArrayList<SavingPackage> savingPackages1 = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\ASUS\\Desktop\\CASE_STUDY_2\\src\\Data\\DataSavingPackage.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            savingPackages1 = (ArrayList<SavingPackage>)objectInputStream.readObject();
            objectInputStream.close();
        }catch (IOException| ClassNotFoundException e){
            System.out.println("Couldn't find a file to write to");
        }
        return savingPackages1;
    }
}
