// import java.util.*;

// class CalendarEx4{
//     public static void main(String[] args) {
//         Calendar date = Calendar.getInstance();
//         date.set(2025, 0, 1); // 2025년 1월 1일

//         System.out.println(toString(date));
//         System.out.println("= 1일 후 =");
//         date.add(Calendar.DATE, 1); // 1일 후
//         System.out.println(toString(date));

//         System.out.println("= 6달 전 =");
//         date.add(Calendar.MONTH, -6); // 6달 전
//         System.out.println(toString(date));

//         System.out.println("= 31일 후(roll) =");
//         date.roll(Calendar.DATE, 31); // 31일 후(roll)
//         System.out.println(toString(date));

//         System.out.println("= 31일 후(add) =");
//         date.add(Calendar.DATE, 31); // 31일 후(add)
//         System.out.println(toString(date));

//     }

//     public static String toString(Calendar date) {
//         return date.get(Calendar.YEAR) + "년" +
//                 (date.get(Calendar.MONTH) + 1) + "월" +
//                 date.get(Calendar.DATE) + "일";
//     }
// }