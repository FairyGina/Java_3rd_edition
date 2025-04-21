// import java.text.*;

// class DecimalFormatEx2{
//     public static void main(String[] args) {
//         DecimalFormat df = new DecimalFormat("#,###.##");
//         DecimalFormat df2 = new DecimalFormat("#,###E0");

//         try{
//             Number num = df.parse("1,234,567.89");
//             System.out.println("1,234,567.89" + " -> ");

//             double d = num.doubleValue();
//             System.out.println("double : " + d);

//             System.out.println("String : " + df2.format(num));

//         } catch(Exception e) {
//         }

//     }
// }