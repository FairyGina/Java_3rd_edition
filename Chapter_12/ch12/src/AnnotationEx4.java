// import java.util.Arrays;

// class MyArrayList<T> {
//     T[] arr;

//     @SafeVarargs
//     @SuppressWarnings("varargs")
//     MyArrayList(T... arr) {
//         this.arr = arr;
//     }

//     @SafeVarargs
//     //@SuppressWarnings("unchecked")
//     public static <T> void MyArrayList<T> asList(T... a) {
//         return new MyArrayList<>(a);
//     }
//     public String toString() {
//         return Arrays.toString(arr);
//     }
// }

// class AnnotationEx4{
//     // @SuppressWarnings("unchecked")
//     public static void main(String args[]){
//         MyArrayList<String> list = new MyArrayList.asList("1", "2", "3");

//         System.out.println(list);
//         // MyArrayList<String> list2 = new MyArrayList<>("A", "B", "C");
//         // System.out.println(list2);
//     }
// }