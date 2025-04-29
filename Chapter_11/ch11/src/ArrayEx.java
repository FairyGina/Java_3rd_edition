// import java.util.*;

// class ArrayEx {
//     public static void main(String[] args) {
//         int[] arr={0,1,2,3,4};
//         int[][] arr2D = {
//             {11,12,13},
//             {21,22,23}
//         };

//         System.out.println("arr="+Arrays.toString(arr));
//         System.out.println("arr2="+Arrays.deepToString(arr2D));

//         int[] arr2=Arrays.copyOf(arr, arr.length);
//         int[] arr3=Arrays.copyOf(arr, 3);
//         int[] arr4=Arrays.copyOf(arr, 7); // 길이 7로 복사
//         int[] arr5=Arrays.copyOfRange(arr, 2,4); 
//         int[] arr6=Arrays.copyOfRange(arr, 0,7);

//         System.out.println("arr2="+Arrays.toString(arr2));
//         System.out.println("arr3="+Arrays.toString(arr3));
//         System.out.println("arr4="+Arrays.toString(arr4));
//         System.out.println("arr5="+Arrays.toString(arr5));
//         System.out.println("arr6="+Arrays.toString(arr6));

//         int[] arr7=new int[5];
//         Arrays.fill(arr7, 9); // 9로 초기화
//         System.out.println("arr7="+Arrays.toString(arr7));

//         Arrays.setAll(arr7, i->(int)(Math.random()*6)+1); // 0~9 랜덤으로 초기화
//         System.out.println("arr7="+Arrays.toString(arr7));

//         for(int i:arr7){
//             char[] graph = new char[i]; // i만큼의 char 배열 생성
//             Arrays.fill(graph, '*'); // '*'로 초기화
//             System.out.println(new String(graph)+i); // char 배열을 String으로 변환하여 출력
//         }

//         String[][] str2D = {
//             {"aaa", "bbb", "ccc"},
//             {"AAA", "BBB", "CCC"}
//         };
//         String[][] str2D2 = {
//             {"aaa", "bbb", "ccc"},
//             {"AAA", "BBB", "CCC"}
//         };

//         System.out.println(Arrays.equals(str2D, str2D2)); // false
//         System.out.println(Arrays.deepEquals(str2D, str2D2)); // true

//         char[] chArr = {'A', 'B', 'C', 'D', 'E'};

//         System.out.println("str2D="+Arrays.toString(chArr));
//         System.out.println("index of B ="+Arrays.binarySearch(chArr, 'B')); // 1
//         System.out.println("= After sorting =");
//         Arrays.sort(chArr); // 정렬
//         System.out.println("chArr="+Arrays.toString(chArr));
//         System.out.println("index of B ="+Arrays.binarySearch(chArr, 'B')); // 1
//     }
// }
