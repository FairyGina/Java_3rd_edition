// import java.util.*;

// class HashMapEx4 {
//     public static void main(String[] args) {
//         String[] data = {"A","K","A","K","A","K","A","K","A","K","K","Z","D"};

//         HashMap map = new HashMap(); // HashMap 생성

//         for(int i=0; i<data.length; i++) { // 데이터 배열을 순회하면서
//             if(map.containsKey(data[i])) { // 이미 존재하는 키이면
//                 Integer value = (Integer) map.get(data[i]); // 값 가져오기
//                 map.put(data[i], new Integer(value.intValue()+1)); // 값 증가
//             } else {
//                 map.put(data[i], new Integer(1)); // 새로운 키이면 1로 초기화
//             }
//         }

//         Iterator it = map.entrySet().iterator(); // HashMap의 엔트리 세트 가져오기

//         while(it.hasNext()) { // 다음 요소가 있으면
//             Map.Entry entry = (Map.Entry) it.next(); // 다음 요소 가져오기
//             int value = ((Integer) entry.getValue()).intValue(); // 값 가져오기
//             System.out.println(entry.getKey() + " : " + printBar('#',value)+" "+value); // 키와 값 출력
//         }
//     }

//     public static String printBar(char ch, int value) { // HashMap 출력 메서드
//         char[] bar = new char[value];

//         for(int i=0;i<bar.length;i++) { // 바 차트 생성
//             bar[i] = ch; // 문자로 채우기
//         }
//         return new String(bar); // 문자열로 변환하여 반환
//     }

// }
