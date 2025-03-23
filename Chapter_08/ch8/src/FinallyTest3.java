// class FinallyTest3{
//     public static void main(String[] args){
//         FinallyTest3.method1();
//         System.out.println("method1()의 수행을 마치고 main메서드로 돌아왔습니다.");
//     }

//     static void method1(){
//         try{
//             System.out.println("method1()이 호출되었습니다.");
//             return;
//         } catch (Exception e){
//             e.printStackTrace();
//         } finally{
//             System.out.println("method1()의 finally 블럭이 실행되었습니다.");
//         }
//     }
// }