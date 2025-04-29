import java.util.*;

class Bingo {
    public static void main(String[] args) {
        Set set = new HashSet(); // HashSet 생성
        int[][] board = new int[5][5];

        for(int i=0; set.size()<25; i++) {
            set.add((int)(Math.random()*50)+1+""); // HashSet에 저장
        }

        Iterator it=set.iterator(); // HashSet의 Iterator 생성

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                board[i][j] = Integer.parseInt((String)it.next()); // HashSet에서 꺼내서 2차원 배열에 저장
                System.out.print((board[i][j]<10?" ":" ")+board[i][j]); // 2차원 배열 출력
            }
            System.out.println(); // 줄바꿈
        }
    }
}