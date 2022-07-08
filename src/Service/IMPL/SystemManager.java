package Service.IMPL;

import Model.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class SystemManager {
    private final CustomerManager customerManager = new CustomerManager();
    private final LoanPackageManager loanPackageManager = new LoanPackageManager();
    private final SavingPackageManager savingPackageManager = new SavingPackageManager();
    private final AccountManager accountManager = new AccountManager();
    private final Validate validate = new Validate();
    private final Scanner scanner = new Scanner(System.in);

    //    CustomerManager


    public Customer addCustomer() {
        Customer customer = createCustomer();
        customer.setId(customerManager.checkSizeCustomer());
        customerManager.add(customer);
        return customer;
    }

    public Customer createCustomer() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        boolean checkAge = false;
        String age;
        do {
            System.out.println("Enter age: ");
            String age1 = scanner.nextLine();
            age = age1;
            if (validate.validateAge(age1)){
                checkAge = true;
            }else {
                System.err.println("Age is not in the correct format, please re-enter");
            }
        }while (!checkAge);

        System.out.println("Enter gender: ");
        String gender = scanner.nextLine();

        boolean checkDayOfBirth = false;
        String dayOfBirth;
        do {
            System.out.println("Enter day of birth: ");
            String dayOfBirth1 = scanner.nextLine();
            dayOfBirth = dayOfBirth1;
            if (validate.validateDayOfBirth(dayOfBirth1)){
                checkDayOfBirth = true;
            }else {
                System.err.println("Day of birth is not in the correct format, please re-enter");
            }
        }while (!checkDayOfBirth);

        System.out.println("Enter address: ");
        String address = scanner.nextLine();

        boolean checkPhoneNumber = false;
        String phoneNumber;
        do {
            System.out.println("Enter phone number: ");
            String phoneNumber1 = scanner.nextLine();
            phoneNumber = phoneNumber1;
            if (validate.validatePhoneNumber(phoneNumber1)){
                checkPhoneNumber = true;
            }else {
                System.err.println("Phone number is not in the correct format, please re-enter");
            }
        }while (!checkPhoneNumber);

        boolean checkEmail = false;
        String email;
        do {
            System.out.println("Enter email: ");
            String email1 = scanner.nextLine();
            email = email1;
            if (validate.validateEmail(email1)){
                checkEmail = true;
            }else {
                System.err.println("Email is not in the correct format, please re-enter");
            }
        }while (!checkEmail);

        System.out.println("Enter work: ");
        String work = scanner.nextLine();

        boolean checkAccountBalance = false;
        double accountBalance = 0;
        do {
            System.out.println("Enter account balance: ");
            String accountBalance1 = scanner.nextLine();
            if (validate.validateBalaned(accountBalance1)){
                checkAccountBalance = true;
                accountBalance = Double.parseDouble(accountBalance1);
            }else {
                System.err.println("Balance is not in the correct format, please re-enter");
            }
            
        }while (!checkAccountBalance);

        boolean checkPassword = false;
        String password;
        do {
            System.out.println("Enter password: ");
            String password1 = scanner.nextLine();
            password = password1;
            if (validate.validatePassword(password1)){
                checkPassword = true;
            }else {
                System.err.println("Password is not in the correct format, please re-enter");
            }
        }while (!checkPassword);

        showListSavingPackage();
        SavingPackage savingPackage = null;
        System.out.println("Enter id saving package you choice:  ");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 0) {
            System.out.println("----------------------------------------------------");
            System.out.println("--------------Creat new saving package--------------");
            addSavingPackage();
            showListSavingPackage();
        } else if (savingPackageManager.getById(choice) == null && choice != savingPackageManager.getSavingPackages().size() + 1) {
            System.out.println("Id saving package not exist");
        }
        savingPackage = savingPackageManager.getById(choice);

        showListLoanPackage();
        LoanPackage loanPackage = null;
        System.out.println("Enter id loan package you choice:  ");
        int choice1 = Integer.parseInt(scanner.nextLine());
        if (choice1 == 0) {
            System.out.println("----------------------------------------------------");
            System.out.println("--------------Creat new loan package--------------");
            addLoanPackage();
            showListLoanPackage();
        } else if (loanPackageManager.getById(choice1) == null && choice1 != loanPackageManager.getLoanPackages().size() + 1) {
            System.out.println("Id loan package not exist");
        }
        loanPackage = loanPackageManager.getById(choice1);

        return new Customer(name, age, gender, dayOfBirth, address, phoneNumber, email, work, accountBalance, password, savingPackage, loanPackage);
    }

    public void updateCustomerById() {
        displayAllCustomer();
        System.out.println("Enter Id customer you want update");
        int id = Integer.parseInt(scanner.nextLine());
        if (customerManager.checkId(id)) {
            Customer customer = customerManager.getById(id);
            System.out.println("----------------------------------------------------");
            System.out.println("Customer you want update is: \n" + customer);
            System.out.println("----------------------------------------------------");
            System.out.println("Enter new name: ");
            String name = scanner.nextLine();
            customer.setName(name);
            System.out.println("Enter new age: ");
            String age = scanner.nextLine();
            customer.setAge(age);
            System.out.println("Enter new gender: ");
            String gender = scanner.nextLine();
            customer.setGender(gender);
            System.out.println("Enter new day of birth: ");
            String dayOfBirth = scanner.nextLine();
            customer.setDayOfBirth(dayOfBirth);
            System.out.println("Enter new address: ");
            String address = scanner.nextLine();
            customer.setAddress(address);
            System.out.println("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();
            customer.setPhoneNumber(phoneNumber);
            System.out.println("Enter new email: ");
            String email = scanner.nextLine();
            customer.setEmail(email);
            System.out.println("Enter new work: ");
            String work = scanner.nextLine();
            customer.setWork(work);
            System.out.println("Enter new account balance: ");
            double accountBalance = Double.parseDouble(scanner.nextLine());
            customer.setaccountBalance(accountBalance);

            showListSavingPackage();
            SavingPackage savingPackage = null;
            System.out.println("Enter id saving package you choice:  ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) {
                System.out.println("----------------------------------------------------");
                System.out.println("--------------Creat new saving package--------------");
                addSavingPackage();
                showListSavingPackage();
            } else if (savingPackageManager.getById(choice) == null && choice != savingPackageManager.getSavingPackages().size() + 1) {
                System.out.println("Id saving package not exist");
            }
            savingPackage = savingPackageManager.getById(choice);
            customer.setSavingPackage(savingPackage);

            showListLoanPackage();
            LoanPackage loanPackage = null;
            System.out.println("Enter id loan package you choice:  ");
            int choice1 = Integer.parseInt(scanner.nextLine());
            if (choice1 == 0) {
                System.out.println("----------------------------------------------------");
                System.out.println("--------------Creat new loan package--------------");
                addLoanPackage();
                showListLoanPackage();
            } else if (loanPackageManager.getById(choice1) == null && choice1 != loanPackageManager.getLoanPackages().size() + 1) {
                System.out.println("Id loan package not exist");
            }
            loanPackage = loanPackageManager.getById(choice);
            customer.setLoanPackage(loanPackage);
            customerManager.updateById(customer);
            System.out.println("-----------------UPDATE SUCCESSFULLY----------------");
            System.out.println("----------------------------------------------------");
            System.out.println("----------------CUSTOMER AFTER UPDATE---------------");
            System.out.println(customer);
            System.out.println("----------------------------------------------------");
        } else {
            System.out.println("Id customer not exist!");
        }
    }

    public void updateCustomerByName() {
        displayAllCustomer();
        System.out.println("Enter name customer you want update");
        String name1 = scanner.nextLine();
        Customer customer = null;
        if (customerManager.checkName(name1)) {
            for (Customer cs : customerManager.getCustomers()) {
                if (cs.getName().equals(name1)) {
                    customer = cs;
                    break;
                }
            }
            System.out.println("----------------------------------------------------");
            System.out.println("Customer you want update is: \n" + customer);
            System.out.println("----------------------------------------------------");
            System.out.println("Enter new name: ");
            String name = scanner.nextLine();
            customer.setName(name);
            System.out.println("Enter new age: ");
            String age = scanner.nextLine();
            customer.setAge(age);
            System.out.println("Enter new gender: ");
            String gender = scanner.nextLine();
            customer.setGender(gender);
            System.out.println("Enter new day of birth: ");
            String dayOfBirth = scanner.nextLine();
            customer.setDayOfBirth(dayOfBirth);
            System.out.println("Enter new address: ");
            String address = scanner.nextLine();
            customer.setAddress(address);
            System.out.println("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();
            customer.setPhoneNumber(phoneNumber);
            System.out.println("Enter new email: ");
            String email = scanner.nextLine();
            customer.setEmail(email);
            System.out.println("Enter new work: ");
            String work = scanner.nextLine();
            customer.setWork(work);
            System.out.println("Enter new account balance: ");
            double accountBalance = Double.parseDouble(scanner.nextLine());
            customer.setaccountBalance(accountBalance);

            showListSavingPackage();
            SavingPackage savingPackage = null;
            System.out.println("Enter id saving package you choice:  ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) {
                System.out.println("----------------------------------------------------");
                System.out.println("--------------Creat new saving package--------------");
                addSavingPackage();
                showListSavingPackage();
            } else if (savingPackageManager.getById(choice) == null && choice != savingPackageManager.getSavingPackages().size() + 1) {
                System.out.println("Id saving package not exist");
            }
            savingPackage = savingPackageManager.getById(choice);
            customer.setSavingPackage(savingPackage);

            showListLoanPackage();
            LoanPackage loanPackage = null;
            System.out.println("Enter id loan package you choice:  ");
            int choice1 = Integer.parseInt(scanner.nextLine());
            if (choice1 == 0) {
                System.out.println("----------------------------------------------------");
                System.out.println("--------------Creat new loan package--------------");
                addLoanPackage();
                showListLoanPackage();
            } else if (loanPackageManager.getById(choice1) == null && choice1 != loanPackageManager.getLoanPackages().size() + 1) {
                System.out.println("Id loan package not exist");
            }
            loanPackage = loanPackageManager.getById(choice);
            customer.setLoanPackage(loanPackage);
            customerManager.updateByName(customer);
            System.out.println("-----------------UPDATE SUCCESSFULLY----------------");
            System.out.println("----------------------------------------------------");
            System.out.println("----------------CUSTOMER AFTER UPDATE---------------");
            System.out.println(customer);
            System.out.println("----------------------------------------------------");
        } else {
            System.out.println("Name customer not exist!");
        }
    }

    public void deleteCustomerById() {
        displayAllCustomer();
        System.out.println("Enter id customer you want delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (customerManager.checkId(id)) {
            System.out.println("----------------------------------------------------");
            System.out.println("Customer you want delete is : \n" + customerManager.getById(id));
            System.out.println("----------------------------------------------------");
            System.out.println("Are you sure you want to delete?");
            System.out.println("1. YES       2. NO");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    customerManager.deleteById(id);
                    System.out.println("---------------Delete successfully!---------------");
                    break;
                case 2:
                    System.out.println("Do you want to delete another customer?");
                    System.out.println("1. YES       2. NO");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    do {
                        if (choice1 == 1) {
                            deleteCustomerById();
                            customerManager.updateIdCustomer();
                        }
                    } while (choice1 != 2);
                    break;
            }
        }
    }

    public void deleteCustomerByName() {
        displayAllCustomer();
        System.out.println("Enter name customer you want delete: ");
        String name = scanner.nextLine();
        if (customerManager.checkName(name)) {
            System.out.println("----------------------------------------------------");
            System.out.println("Customer you want delete is : \n" + customerManager.getByName(name));
            System.out.println("----------------------------------------------------");
            System.out.println("Are you sure you want to delete?");
            System.out.println("1. YES       2. NO");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    customerManager.deleteByName(name);
                    System.out.println("---------------Delete successfully!---------------");
                    break;
                case 2:
                    System.out.println("Do you want to delete another customer?");
                    System.out.println("1. YES       2. NO");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    do {
                        if (choice1 == 1) {
                            deleteCustomerByName();
                            customerManager.updateIdCustomer();
                        }
                    } while (choice1 != 2);
                    break;
            }
        }
    }

    //
