class OperatorEx2 {
    public static void main(String[] args) {
        int i = 5;
        int j = 0;

        j = i++;
        System.out.println("j=i++; 실행 후, i=" + i + ", j=" + j);

        i = 5; // 결과를 비교하기 위해 i값을 다시 5로 변경.
        j = 0;

        j = ++i;
        System.out.println("j=++i; 실행 후, i=" + i + ", j=" + j);
    }    
}
