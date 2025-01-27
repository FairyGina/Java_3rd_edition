import java.util.*;

class FlowEx7 {
    public static void main(String[] args) {
        int user = 0;
        int computer = 0;

        System.out.print("가위(1), 바위(2), 보(3) 중 하나를 입력하세요.>");

        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        user = Integer.parseInt(tmp);

        computer = (int)(Math.random() * 3) + 1;

        System.out.println("당신은 " + user + "입니다.");
        System.out.println("컴퓨터는 " + computer + "입니다.");

        switch(user - computer) {
            case 2: case -1:
                System.out.println("당신이 졌습니다.");
                break;
            case 1: case -2:
                System.out.println("당신이 이겼습니다.");
                break;
            case 0:
                System.out.println("비겼습니다.");
                break;
        }
    }
}
