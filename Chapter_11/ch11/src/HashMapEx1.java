import java.util.*;

class HashMapEx1 {
    public static void main(String[] args) {
        HashMap map = new HashMap(); // HashMap 생성
        map.put("myId", "1234"); // 키-값 쌍 추가
        map.put("yourId", "1111"); // 또 다른 키-값 쌍 추가
        map.put("asdf", "1234"); // 기존 키의 값을 변경

        Scanner s = new Scanner(System.in); // Scanner 생성

        while(true){
            System.out.print("id와 password를 입력하세요: "); // 사용자에게 입력 요청
            System.out.print("id: "); // 아이디 입력 요청
            String id = s.nextLine().trim(); // 아이디 입력

            System.out.print("password: "); // 입력된 아이디 출력
            String password = s.nextLine().trim(); // 아이디 입력
            System.out.println();

            if(!map.containsKey(id)) { // 아이디가 존재하지 않으면
                System.out.println("입력하신 아이디는 존재하지 않습니다."+"다시 입력해주세요.");
                continue; // 다음 반복으로 이동
            }
            if(!(map.get(id)).equals(password)) { // 비밀번호가 일치하지 않으면
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
            } else { // 아이디와 비밀번호가 모두 일치하면
                System.out.println("id와 비밀번호가 일치합니다.");
                break; // 반복 종료
            }
        }
    }
}
