class FlowEx15 {
    public static void main(String[] args) {
        System.out.println("i \t j \t i+j \t i-j \t i*j \t i/j");
        System.out.println("-------------------------------------------------");

        for(int i = 1, j = 10; i <= 10; i++, j--) {
            System.out.printf("%d \t %d \t %d \t %d \t %d \t %d%n", i, j, i+j, i-j, i*j, i/j);
        }
    }
}
