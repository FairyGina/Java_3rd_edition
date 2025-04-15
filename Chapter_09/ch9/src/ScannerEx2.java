import java.io.File;
import java.util.Scanner;

class ScannerEx2{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("data2.txt"));
        int sum = 0;
        int cnt = 0;

        while(sc.hasNextLine()){
            sum+=sc.nextInt();
            cnt++;
        }

        System.out.println("sum = " + sum);
        System.out.println("average = " + (double)sum/cnt);
    }
}
