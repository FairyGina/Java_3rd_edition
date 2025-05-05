// import java.io.*;
// import java.util.*;

// class PropertiesEx2 {
//     public static void main(String[] args) {
//         if(args.length != 1) { // 인자가 없으면
//             System.out.println("Usage: java PropertiesEx2 fileName"); // 사용법 출력
//             System.exit(0); // 프로그램 종료
//         }

//         Properties prop = new Properties(); // Properties 객체 생성

//         String inputFile = args[0];

//         try{
//             prop.load(new FileInputStream(inputFile)); // 파일에서 속성 로드
//         } catch(IOException e) { // 예외 처리
//             System.out.println("File not found: " + inputFile); // 파일이 없으면 출력
//             System.exit(0); // 프로그램 종료
//         }

//         String name = prop.getProperty("name"); // name 속성 가져오기
//         String[] data = prop.getProperty("data").split(","); // data 속성 가져오기
//         int max=0, min=0, sum=0; // 최대값, 최소값, 합계 초기화

//         for(int i=0;i<data.length;i++) { // data 배열을 순회하면서
//             int value = Integer.parseInt(data[i]); // 문자열을 정수로 변환
//             if(i==0) { // 첫 번째 요소이면
//                 max = value; // 최대값 초기화
//                 min = value; // 최소값 초기화
//             } else {
//                 if(max < value) max = value; // 최대값 갱신
//                 if(min > value) min = value; // 최소값 갱신
//             }
//             sum += value; // 합계 계산
//         }

//         System.out.println("이름: " + name); // name 속성 출력
//         System.out.println("최대값: " + max); // 최대값 출력
//         System.out.println("최소값: " + min); // 최소값 출력
//         System.out.println("합계: " + sum); // 합계 출력
//         System.out.println("평균균: " + (sum/data.length)/100); // 평균 출력
//     }
// }
