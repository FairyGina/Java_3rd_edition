import java.text.*;
import java.util.*;

class DateFormatEx2{
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2025, 0, 1); // 2025년 1월 1일

        Date day = cal.getTime(); 

        SimpleDateFormat sdf1, sdf2, sdf3, sdf4;

        sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        sdf2 = new SimpleDateFormat("yy년 MMM dd일 E요일");
        sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        sdf4 = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");


        System.out.println("sdf1 : " + sdf1.format(day));
        System.out.println("sdf2 : " + sdf2.format(day));
        System.out.println("sdf3 : " + sdf3.format(day));
        System.out.println("sdf4 : " + sdf4.format(day));


    }
}