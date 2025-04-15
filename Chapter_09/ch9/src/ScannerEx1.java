// import java.util.*;

// class ScannerEx1{
//     public static void main(String[] args) {
//         Scanner s = new Scanner(System.in);
//         String[] argArr = null;

//         while(true){
//             String prompt = ">> ";
//             System.out.print(prompt);

//             String input = s.nextLine();

//             input = input.trim(); // 공백 제거
//             argArr = input.split(" +");

//             String command = argArr[0].trim();

//             if("".equals(command)) continue;

//             command = command.toLowerCase(); // 대문자 -> 소문자 변환

//             if(command.equals("q")){
//                 System.exit(0);
//             } else{
//                 for(int i=0;i<argArr.length;i++){
//                     System.out.print(argArr[i]);
//                 }
//             }

//         }
        
//     }
// }