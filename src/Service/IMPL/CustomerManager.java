package Service.IMPL;

import Model.Account;
import Model.Customer;
import Model.LoanPackage;
import Model.SavingPackage;
import Service.CRUD;

import java.io.*;
import java.util.ArrayList;

public class CustomerManager implements CRUD<Customer>, Serializable {
    private ArrayList<Customer> customers = new ArrayList<>();

    public CustomerManager() {

    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void updateIdCustomer(){
        int setIdCustomer = 1;
        for (int i = 0; i < customers.size(); i++) {
            customers.get(i).setId(setIdCustomer);
            setIdCustomer++;
        }
    }

    public int checkSizeCustomer(){
        int size = customers.size();
        return size + 1;
    }
    public boolean checkId(int id){
        for (Customer cs : customers){
            if (cs.getId() == id){
                return true;
            }
        }
        return false;
    }

    public boolean checkName(String name){
        for (Customer cs : customers){
            if (cs.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Customer customer) {
        customers.add(customer);
        writeObject(customers);
    }

    @Override
    public Customer getById(int id) {
        for (Customer cs : customers){
            if (cs.getId() == id){
                return cs;
            }
        }
        return null;
    }

    @Override
    public Customer getByName(String name) {
        for (Customer cs : customers){
            if (cs.getName().equals(name)){
                return cs;
            }
        }
        return null;
    }

    @Override
    public void updateById(Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId()==customer.getId()){
                customers.set(i, customer);
                writeObject(customers);
            }
        }
    }

    @Override
    public void updateByName(Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(customer.getName())){
                customers.set(i, customer);
                writeObject(customers);
            }
        }
    }

    @Override
    public Customer deleteById(int id) {
        for (Customer cs : customers){
            if (cs.getId() == id){
                customers.remove(cs);
                updateIdCustomer();
                writeObject(customers);
                return cs;
            }
        }
        return null;
    }

    @Override
    public Customer deleteByName(String name) {
        for (Customer cs : customers){
            if (cs.getName().equals(name)){
                customers.remove(cs);
                updateIdCustomer();
                writeObject(customers);
                return cs;
            }
        }
        return null;
    }

    @Override
    public Customer deleteByAll() {
        customers = new ArrayList<>();
        writeObject(customers);
        return null;
    }

    @Override
    public void displayByLoanPackage(LoanPackage loanPackage) {
        for (Customer cs : customers){
            if (customers.contains(loanPackage)){
                System.out.println(cs);
            }
        }
    }

    @Override
    public void displayBySavingPackage(SavingPackage savingPackage) {
        for (Customer cs : customers){
            if (customers.contains(savingPackage)){
                System.out.println(cs);
            }
        }
    }

    @Override
    public void displayByid(int id) {
        for (Customer cs : customers){
            if (cs.getId() == id){
                System.out.println(cs);
                break;
            }
        }
    }

    @Override
    public void displayByName(String name) {
        for (Customer cs : customers){
            if (cs.getName().equals(name)){
                System.out.println(cs);
                break;
            }
        }
    }

    @Override
    public void displayAll() {
//        customers.forEach(System.out::println);
        for (Customer cs : customers){
            System.out.println(cs);
        }
    }


//    public void displayCustomer(ArrayList<Customer> userList) {
//        System.out.format("+----+-------------------+--------+-----------+--------------+------------+----------------+--------------------------+-------------+--------------+----------+----------------+--------------+%n");
//        System.out.format("| ID |       Name        |   Age  |   Gender  | Day of birth |   Address  |  Phone Number  |           Email          |     Work    |   Desposits  | Password | Saving Package | Loan Package |%n");
//        System.out.format("+----+-------------------+--------+-----------+--------------+------------+----------------+--------------------------+-------------+--------------+----------+----------------+--------------+%n");
//
//        for (Customer customer : customers) {
//            displayUser(customer);
//        }
//    }
//
//    public void displayUser(Customer customer) {
//        String leftAlignFormat = "| %-2s | %-17s | %-6s | %-11s | %-14s | %-12s | %-16s | %-26s | %-13s | %-14s | %-10s | %-16s | %-14s |%n";
//        System.out.format(leftAlignFormat, customer.getId(), customer.getName(), customer.getAge(),
//                customer.getGender(), customer.getDayOfBirth(), customer.getAddress(),
//                customer.getPhoneNumber(), customer.getEmail(), customer.getWork(), customer.getDesposits(), customer.getPassword(), customer.getSavingPackage().getSavingPackageName(), customer.getLoanPackage().getLoanPackageName());
//        System.out.format("+---------+-----------------+-----------------+-----------------+---------+-----+--------------+-------------------+---------------------------+%n");
//    }


    public void writeObject(ArrayList<Customer> customers){
        try{
            File file = new File("C:\\Users\\ASUS\\Desktop\\CASE_STUDY_2\\src\\Data\\DataCustomer.txt");
            if (!file.exists()){
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(customers);
            objectOutputStream.close();
        }catch (IOException e){
            System.err.println("can't create file");
        }
    }

    public ArrayList<Customer> readObject(){
        ArrayList<Customer> customers1 = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\ASUS\\Desktop\\CASE_STUDY_2\\src\\Data\\DataCustomer.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            customers1 = (ArrayList<Customer>)objectInputStream.readObject();
            objectInputStream.close();
        }catch (IOException| ClassNotFoundException e){
            System.out.println("Couldn't find a file to read to");
        }
        return customers1;
    }
}


