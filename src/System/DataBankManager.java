package System;

import Service.IMPL.CustomerManager;
import Service.IMPL.SystemManager;

import java.util.Scanner;

public class DataBankManager {

    public DataBankManager() {
    }
    public void connection () {
        SystemManager systemManager = new SystemManager();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
        try {
            
                System.out.println("--------------------------------SYSTEM MANAGEMENT-------------------------------");
                System.out.println("|                                                                              |");
                System.out.println("|                          1. Bank Data Management System                      |");
                System.out.println("|                                                                              |");
                System.out.println("|                          2. ATM Banking Online                               |");
                System.out.println("|                                                                              |");
                System.out.println("|                          0. EXIT                                             |");
                System.out.println("|                                                                              |");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println(" =======> CHOICE: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        register(scanner, systemManager);
                        break;
                    case 2:
                        systemManager.loginAtm();
                        break;
                }
        }catch (NumberFormatException e){
            System.err.println("The selection is not in the correct format, please choose again!");
        }
    }while (choice!= 0);
    }

    public static void register(Scanner scanner, SystemManager systemManager){
        int choice = -1;
        do {
            try {
                System.out.println("--------------------------PLEASE LOGIN TO MANAGE DATA---------------------------");
                System.out.println("|                                                                              |");
                System.out.println("|                         1. Log in                                            |");
                System.out.println("|                                                                              |");
                System.out.println("|                         2. Register                                          |");
                System.out.println("|                                                                              |");
                System.out.println("|                         0. EXIT                                              |");
                System.out.println("|                                                                              |");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println(" =======> CHOICE: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        if (login(scanner, systemManager)){
                            return;
                        }else {
                            int choice1 = Integer.parseInt(scanner.nextLine());
                            switch (choice1){
                                case 2: systemManager.addAccount();
                                    break;
                            }
                        }
                        break;
                    case 2:
                        systemManager.addAccount();
                        break;
                }
            }catch (NumberFormatException e){
                System.err.println("The selection is not in the correct format, please choose again!");
            }
        }while (choice != 0);

    }
    public static boolean login(Scanner scanner, SystemManager systemManager){
        if (systemManager.RegisterAccount()){
            system(scanner, systemManager);
            return true;
        }else {
            System.out.println("----------------- Login Failed! ----------------");
            System.out.println("------------------------------------------------");
            System.out.println("--------------The login is not exit!------------");
            System.out.println("Do you want to re-login or create a new account?");
            System.out.println("1. Re-login              2. Create a new account");
            System.out.println(" =======> CHOICE: ");
        }
        return false;
    }
    public static void system(Scanner scanner, SystemManager systemManager){
        int choice = -1;
        do {
            try {
                System.out.println("--------------------------BANK DATA MANAGEMENT SYSTEM---------------------------");
                System.out.println("|                                                                              |");
                System.out.println("|                         1. CUSTOMER DATA MANAGEMENT                          |");
                System.out.println("|                                                                              |");
                System.out.println("|                         2. LOAN PACKAGE DATA MANAGEMENT                      |");
                System.out.println("|                                                                              |");
                System.out.println("|                         3. SAVING PACKAGE DATA MANAGEMENT                    |");
                System.out.println("|                                                                              |");
                System.out.println("|                         4. ACCOUNT DATA MANAGEMENT                           |");
                System.out.println("|                                                                              |");
                System.out.println("|                         0. EXIT                                              |");
                System.out.println("|                                                                              |");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println(" =======> CHOICE: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        customerManager(scanner, systemManager);
                        break;
                    case 2:
                        loanPackageManager(scanner, systemManager);
                        break;
                    case 3:
                        savingPackageManager(scanner, systemManager);
                        break;
                    case 4:
                        accountManager(scanner, systemManager);
                        break;
                }
            }catch (NumberFormatException e){
                System.err.println("The selection is not in the correct format, please choose again!");
            }

            if (choice != 1 && choice != 2 && choice != 3 && choice != 4  ){
                System.err.println("");
            }
        }while (choice != 0);
    }

    public static void accountManager(Scanner scanner, SystemManager systemManager){
        int choice = -1;
        do {
            try {
                System.out.println("-----------------------------ACCOUNT DATA MANAGEMENT----------------------------");
                System.out.println("|                                                                              |");
                System.out.println("|                              1. Display Account                              |");
                System.out.println("|                                                                              |");
                System.out.println("| 2. Update Password Account By Id                4. Delete Account By Id      |");
                System.out.println("|                                                                              |");
                System.out.println("| 3. Update Password Account By Login             5. Delete Account By Login   |");
                System.out.println("|                                                                              |");
                System.out.println("|                                    0. EXIT                                   |");
                System.out.println("|                                                                              |");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println(" =======> CHOICE: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        systemManager.showAllAccount();
                        break;
                    case 2:
                        systemManager.updateAccountById();
                        break;
                    case 3:
                        systemManager.updateAccountBylogin();
                        break;
                    case 4:
                        systemManager.deleteAccountById();
                        break;
                    case 5:
                        systemManager.deleteAccountBylogin();
                        break;
                }
            }catch (NumberFormatException e){
                System.err.println("The selection is not in the correct format, please choose again!");
            }
        }while (choice != 0);
    }
    public static void customerManager (Scanner scanner, SystemManager systemManager){
        int choice = -1;
        do {
            try {
                System.out.println("----------------------------CUSTOMER DATA MANAGEMENT----------------------------");
                System.out.println("|                                                                              |");
                System.out.println("|                              1. Creat Customer                               |");
                System.out.println("|                                                                              |");
                System.out.println("| 2. Update Customer By Id                         3. Update Customer By Name  |");
                System.out.println("|                                                                              |");
                System.out.println("| 4. Delete Customer By Id                         5. Delete Customer By Name  |");
                System.out.println("|                                                                              |");
                System.out.println("| 6. Display Customer By Id                        7. Display Customer By Name |");
                System.out.println("|                                                                              |");
                System.out.println("|                              8. Display Customer                             |");
                System.out.println("|                                                                              |");
                System.out.println("|                                    0. EXIT                                   |");
                System.out.println("|                                                                              |");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println(" =======> CHOICE: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        systemManager.addCustomer();
                        break;
                    case 2:
                        systemManager.updateCustomerById();
                        break;
                    case 3:
                        systemManager.updateCustomerByName();
                        break;
                    case 4:
                        systemManager.deleteCustomerById();
                        break;
                    case 5:
                        systemManager.deleteCustomerByName();
                        break;
                    case 6:
                        systemManager.displayCustomerById();
                        break;
                    case 7:
                        systemManager.displayCustomerByName();
                        break;
                    case 8:
                        systemManager.displayAllCustomer();
                        break;
                }
            }catch (NumberFormatException e){
                System.err.println("The selection is not in the correct format, please choose again!");
            }
        }while (choice!=0);
    }

    public static void loanPackageManager(Scanner scanner, SystemManager systemManager){
        int choice = -1;
        do {
            try {
                System.out.println("--------------------------LOAN PACKAGE DATA MANAGEMENT--------------------------");
                System.out.println("|                                                                              |");
                System.out.println("|                             1. Creat Loan Package                            |");
                System.out.println("|                                                                              |");
                System.out.println("| 2. Update Loan Package By Id                 3. Update Loan Package By Name  |");
                System.out.println("|                                                                              |");
                System.out.println("| 4. Delete Loan Package By Id                 5. Delete Loan Package By Name  |");
                System.out.println("|                                                                              |");
                System.out.println("| 6. Display Loan Package By Id                7. Display Loan Package By Name |");
                System.out.println("|                                                                              |");
                System.out.println("|                             8. Display Loan Package                          |");
                System.out.println("|                                                                              |");
                System.out.println("|                                     0. EXIT                                  |");
                System.out.println("|                                                                              |");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println(" =======> CHOICE: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        systemManager.addLoanPackage();
                        break;
                    case 2:
                        systemManager.updateLoanPankageById();
                        break;
                    case 3:
                        systemManager.updateLoanPackageByName();
                        break;
                    case 4:
                        systemManager.deleteLoanPackageById();
                        break;
                    case 5:
                        systemManager.deleteLoanPackageByName();
                        break;
                    case 6:
                        systemManager.displayLoanPackageById();
                        break;
                    case 7:
                        systemManager.displayLoanPackageByName();
                        break;
                    case 8:
                        systemManager.showAllLoanPackage();
                        break;
                }
            }catch (NumberFormatException e){
                System.err.println("The selection is not in the correct format, please choose again!");
            }
        }while (choice!= 0);
    }


    public static void savingPackageManager(Scanner scanner, SystemManager systemManager){
        int choice = -1;
        do {
            try {
                System.out.println("-------------------------SAVING PACKAGE DATA MANAGEMENT-------------------------");
                System.out.println("|                                                                              |");
                System.out.println("|                            1. Creat Saving Package                           |");
                System.out.println("|                                                                              |");
                System.out.println("| 2. Update Saving Package By Id              3. Update Saving Package By Name |");
                System.out.println("|                                                                              |");
                System.out.println("| 4. Delete Saving Package By Id              5. Delete Saving Package By Name |");
                System.out.println("|                                                                              |");
                System.out.println("| 6. Display Saving Package By Id             7. Display Saving Package By Name|");
                System.out.println("|                                                                              |");
                System.out.println("|                            8. Display Saving Package                         |");
                System.out.println("|                                                                              |");
                System.out.println("|                                    0. EXIT                                   |");
                System.out.println("|                                                                              |");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println(" =======> CHOICE: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        systemManager.addSavingPackage();
                        break;
                    case 2:
                        systemManager.updateSavingPackageById();
                        break;
                    case 3:
                        systemManager.updateSavingPackageByName();
                        break;
                    case 4:
                        systemManager.deleteSavingPackageById();
                        break;
                    case 5:
                        systemManager.deleteSavingPackageByName();
                        break;
                    case 6:
                        systemManager.displaySavingPackageById();
                        break;
                    case 7:
                        systemManager.displaySavingPackageByName();
                        break;
                    case 8:
                        systemManager.showAllSavingPackage();
                        break;
                }
            }catch (NumberFormatException e){
                System.err.println("The selection is not in the correct format, please choose again!");
            }
        }while (choice != 0);
    }
}
