import java.util.*;

class HashSetEx4 {
    public static void main(String[] args) {
        HashSet set = new HashSet(); // HashSet 생성

        set.add("abc");
        set.add("abc"); // 중복된 객체 추가
        set.add(new Person2("David", 10)); // Person 객체 추가
        set.add(new Person2("David", 10)); // 중복된 Person 객체 추가

        System.out.println(set); // HashSet에 저장된 객체를 출력
    }        
}

class Person2{
    String name;
    int age;

    Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object obj) { // equals 메소드 재정의
        if (obj instanceof Person2) { // obj가 Person2 타입인지 확인
            Person2 p = (Person2)obj; // obj를 Person2 타입으로 변환
            return name.equals(p.name) && age == p.age; // name과 age가 같은지 비교
        }
        return false; // 같지 않으면 false 반환
    }

    public int hashCode() { // hashCode 메소드 재정의
        return name.hashCode() + age; // name의 해시코드와 age를 더한 값을 반환
    }

    public String toString() {
        return name + ":" + age; // Person 객체를 문자열로 변환
    }
}