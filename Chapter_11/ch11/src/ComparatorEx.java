// import java.util.*;

// class ComparatorEx {
//     public static void main(String[] args) {
//         String[] strArr = {"cat", "dog", "lion", "tiger"};

//         Arrays.sort(strArr);
//         System.out.println("strArr : " + Arrays.toString(strArr));

//         Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
//         System.out.println("strArr : " + Arrays.toString(strArr));

//         Arrays.sort(strArr, new Descending());
//         System.out.println("strArr : " + Arrays.toString(strArr));
//     }
// }

// class Descending implements Comparator {
//     public int compare(Object o1, Object o2) {
//         if (o1 instanceof String && o2 instanceof String) {
//             return ((String) o2).compareTo((String) o1);
//         } else {
//             return -1;
//         }
//     }
// }