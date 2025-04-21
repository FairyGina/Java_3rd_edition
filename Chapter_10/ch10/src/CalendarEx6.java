// import java.util.*;

// class CalendarEx6{
//     public static void main(String[] args) {
//         if(args.length != 2) {
//             System.out.println("Usage: java Calendar Ex6 2025-01-01");
//             return;
//         }
//         int year = Integer.parseInt(args[0]);
//         int month = Integer.parseInt(args[1]);
//         int START_DAY_OF_WEEK = 0;
//         int END_DAY = 0;

//         Calendar sDay = Calendar.getInstance();
//         Calendar eDay = Calendar.getInstance();

//         sDay.set(year, month-1, 1); // 2025년 1월 1일
//         eDay.set(year, month, 1); // 2025년 2월 1일

//         eDay.add(Calendar.DATE, -1); // 2025년 2월 1일에서 하루를 빼면 2025년 1월 31일이 된다.
//         START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK); // 2025년 1월 1일의 요일

//         END_DAY = eDay.get(Calendar.DATE); // 2025년 1월의 마지막 날

//         System.out.println("         " + year + "년 " + month + "월");
//         System.out.println("SU MO TU WE TH FR SA");

//         for(int i=1; i<START_DAY_OF_WEEK; i++) {
//             System.out.print("   ");
//         }

//         for(int i=1, n = START_DAY_OF_WEEK; i<=END_DAY; i++,n++) {
//             System.out.print((i<10)? " " + i : i);
//             if(n%7==0) System.out.println();
//         }
//     }
// }