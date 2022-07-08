import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

public class DEMO {
    public static void main(String[] args) {
//        Locale locale = new Locale("vi", "VN");
//        int vnd = 100000000;
//        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
//        String cd = numberFormat.format(vnd);
//        System.out.println(cd);
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        localDate.getDayOfYear();
        System.out.println(localDate);
        System.out.println(localTime);
    }
}
