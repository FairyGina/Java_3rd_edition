// import java.util.*;

// class HashMapEx2 {
//     public static void main(String[] args) {
//         HashMap map = new HashMap(); // HashMap 생성

//         map.put("김자바", new Integer(100)); // 키-값 쌍 추가
//         map.put("이자바", new Integer(100));
//         map.put("강자바", new Integer(80));
//         map.put("안자바", new Integer(90));

//         Set set = map.entrySet();
//         Iterator it = set.iterator(); // HashMap의 모든 키와 값을 출력하기 위한 Iterator 생성

//         while(it.hasNext()) {
//             Map.Entry e = (Map.Entry) it.next(); // 다음 키-값 쌍을 가져옴
//             System.out.println("이름: "+e.getKey() + ", 점수 : " + e.getValue()); // 키와 값 출력
//         }

//         set = map.keySet(); // HashMap의 모든 키를 가져옴
//         System.out.println("참가자 명단 : " + set); // HashMap의 모든 키 출력

//         Collection values = map.values(); // HashMap의 모든 값을 가져옴
//         it = values.iterator(); // HashMap의 모든 값을 출력하기 위한 Iterator 생성

//         int total=0; // 총 점수

//         while(it.hasNext()) {
//             Integer i = (Integer) it.next(); // 다음 값을 가져옴
//             total += i.intValue(); // 총 점수에 더함
//         }

//         System.out.println("총점 : " + total); // 총 점수 출력
//         System.out.println("평균 : " + (float)total/map.size()); // 평균 점수 출력
//         System.out.println("최고 점수 : " + Collections.max(values)); // 최고 점수 출력
//         System.out.println("최저 점수 : " + Collections.min(values)); // 최저 점수 출력
//     }
// }
