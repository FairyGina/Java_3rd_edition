// import java.util.*;

// class HashSetEx3 {
//     public static void main(String[] args) {
//         HashSet set = new HashSet(); // HashSet 생성

//         set.add("abc");
//         set.add("abc"); // 중복된 객체 추가
//         set.add(new Person("David", 10)); // Person 객체 추가
//         set.add(new Person("David", 10)); // 중복된 Person 객체 추가

//         System.out.println(set); // HashSet에 저장된 객체를 출력
//     }
// }

// class Person{
//     String name;
//     int age;

//     Person(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }

//     public String toString() {
//         return name + ":" + age; // Person 객체를 문자열로 변환
//     }
// }