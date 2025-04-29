import java.util.*;

class HashSetEx5 {
    public static void main(String[] args) {
        HashSet setA = new HashSet(); // HashSet 생성
        HashSet setB = new HashSet(); // HashSet 생성
        HashSet setHab = new HashSet(); // HashSet 생성
        HashSet setKyo = new HashSet(); // HashSet 생성
        HashSet setCha = new HashSet(); // HashSet 생성

        setA.add("1"); // HashSet에 객체 추가
        setA.add("2"); // HashSet에 객체 추가
        setA.add("4"); // HashSet에 객체 추가
        setA.add("5"); // HashSet에 객체 추가
        System.out.println("A = " + setA); // HashSet 출력

        setB.add("4"); // HashSet에 객체 추가
        setB.add("5"); // HashSet에 객체 추가
        setB.add("6"); // HashSet에 객체 추가
        setB.add("7"); // HashSet에 객체 추가
        setB.add("8"); // HashSet에 객체 추가
        System.out.println("B = " + setB); // HashSet 출력

        Iterator it = setB.iterator(); // HashSet의 Iterator 생성
        while(it.hasNext()) { // HashSet에 객체가 있는 동안 반복
            Object tmp = it.next(); // HashSet에서 객체 꺼내기
            if(setA.contains(tmp)) { // HashSet에 객체가 있는지 확인
                setKyo.add(tmp); // HashSet에 객체 추가
            }
        }

        it = setA.iterator(); // HashSet의 Iterator 생성
        while(it.hasNext()) { // HashSet에 객체가 있는 동안 반복
            Object tmp = it.next(); // HashSet에서 객체 꺼내기
            if(setB.contains(tmp)) { // HashSet에 객체가 있는지 확인
                setCha.add(tmp); // HashSet에 객체 추가
            }
        }

        it = setA.iterator(); // HashSet의 Iterator 생성
        while(it.hasNext()) { // HashSet에 객체가 있는 동안 반복
            setHab.add(it.next()); // HashSet에 객체 추가
        }
        it = setB.iterator(); // HashSet의 Iterator 생성
        while(it.hasNext()) { // HashSet에 객체가 있는 동안 반복
            setHab.add(it.next()); // HashSet에 객체 추가
        }

        System.out.println("A - B = " + setCha); // HashSet 출력
        System.out.println("A ∪ B = " + setHab); // HashSet 출력
        System.out.println("A ∩ B = " + setKyo); // HashSet 출력
        
    }    
}
