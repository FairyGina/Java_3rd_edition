class ArrayEx17 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("USAGE: java ArrayEx17 NUM1 OP NUM2");
            System.exit(0);
        }

        int num = Integer.parseInt(args[0]);
        char op = args[0].charAt(0);
        int num2 = Integer.parseInt(args[2]);
        int result = 0;

        switch (op) {
            case '+':
                result = num + num2;
                break;
            case '-':
                result = num - num2;
                break;
            case 'x':
                result = num * num2;
                break;
            case '/':
                result = num / num2;
                break;
            default:
                System.out.println("지원하지 않는 연산입니다.");
        }
        System.out.println("결과: " + result);
    }
}
