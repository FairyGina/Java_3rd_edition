// import java.time.*;

// class NewTimeEx2 {
//     public static void main(String[] args) {
//         LocalDate date = LocalDate.of(2025, 1, 1);
//         LocalTime time = LocalTime.of(12, 34, 56);

//         LocalDateTime dt = LocalDateTime.of(date, time);

//         ZoneId zid = ZoneId.of("Asia/Seoul");
//         ZonedDateTime zdt = dt.atZone(zid);

//         ZonedDateTime seoulTime = ZonedDateTime.now();
//         ZoneId nyId = ZoneId.of("America/New_York");
//         ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(nyId);

//         OffsetDateTime odt = OffsetDateTime.now();

//         System.out.println(dt);
//         System.out.println(zid);
//         System.out.println(zdt);
//         System.out.println(seoulTime);
//         System.out.println(nyTime);
//         System.out.println(odt);

//     }    
// }
