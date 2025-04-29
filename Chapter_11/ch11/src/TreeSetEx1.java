import java.util.*;

class TreeSetEx1 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet(); // TreeSet 생성

        String from="b";
        String to="d"; // 범위 설정

        set.add("abc");
        set.add("bcd");
        set.add("aaa");
        set.add("bde");
        set.add("ccc");
        set.add("ddd");
        set.add("bbb");
        set.add("cde");
        set.add("cba");
        set.add("aaa"); // 중복된 객체 추가

        set.add("abc"); // 중복된 객체 추가
        set.add("abc"); // 중복된 객체 추가

        System.out.println(set);
        System.out.println("range search: from"+from+" to "+to); // 범위에 해당하는 부분집합 출력
        System.out.println("result1: "+set.subSet(from, to)); // from부터 to까지의 부분집합 출력
        System.out.println("result1: "+set.subSet(from, to+"zzz")); // from부터 to까지의 부분집합 출력

    }   
}
