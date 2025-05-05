// import java.util.*;

// class TreeMapEx1 {
//     public static void main(String[] args) {
//         String[] data = {"A","K","A","K","A","K","A","K","A","K","K","Z","D"};

//         TreeMap map = new TreeMap(); // TreeMap 생성

//         for(int i=0; i<data.length; i++) { // 데이터 배열을 순회하면서
//             if(map.containsKey(data[i])) { // 이미 존재하는 키이면
//                 Integer value = (Integer) map.get(data[i]); // 값 가져오기
//                 map.put(data[i], new Integer(value.intValue()+1)); // 값 증가
//             } else {
//                 map.put(data[i], new Integer(1)); // 새로운 키이면 1로 초기화
//             }
//         }

//         Iterator it = map.entrySet().iterator(); // TreeMap의 엔트리 세트 가져오기
//         System.out.println("= 기본정렬 =");

//         while(it.hasNext()) { // 다음 요소가 있으면
//             Map.Entry entry = (Map.Entry) it.next(); // 다음 요소 가져오기
//             int value = ((Integer) entry.getValue()).intValue(); // 값 가져오기
//             System.out.println(entry.getKey() + " : " + printBar('#',value)+" "+value); // 키와 값 출력
//         }
//         System.out.println();

//         Set set = map.entrySet(); // TreeMap의 엔트리 세트 가져오기
//         List list = new ArrayList(set); // 엔트리 세트를 리스트로 변환

//         Collections.sort(list, new ValueComparator()); // 값으로 정렬

//         it=list.iterator(); // 정렬된 리스트의 반복자 가져오기

//         System.out.println("= 값의 크기가 큰 순서로 정렬 =");

//         while(it.hasNext()) { // 다음 요소가 있으면
//             Map.Entry entry = (Map.Entry) it.next(); // 다음 요소 가져오기
//             int value = ((Integer) entry.getValue()).intValue(); // 값 가져오기
//             System.out.println(entry.getKey() + " : " + printBar('#',value)+" "+value); // 키와 값 출력
//         }

//     }

//     static class ValueComparator implements Comparator { // 값으로 정렬하는 비교자
//         public int compare(Object o1, Object o2) { // 비교 메서드
//             if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
//                 Map.Entry entry1 = (Map.Entry) o1; // o1을 Map.Entry로 변환
//                 Map.Entry entry2 = (Map.Entry) o2; // o1을 Map.Entry로 변환

//                 int v1 = ((Integer) entry1.getValue()).intValue(); // o1의 값 가져오기
//                 int v2 = ((Integer) entry2.getValue()).intValue(); // o2의 값 가져오기
                
//                 return v2-v1; // o1이 o2보다 크면 -1 반환
//             } 
//             return -1;
//         }
//     }

//     public static String printBar(char ch, int value) { // TreeMap 출력 메서드
//         char[] bar = new char[value]; // 바 차트 생성

//         for(int i=0;i<bar.length;i++) { // 바 차트 채우기
//             bar[i] = ch; // 문자로 채우기
//         }
//         return new String(bar); // 문자열로 변환하여 반환
//     }
// }
