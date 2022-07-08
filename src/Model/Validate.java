package Model;

import javax.swing.text.MaskFormatter;
import java.awt.datatransfer.StringSelection;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private Pattern pattern;
    private Matcher matcher;
    private String REGEX_EMAIL = "[A-Za-z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)";
    private String REGEX_PHONE_NUMBER = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
    private String REGEX_PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
    private String REGEX_AGE = "^\\d{1}[^\\D]$";
    private String REGEX_CHOICE = "^\\d{1}[^\\D]$";;
    private String REGEX_LOGIN = "^[a-z0-9_-]{3,16}$";
    private String REGEX_BALANCE = "^[^0]\\d{4,8}$";
    private String REGEX_DAYOFBIRTH = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
    public Validate() {
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    public void setMatcher(Matcher matcher) {
        this.matcher = matcher;
    }

    public String getREGEX_EMAIL() {
        return REGEX_EMAIL;
    }

    public void setREGEX_EMAIL(String REGEX_EMAIL) {
        this.REGEX_EMAIL = REGEX_EMAIL;
    }

    public String getREGEX_PHONE_NUMBER() {
        return REGEX_PHONE_NUMBER;
    }

    public void setREGEX_PHONE_NUMBER(String REGEX_PHONE_NUMBER) {
        this.REGEX_PHONE_NUMBER = REGEX_PHONE_NUMBER;
    }

    public String getREGEX_PASSWORD() {
        return REGEX_PASSWORD;
    }

    public void setREGEX_PASSWORD(String REGEX_PASSWORD) {
        this.REGEX_PASSWORD = REGEX_PASSWORD;
    }

    public String getREGEX_AGE() {
        return REGEX_AGE;
    }

    public void setREGEX_AGE(String REGEX_AGE) {
        this.REGEX_AGE = REGEX_AGE;
    }

    public String getREGEX_CHOICE() {
        return REGEX_CHOICE;
    }

    public void setREGEX_CHOICE(String REGEX_CHOICE) {
        this.REGEX_CHOICE = REGEX_CHOICE;
    }

    public String getREGEX_LOGIN() {
        return REGEX_LOGIN;
    }

    public void setREGEX_LOGIN(String REGEX_LOGIN) {
        this.REGEX_LOGIN = REGEX_LOGIN;
    }

    public String getREGEX_BALANCE() {
        return REGEX_BALANCE;
    }

    public void setREGEX_BALANCE(String REGEX_BALANCE) {
        this.REGEX_BALANCE = REGEX_BALANCE;
    }

    public String getREGEX_DAYOFBIRTH() {
        return REGEX_DAYOFBIRTH;
    }

    public void setREGEX_DAYOFBIRTH(String REGEX_DAYOFBIRTH) {
        this.REGEX_DAYOFBIRTH = REGEX_DAYOFBIRTH;
    }

    public boolean validateEmail(String string){
        pattern = Pattern.compile(REGEX_EMAIL);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public boolean validatePhoneNumber(String string){
        pattern = Pattern.compile(REGEX_PHONE_NUMBER);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public boolean validatePassword(String string){
        pattern = Pattern.compile(REGEX_PASSWORD);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public boolean validateAge(String string){
        pattern = Pattern.compile(REGEX_AGE);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public boolean validateChoice(String string){
        pattern = Pattern.compile(REGEX_CHOICE);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public boolean validateLogin(String string){
        pattern = Pattern.compile(REGEX_LOGIN);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public boolean validateBalaned(String string){
        pattern = Pattern.compile(REGEX_BALANCE);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public boolean validateDayOfBirth(String string){
        pattern = Pattern.compile(REGEX_DAYOFBIRTH);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }


}
