import java.text.*;
import java.util.*;

class DateFormatEx3{
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
        DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

        try{
            Date d = df.parse("2025년 01월 01일");
            System.out.println(df2.format(d));

        } catch(Exception e) {
        }

    }
}