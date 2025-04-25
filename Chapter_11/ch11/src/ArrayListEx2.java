// import java.util.*;

// class ArrayListEx2 {
//     public static void main(String[] args) {
//         final int LIMIT = 10;
//         String source = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//         int length = source.length();

//         List list = new ArrayList(length/LIMIT + 10);

//         for (int i = 0; i < length; i++) {
//             if(i+LIMIT < length) {
//                 list.add(source.substring(i, i + LIMIT));
//             } else {
//                 list.add(source.substring(i, length));
//             }
//         }

//         for(int i=0;i < list.size(); i++) {
//             System.out.println(list.get(i));
//         }

//     }    
// }
