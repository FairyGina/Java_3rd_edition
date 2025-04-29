import java.util.*;

class TreeSetEx2 {
    public static void main(String[] args) {
        TreeSet set= new TreeSet(); // TreeSet 생성
        int[] score = {87, 98, 75, 95, 80}; // 점수 배열

        for(int i=0;i<score.length;i++) {
            set.add(new Integer(score[i])); // 점수를 TreeSet에 저장
        }

        System.out.println("50보다 작은 값: "+set.headSet(new Integer(50))); // TreeSet에 저장된 점수를 출력
        System.out.println("50보다 큰 값: "+set.tailSet(new Integer(50))); // TreeSet에 저장된 점수를 출력

    }
}