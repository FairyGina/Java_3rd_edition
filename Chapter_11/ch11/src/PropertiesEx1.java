// import java.util.*;
// class PropertiesEx1 {
//     public static void main(String[] args) {
//         Properties prop = new Properties();

//         prop.setProperty("timeout", "30");
//         prop.setProperty("language", "kr");
//         prop.setProperty("size", "10");
//         prop.setProperty("capacity", "10");

//         Enumeration e = prop.propertyNames(); // 속성 이름을 가져옴

//         while (e.hasMoreElements()) { // 다음 요소가 있으면
//             String element = (String) e.nextElement(); // 다음 요소 가져오기
//             System.out.println(element + " : " + prop.getProperty(element)); // 속성 이름과 값 출력
//         }

//         System.out.println();
//         prop.setProperty("size= ", prop.getProperty("size")); // size 속성의 값을 20으로 설정
//         System.out.println("size= " + prop.getProperty("size")); // size 속성의 값 출력
//         System.out.println("capacity= " + prop.getProperty("capacity","20")); // size 속성의 값 출력
//         System.out.println("laodfactor= " + prop.getProperty("loadfactor","0.75")); // size 속성의 값 출력

//         System.out.println();
//         prop.list(System.out); // 속성 목록을 출력


//     }
// }