//public String inputString(String string , Scanner scanner){
//    System.out.println(string);
//    return scanner.nextLine();
//}
    public void displayAllCustomer() {
        customerManager.setCustomers(customerManager.readObject());
        System.out.println("------------------------LIST CUSTOMER------------------------");
        ArrayList<Customer> arrayList = customerManager.getCustomers();
        for (Customer customer : arrayList) {
            System.out.println(customer);
        }
        System.out.println("-------------------------------------------------------------");
    }

    public void displayCustomerById() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Enter id customer you want display: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (customerManager.checkId(id)) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Customer you want display is: \n");
            customerManager.displayByid(id);
            System.out.println("----------------------------------------------------------");
        } else {
            System.out.println("Id customer not exist!");
        }
    }

    public void displayCustomerByName() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Enter name customer you want display: ");
        String name = scanner.nextLine();
        if (customerManager.checkName(name)) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Customer you want display is: \n");
            customerManager.displayByName(name);
            System.out.println("----------------------------------------------------------");
        } else {
            System.out.println("Name customer not exist!");
        }
    }

//    LoanPackageManager

    public LoanPackage addLoanPackage() {
        LoanPackage loanPackage = createLoanPankage();
        loanPackage.setId(loanPackageManager.checkSizeLoanPackage());
        loanPackageManager.add(loanPackage);
        return loanPackage;
    }

    public LoanPackage createLoanPankage() {
        System.out.println("Enter loan package name: ");
        String name = scanner.nextLine();
        System.out.println("Enter loan money: ");
        int loanMoney = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter period: ");
        int period = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter interest rate:  ");
        double interestRate = Double.parseDouble(scanner.nextLine());
        return new LoanPackage(name, loanMoney, period, interestRate);
    }

    public void updateLoanPankageById() {
        showAllLoanPackage();
        System.out.println("Enter id loan package you want update: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (loanPackageManager.checkId(id)) {
            LoanPackage loanPackage = loanPackageManager.getById(id);
            System.out.println("-----------------------------------------------");
            System.out.println("Loan package you want update: \n" + loanPackage);
            System.out.println("-----------------------------------------------");
            System.out.println("Enter new loan package name: ");
            String loanPackageName = scanner.nextLine();
            loanPackage.setLoanPackageName(loanPackageName);
            System.out.println("Enter new loan money: ");
            int loanMoney = Integer.parseInt(scanner.nextLine());
            loanPackage.setLoanMoney(loanMoney);
            System.out.println("Enter new period: ");
            int period = Integer.parseInt(scanner.nextLine());
            loanPackage.setPeriod(period);
            System.out.println("Enter new interest rate: ");
            double interestRate = Double.parseDouble(scanner.nextLine());
            loanPackage.setInterestRate(interestRate);
            loanPackageManager.updateById(loanPackage);
            System.out.println("-----------------UPDATE SUCCESSFULLY----------------");
            System.out.println("----------------------------------------------------");
            System.out.println("--------------LOANPACKAGE AFTER UPDATE--------------");
            System.out.println(loanPackage);
            System.out.println("----------------------------------------------------");
        } else {
            System.out.println("Id loan package not exist!");
        }

    }

    public void updateLoanPackageByName() {
        showAllLoanPackage();
        System.out.println("Enter name loan package you want update: ");
        String name = scanner.nextLine();
        LoanPackage loanPackage = null;
        for (LoanPackage ld : loanPackageManager.getLoanPackages()) {
            if (ld.getLoanPackageName().equals(name)) {
                loanPackage = ld;
                break;
            }
        }
        if (loanPackage != null) {
            System.out.println("-----------------------------------------------");
            System.out.println("Loan package you want update: \n" + loanPackage);
            System.out.println("-----------------------------------------------");
            System.out.println("Enter new loan package name: ");
            String loanPackageName = scanner.nextLine();
            loanPackage.setLoanPackageName(loanPackageName);
            System.out.println("Enter new loan money: ");
            int loanMoney = Integer.parseInt(scanner.nextLine());
            loanPackage.setLoanMoney(loanMoney);
            System.out.println("Enter new period: ");
            int period = Integer.parseInt(scanner.nextLine());
            loanPackage.setPeriod(period);
            System.out.println("Enter new interest rate: ");
            double interestRate = Double.parseDouble(scanner.nextLine());
            loanPackage.setInterestRate(interestRate);
            loanPackageManager.updateById(loanPackage);
            System.out.println("-----------------UPDATE SUCCESSFULLY----------------");
            System.out.println("----------------------------------------------------");
            System.out.println("--------------LOANPACKAGE AFTER UPDATE--------------");
            System.out.println(loanPackage);
            System.out.println("----------------------------------------------------");
        } else {
            System.out.println("Name loan package not exist!");
        }

    }

    public void deleteLoanPackageById() {
        showAllLoanPackage();
        System.out.println("Enter id loan package you want delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (loanPackageManager.checkId(id)) {
            System.out.println("-----------------------------------------------");
            System.out.println("Loan package you want delete is: \n" + loanPackageManager.getById(id));
            System.out.println("-----------------------------------------------");
            System.out.println("Are you sure you want to delete?");
            System.out.println("1. YES       2. NO");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    loanPackageManager.deleteById(id);
                    System.out.println("---------------Delete successfully!---------------");
                    break;
                case 2:
                    System.out.println("Do you want to delete another loan package?");
                    System.out.println("1. YES       2. NO");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    do {
                        if (choice1 == 1) {
                            deleteLoanPackageById();
                        }
                    } while (choice1 != 2);
                    break;
            }

        } else {
            System.out.println("id loan package not exist!");
        }
    }

    public void deleteLoanPackageByName() {
        showAllLoanPackage();
        System.out.println("Enter name loan package you want delete: ");
        String name = scanner.nextLine();
        LoanPackage loanPackage = null;
        for (LoanPackage ld : loanPackageManager.getLoanPackages()) {
            if (ld.getLoanPackageName().equals(name)) {
                loanPackage = ld;
                break;
            }
        }
        if (loanPackage != null) {
            System.out.println("-----------------------------------------------");
            System.out.println("Loan package you want delete is: \n" + loanPackage);
            System.out.println("-----------------------------------------------");
            System.out.println("Are you sure you want to delete?");
            System.out.println("1. YES       2. NO");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    loanPackageManager.deleteByName(name);
                    System.out.println("---------------Delete successfully!---------------");
                    break;
                case 2:
                    System.out.println("Do you want to delete another loan package?");
                    System.out.println("1. YES       2. NO");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    do {
                        if (choice1 == 1) {
                            deleteLoanPackageByName();
                        }
                    } while (choice1 != 2);
                    break;
            }
        } else {
            System.out.println("name loan package not exist!");
        }
    }

    public void showListLoanPackage() {
        System.out.println("------------------------LIST LOAN PACKAGE------------------------");
        ArrayList<LoanPackage> arrayList = loanPackageManager.getLoanPackages();
        for (LoanPackage ld : arrayList) {
            System.out.println(ld.getId() + ". " + ld);
        }
        System.out.println(loanPackageManager.getLoanPackages().size() + 1 + ". exit");
        System.out.println("0. Creat new loan package");
    }

    public void showAllLoanPackage() {
        loanPackageManager.setLoanPackages(loanPackageManager.readObject());
        System.out.println("------------------------LIST LOAN PACKAGE------------------------");
        ArrayList<LoanPackage> arrayList = loanPackageManager.getLoanPackages();
        for (LoanPackage ld : arrayList) {
            System.out.println(ld);
        }
        System.out.println("-----------------------------------------------------------------");
    }

    public void displayLoanPackageById() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Enter id loan package you want display: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (loanPackageManager.checkId(id)) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Loan package you want display is: \n");
            loanPackageManager.displayByid(id);
            System.out.println("----------------------------------------------------------");
        } else {
            System.out.println("Id loan package not exist!");
        }
    }

    public void displayLoanPackageByName() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Enter name loan package you want display: ");
        String name = scanner.nextLine();
        if (loanPackageManager.checkName(name)) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Loan package you want display is: \n");
            loanPackageManager.displayByName(name);
            System.out.println("----------------------------------------------------------");
        } else {
            System.out.println("Name loan package not exist!");
        }
    }

    //    SavingPackageManager
    public SavingPackage addSavingPackage() {
        SavingPackage savingPackage = createSavingPackage();
        savingPackage.setId(savingPackageManager.checkSizeSavingPackage());
        savingPackageManager.add(savingPackage);
        return savingPackage;
    }

    public SavingPackage createSavingPackage() {
        System.out.println("Enter saving package name: ");
        String name = scanner.nextLine();
        System.out.println("Enter saving money: ");
        int savingMoney = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter period: ");
        int period = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter interest rate:  ");
        double interestRate = Double.parseDouble(scanner.nextLine());
        return new SavingPackage(name, savingMoney, period, interestRate);
    }

    public void updateSavingPackageById() {
        showAllSavingPackage();
        System.out.println("Enter id saing package you want update:");
        int id = Integer.parseInt(scanner.nextLine());
        if (savingPackageManager.checkId(id)) {
            SavingPackage savingPackage = savingPackageManager.getById(id);
            System.out.println("-----------------------------------------------");
            System.out.println("Saving package you want update: \n" + savingPackage);
            System.out.println("-----------------------------------------------");
            System.out.println("Enter new saing package name: ");
            String savingPackageName = scanner.nextLine();
            savingPackage.setSavingPackageName(savingPackageName);
            System.out.println("Enter new saving money: ");
            int savingMoney = Integer.parseInt(scanner.nextLine());
            savingPackage.setSavingMoney(savingMoney);
            System.out.println("Enter new period: ");
            int period = Integer.parseInt(scanner.nextLine());
            savingPackage.setPeriod(period);
            System.out.println("Enter new interest rate: ");
            double interestRate = Double.parseDouble(scanner.nextLine());
            savingPackage.setInterestRate(interestRate);
            savingPackageManager.updateById(savingPackage);
            System.out.println("-----------------UPDATE SUCCESSFULLY----------------");
            System.out.println("----------------------------------------------------");
            System.out.println("-------------SAVINGPACKAGE AFTER UPDATE-------------");
            System.out.println(savingPackage);
            System.out.println("----------------------------------------------------");
        } else {
            System.out.println("Id saving package not exist");
        }
    }

    public void updateSavingPackageByName() {
        showAllSavingPackage();
        System.out.println("Enter name saving package you want update: ");
        String name = scanner.nextLine();
        SavingPackage savingPackage = null;
        for (SavingPackage sv : savingPackageManager.getSavingPackages()) {
            if (sv.getSavingPackageName().equals(name)) {
                savingPackage = sv;
                break;
            }
        }
        if (savingPackage != null) {
            System.out.println("-----------------------------------------------");
            System.out.println("Saving package you want update: \n" + savingPackage);
            System.out.println("-----------------------------------------------");
            System.out.println("Enter new saving package name: ");
            String savingPackageName = scanner.nextLine();
            savingPackage.setSavingPackageName(savingPackageName);
            System.out.println("Enter new saving money: ");
            int savingMoney = Integer.parseInt(scanner.nextLine());
            savingPackage.setSavingMoney(savingMoney);
            System.out.println("Enter new period: ");
            int period = Integer.parseInt(scanner.nextLine());
            savingPackage.setPeriod(period);
            System.out.println("Enter new interest rate: ");
            double interestRate = Double.parseDouble(scanner.nextLine());
            savingPackage.setInterestRate(interestRate);
            savingPackageManager.updateById(savingPackage);
            System.out.println("-----------------UPDATE SUCCESSFULLY----------------");
            System.out.println("----------------------------------------------------");
            System.out.println("-------------SAVINGPACKAGE AFTER UPDATE-------------");
            System.out.println(savingPackage);
            System.out.println("----------------------------------------------------");
        } else {
            System.out.println("Name saving package not exist!");
        }
    }

    public void deleteSavingPackageById() {
        showAllSavingPackage();
        System.out.println("Enter id saving package you want delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (savingPackageManager.checkId(id)) {
            System.out.println("-----------------------------------------------");
            System.out.println("Saving package you want delete is: \n" + savingPackageManager.getById(id));
            System.out.println("-----------------------------------------------");
            System.out.println("Are you sure you want to delete?");
            System.out.println("1. YES       2. NO");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    savingPackageManager.deleteById(id);
                    System.out.println("---------------Delete successfully!---------------");
                    break;
                case 2:
                    System.out.println("Do you want to delete another saving package?");
                    System.out.println("1. YES       2. NO");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    do {
                        if (choice1 == 1) {
                            deleteSavingPackageById();
                        }
                    } while (choice1 != 2);
                    break;
            }

        } else {
            System.out.println("id saving package not exist!");
        }
    }

    public void deleteSavingPackageByName() {
        showAllSavingPackage();
        System.out.println("Enter name saving package you want delete: ");
        String name = scanner.nextLine();
        SavingPackage savingPackage = null;
        for (SavingPackage sv : savingPackageManager.getSavingPackages()) {
            if (sv.getSavingPackageName().equals(name)) {
                savingPackage = sv;
                break;
            }
        }
        if (savingPackage != null) {
            System.out.println("-----------------------------------------------");
            System.out.println("Saving package you want delete is: \n" + savingPackage);
            System.out.println("-----------------------------------------------");
            System.out.println("Are you sure you want to delete?");
            System.out.println("1. YES       2. NO");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    savingPackageManager.deleteByName(name);
                    System.out.println("---------------Delete successfully!---------------");
                    break;
                case 2:
                    System.out.println("Do you want to delete another saving package?");
                    System.out.println("1. YES       2. NO");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    do {
                        if (choice1 == 1) {
                            deleteSavingPackageByName();
                        }
                    } while (choice1 != 2);
                    break;
            }
        } else {
            System.out.println("name saving package not exist!");
        }
    }

    public void showAllSavingPackage() {
        savingPackageManager.setSavingPackages(savingPackageManager.readObject());
        System.out.println("------------------------LIST SAVING PACKAGE------------------------");
        ArrayList<SavingPackage> arrayList = savingPackageManager.getSavingPackages();
        for (SavingPackage sv : arrayList) {
            System.out.println(sv);
        }
        System.out.println("-----------------------------------------------------------------");
    }

    public void showListSavingPackage() {
        System.out.println("------------------------LIST SAVING PACKAGE------------------------");
        ArrayList<SavingPackage> arrayList = savingPackageManager.getSavingPackages();
        for (SavingPackage sv : arrayList) {
            System.out.println(sv.getId() + ". " + sv);
        }
        System.out.println(savingPackageManager.getSavingPackages().size() + 1 + ". exit");
        System.out.println("0. Creat new saving package");
    }

    public void displaySavingPackageById() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Enter id saving package you want display: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (savingPackageManager.checkId(id)) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Saving package you want display is: \n");
            savingPackageManager.displayByid(id);
            System.out.println("----------------------------------------------------------");
        } else {
            System.out.println("Id saving package not exist!");
        }
    }


    public void displaySavingPackageByName() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Enter name saving package you want display: ");
        String name = scanner.nextLine();
        if (savingPackageManager.checkName(name)) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Saving package you want display is: \n");
            savingPackageManager.displayByName(name);
            System.out.println("----------------------------------------------------------");
        } else {
            System.out.println("Name saving package not exist!");
        }
    }

    //    AccountManager
    public Account addAccount() {
        Account account = creatAccount();
        account.setId(accountManager.checkSizeAccount());
        accountManager.add(account);
        System.out.println("------------ Register Successful ------------ ");
        return account;
    }

    public Account creatAccount() {
        System.out.println("------------Create a new account------------");
        System.out.println("Enter new login: ");
        String login = scanner.nextLine();
        System.out.println("Enter new password: ");
        String password = scanner.nextLine();
        return new Account(login, password);
    }

    public boolean RegisterAccount() {
        System.out.println("Enter login: ");
        String user = scanner.nextLine();
        if (validate.validateLogin(user)) {
            System.out.println("Enter password: ");
            String password = scanner.nextLine();
            if (validate.validatePassword(password)) {
                if (accountManager.checkRegister(user, password)) {
                    System.out.println("------------ Login Successful ------------");
                    return true;
                }
                return false;
            } else {
                System.err.println("The password is not in the correct format, please re-enter!");
                RegisterAccount();
            }
        } else {
            System.err.println("The login is not in the correct format, please re-enter!");
            RegisterAccount();
        }
        return false;
    }

    public void updateAccountById() {
        showAllAccount();
        System.out.println("Enter id account you want update: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (accountManager.checkId(id)) {
            Account account = accountManager.getById(id);
            System.out.println("-----------------------------------------------");
            System.out.println("Account you want change password is: \n" + account);
            System.out.println("-----------------------------------------------");
            System.out.println("Enter new password: ");
            String password = scanner.nextLine();
            account.setPassword(password);
            accountManager.updateById(account);
        } else {
            System.out.println("Id account not exist");
        }
    }

    public void updateAccountBylogin() {
        showAllAccount();
        System.out.println("Enter login account you want update: ");
        String login = scanner.nextLine();
        if (accountManager.checkLogin(login)) {
            Account account = accountManager.getByName(login);
            System.out.println("-----------------------------------------------");
            System.out.println("Account you want change password is: \n" + account);
            System.out.println("-----------------------------------------------");
            System.out.println("Enter new password: ");
            String password = scanner.nextLine();
            account.setPassword(password);
            accountManager.updateByName(account);
        } else {
            System.out.println("Login account not exist");
        }
    }

    public void deleteAccountById() {
        showAllAccount();
        System.out.println("Enter id account you want delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (accountManager.checkId(id)) {
            System.out.println("-----------------------------------------------");
            System.out.println("Account you want delete is: \n" + accountManager.getById(id));
            System.out.println("-----------------------------------------------");
            System.out.println("Are you sure you want to delete?");
            System.out.println("1. YES       2. NO");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    accountManager.deleteById(id);
                    System.out.println("---------------Delete successfully!---------------");
                    break;
                case 2:
                    System.out.println("Do you want to delete another account?");
                    System.out.println("1. YES       2. NO");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    do {
                        if (choice1 == 1) {
                            deleteAccountById();
                        }
                    } while (choice1 != 2);
                    break;
            }
        } else {
            System.out.println("id account not exist!");
        }
    }

    public void deleteAccountBylogin() {
        showAllAccount();
        System.out.println("Enter login account you want delete: ");
        String login = scanner.nextLine();
        Account account = null;
        account = accountManager.getByName(login);
        if (account != null) {
            System.out.println("-----------------------------------------------");
            System.out.println("Account you want delete is: \n" + account);
            System.out.println("-----------------------------------------------");
            System.out.println("Are you sure you want to delete?");
            System.out.println("1. YES       2. NO");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    accountManager.deleteByName(login);
                    System.out.println("---------------Delete successfully!---------------");
                    break;
                case 2:
                    System.out.println("Do you want to delete another account?");
                    System.out.println("1. YES       2. NO");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    do {
                        if (choice1 == 1) {
                            deleteAccountBylogin();
                        }
                    } while (choice1 != 2);
                    break;
            }
        } else {
            System.out.println("Login account not exist!");
        }
    }

    public boolean checkLogin(String phoneNumber, String password) {
        ArrayList<Customer> customers = customerManager.readObject();
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber) && customer.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public Customer getCustomerAtm(String phoneNumber, String password) {
        Customer customer = null;
        ArrayList<Customer> customers = customerManager.readObject();
        for (Customer customer1 : customers) {
            if (customer1.getPhoneNumber().equals(phoneNumber) && customer1.getPassword().equals(password)) {
                customer = customer1;
                break;
            }
        }
        return customer;
    }

    public boolean checkWithdrawMoney(double money, Customer customer) {
        if (money < customer.getaccountBalance() && money > 50000 && money % 50000 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkSendMoney(double money) {
        if (money > 0) {
            return true;
        }
        return false;
    }

    public String changeAccountBalance(double a) {
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String accountBalance = numberFormat.format(a);
        return accountBalance;
    }

    public void getBill(double money) {
        int choice;
        do {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Do you want to get the bill? ");
            System.out.println("1. YES                       2. NO");
            System.out.println(" =======> CHOICE: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("                      YOUR WITHDRAWAL BILL IS: " + changeAccountBalance(money) + "");
                    System.out.println("--------------------------------------------------------------------------------");

                    break;
                case 2:
                    break;
            }
        } while (choice != 2 && choice != 1);
    }

    public double choiceWithdraw() {
        int choice;
        double money = 0;
        do {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("|                                                                              |");
            System.out.println("|        1. 500.000đ                                      2. 1.000.000đ        |");
            System.out.println("|                                                                              |");
            System.out.println("|        3. 1.500.000đ                                    4. 2.000.000đ        |");
            System.out.println("|                                                                              |");
            System.out.println("|                              5. Another choice                               |");
            System.out.println("|                                                                              |");
            System.out.println("--------------------------------------------------------------------------------");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    money = 500000;
                    return money;
                case 2:
                    money = 1000000;
                    return money;
                case 3:
                    money = 1500000;
                    return money;
                case 4:
                    money = 2000000;
                    return money;
                case 5:
                    System.out.println("Enter the money you want to withdraw: ");
                    money = Double.parseDouble(scanner.nextLine());
                    return money;
            }
        } while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5);
        return money;
    }

    public void withdraw(double money, Customer customer) {
        int choice;
        if (checkWithdrawMoney(money, customer)) {
            do {
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("The money you want to withdraw is: \n" + "Withdraw: " + changeAccountBalance(money));
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("Are you sure you want to withdraw?");
                System.out.println("1. YES                       2. NO");
                System.out.println(" =======> CHOICE: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        customer.setaccountBalance(customer.getaccountBalance() - money);
                        customerManager.updateById(customer);
                        getBill(money);
                        System.out.println("----------------------------Withdrawal successful-------------------------------");
                        break;
                }
            } while (choice != 2 && choice != 1);
        } else {
            System.out.println("----------------Invalid withdrawal amount----------------");
        }
    }

    public void depositMoney(double money, Customer customer) {
        if (checkSendMoney(money)) {
            customer.setaccountBalance(customer.getaccountBalance() + money);
            customerManager.updateById(customer);
            System.out.println("------------------------------Deposit  successful-------------------------------");
        } else {
            System.out.println("                        The bank deposit amount is not enough");
            System.out.println("---------------------------------Deposit failed---------------------------------");
        }
    }

    public void changePassword(Customer customer) {
        boolean checkPassword = false;
        String password;
        do {
            System.out.println("Enter password: ");
            String password1 = scanner.nextLine();
            password = password1;
            if (validate.validatePassword(password1)){
                checkPassword = true;
            }else {
                System.err.println("Password is not in the correct format, please re-enter");
            }
        }while (!checkPassword);
        customer.setPassword(password);
        customerManager.updateById(customer);
    }

    public boolean checkCustomerByPhoneNumber(String phoneNumber){
        ArrayList<Customer> customers = customerManager.readObject();
        for (Customer customer1 : customers) {
            if (customer1.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public Customer getCustomerByPhoneNumber(String phoneNumber){
        Customer customer = null;
        ArrayList<Customer> customers = customerManager.readObject();
        for (Customer customer1 : customers) {
            if (customer1.getPhoneNumber().equals(phoneNumber)) {
                customer = customer1;
                break;
            }
        }
        return customer;
    }
    public String changeMoney(Double money){
        double a = money;
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String money1 = numberFormat.format(a);
        return money1;
    }
    public void transfer(Customer customer, Customer customer1){
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Enter money you want transfer: ");
        Double money = Double.parseDouble(scanner.nextLine());
        if (money > 0){
            int choice;
            do {
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("money you want transfer is: " + changeMoney(money));
                System.out.println("Do you agree to transfer ?");
                System.out.println("1. YES               2. NO");
                System.out.println(" =======> CHOICE: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1 :
                        customer.setaccountBalance(customer.getaccountBalance() - money);
                        customerManager.updateById(customer);
                        System.out.println("-------Transfer successful!-------");
                        customer1.setaccountBalance(customer1.getaccountBalance() + money);
                        customerManager.updateById(customer1);

                        break;
                }
            }while (choice != 1 && choice != 2);

        }else {
            System.err.println("Invalid transfer amount");
            transfer(customer, customer1);
        }
    }

    public void transferMoney(Customer customer){
        System.out.println("Enter phone number customer you want: ");
        String phoneNumber = scanner.nextLine();
        if (checkCustomerByPhoneNumber(phoneNumber)){
            Customer customer1 = getCustomerByPhoneNumber(phoneNumber);
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Customer you want transfer is: ");
            System.out.println(customer1);
            transfer(customer, customer1);
        }else {
            System.err.println("Phone Number is not exist");
        }
    }

    public void atmBanking(Customer customer) {
        int choice;
        do {
            System.out.println("\n");
            System.out.println("------------------------------ATM BANKING ONLINE--------------------------------");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("                      " + customer.getName() + "  -  Balance: " + customer.changeBalanceCustomer());
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("|                                                                              |");
            System.out.println("|           1. Withdraw Money                         2. Deposit Money         |");
            System.out.println("|                                                                              |");
            System.out.println("|           3. Change Password                        4. Transfer Money        |");
            System.out.println("|                                                                              |");
            System.out.println("|                                     0. EXIT                                  |");
            System.out.println("|                                                                              |");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println(" =======> CHOICE: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Double money = choiceWithdraw();
                    withdraw(money, customer);
                    break;
                case 2:
                    System.out.println("Enter the money you want to deposit: ");
                    double money1 = Double.parseDouble(scanner.nextLine());
                    depositMoney(money1, customer);
                    break;
                case 3:
                    changePassword(customer);
                    break;
                case 4:
                    transferMoney(customer);
                    break;
            }
        } while (choice != 0);
    }

    public void loginAtm() {
        System.out.println("-------------------------LOGIN-------------------------");
        System.out.println("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        Customer customer = getCustomerAtm(phoneNumber, password);
        if (checkLogin(phoneNumber, password)) {
            atmBanking(customer);
        } else {
            System.out.println("--------------------- Login Failed! -------------------");
        }
    }

    public void showAllAccount() {
        accountManager.setAccounts(AccountManager.readObject());
        System.out.println("-------------------------LIST ACCOUNT-------------------------");
        ArrayList<Account> arrayList = accountManager.getAccounts();
        for (Account account : arrayList) {
            System.out.println(account);
        }
        System.out.println("-----------------------------------------------------------------");
    }
}
