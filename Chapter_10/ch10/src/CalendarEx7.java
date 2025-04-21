// import java.util.*;

// class CAlendarEx7{
//     public static void main(String[] args) {
//         if(args.length != 2) {
//             System.out.println("Usage: java Calendar Ex7 2025-01-01");
//             return;
//         }
//         int year = Integer.parseInt(args[0]);
//         int month = Integer.parseInt(args[1]);

//         Calendar sDay = Calendar.getInstance();
//         Calendar eDay = Calendar.getInstance();

//         sDay.set(year, month-1, 1); // 2025년 1월 1일
//         eDay.set(year, month-1, sDay.getActualMaximum(Calendar.DATE)); // 2025년 2월 1일

//         sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK)+1);
//         eDay.add(Calendar.DATE, 7-eDay.get(Calendar.DAY_OF_WEEK));

//         System.out.println("         " + year + "년 " + month + "월");
//         System.out.println("SU MO TU WE TH FR SA");

//         for(int n=1; sDay.before(eDay) || sDay.equals(eDay); sDay.add(Calendar.DATE, 1)) {
//             int i = sDay.get(Calendar.DATE);
//             System.out.print((i<10)? " " + i : i);
//             if(n++%7==0) System.out.println();
//         }

//     }
// }