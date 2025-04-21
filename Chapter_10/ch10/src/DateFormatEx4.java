// import java.text.*;
// import java.util.*;

// class DateFormatEx4{
//     public static void main(String[] args) {
//         String pattern = "yyyy/MM/dd";
//         DateFormat df = new SimpleDateFormat(pattern);
//         Scanner s = new Scanner(System.in);

//         Date inDate = null;

//         System.out.print("날짜를 " + pattern + "의 형태로 입력해주세요. (입력 예: 2025/01/01) : ");

//         while(s.hasNextLine()) {
//              try {
//                 inDate = df.parse(s.nextLine());
//                 break;
//             } catch (ParseException e) {
//                 System.out.println("날짜를 " + pattern + "의 형태로 다시 입력해주세요. (입력 예: 2025/01/01) : ");
//             }
//         }

//         Calendar cal = Calendar.getInstance();
//         cal.setTime(inDate); // 입력받은 날짜를 Calendar에 설정
//         Calendar today = Calendar.getInstance(); // 오늘 날짜
//         long day = (cal.getTimeInMillis() - today.getTimeInMillis()) / (60*60*1000);
//         System.out.println("입력한 날짜는 현재와 " + day + "시간 차이가 있습니다.");

//     }
// }