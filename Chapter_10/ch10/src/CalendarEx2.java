// import java.util.*;

// class CalendarEx2{
//     public static void main(String[] args) {
//         final String[] DAY_OF_WEEK = {"일", "월", "화", "수", "목", "금", "토"};

//         Calendar date1 = Calendar.getInstance();
//         Calendar date2 = Calendar.getInstance();

//         date1.set(2025, 0, 1); // 2025년 1월 1일
//         System.out.println("date1은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일이고,");
//         System.out.println("date2은 " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일입니다.");

//         long defference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
//         System.out.println("그날(date1)부터 지금(date2)까지 " + defference + "초가 지났습니다.");
//         System.out.println("일(day)로 계산하면" + defference /(24*60*60) + " 일입니다.");
        
//     }
//     public static String toString(Calendar date) {
//         return date.get(Calendar.YEAR) + "년" +
//                 (date.get(Calendar.MONTH) + 1) + "월" +
//                 date.get(Calendar.DATE) + "일";
//     }
    
// }