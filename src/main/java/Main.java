import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {



        SimpleDateFormat dateFormat = new SimpleDateFormat("d.MM.yyyy");
        Calendar calendar = new GregorianCalendar(2023, 11, 30);
        calendar.add(Calendar.DAY_OF_YEAR, +3);

        System.out.println(dateFormat.format(calendar.getTime()));




    }




}
