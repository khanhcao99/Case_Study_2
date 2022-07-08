package Service;

import Model.LoanPackage;
import Model.SavingPackage;

public interface CRUD<E> {
    void add(E e);
    E getById(int id);
    E getByName(String name);
    void updateById(E e);
    void updateByName(E e);
    E deleteById(int id);
    E deleteByName(String name);
    E deleteByAll();
    void displayByid(int id);
    void displayByName(String name);
    void displayByLoanPackage(LoanPackage loanPackage);
    void displayBySavingPackage(SavingPackage savingPackage);
    void displayAll();
}
