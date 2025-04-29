import java.util.*;

class TreeSetLotto {
    public static void main(String[] args) {
        // TreeSet을 이용한 로또 번호 생성기
        Set set = new TreeSet(); // TreeSet 생성

        for (int i = 0; set.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1; // 1~45 사이의 랜덤 숫자 생성
            set.add(num); // 중복된 숫자는 자동으로 제거됨
        }

        System.out.println("로또 번호: " + set); // 로또 번호 출력
    }
}
