import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    private static String OS = null;

    public static String getOS() {
        if (OS == null) {
            OS = System.getProperty("os.name");
        }
        return OS;
    }
    public static void getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
    }
}