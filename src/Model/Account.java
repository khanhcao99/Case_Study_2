package Model;

import java.io.Serializable;

public class Account implements Serializable {
    private static int ID_ACCOUNT = 1;
    private int id;
    private String logIn;
    private String password;

    public Account() {

    }

    public Account(String logIn, String password) {
        this.id = ID_ACCOUNT++;
        this.logIn = logIn;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogIn() {
        return logIn;
    }

    public void setLogIn(String logIn) {
        this.logIn = logIn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account[" +
                "id=" + id +
                ", logIn='" + logIn + '\'' +
                ", password='" + password + '\'' +
                ']' + "\n";
    }
}
