// import java.util.StringJoiner;

// class StringEx5{
//     public static void main(String[] args)throws Exception{
//         String str="가";

//         byte[] bArr = str.getBytes("UTF-8"); // UTF-8로 인코딩
//         byte[] bArr2 = str.getBytes("CP949");

//         System.out.println("UTF-8: "+joinByteArr(bArr));
//         System.out.println("CP949: "+joinByteArr(bArr2));

//         System.out.println("UTF-8: "+new String(bArr, "UTF-8"));
//         System.out.println("CP949: "+new String(bArr2, "CP949"));

//     }

//     static String joinByteArr(byte[] bArr) {
//         StringJoiner sj = new StringJoiner(", ", "[", "]");

//         for (byte b : bArr) {
//             sj.add(String.format("%02X", b)); // 16진수로 변환
//         }

//         return sj.toString();
//     }
// }