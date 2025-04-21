class CalendarEx8{
    public static void main(String[] args) {
        String date1="202501";
        String date2="202403";

        int month1 = Integer.parseInt(date1.substring(0,4))*12 + Integer.parseInt(date1.substring(4));
        int month2 = Integer.parseInt(date2.substring(0,4))*12 + Integer.parseInt(date2.substring(4));

        System.out.println(date1 + "과 " + date2 + "의 차이는 " + Math.abs(month1-month2) + "개월입니다.");


    }
}