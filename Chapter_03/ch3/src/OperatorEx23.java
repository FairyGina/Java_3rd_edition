class OperatorEx23 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("abc");

        System.out.printf("\"abc\"==\"abc\" ? %b%n", "abc" == "abc");
        System.out.printf(" str1==\"abc\" ? %b%n", str1 == "abc");
        System.out.printf(" str2==\"abc\" ? %b%n", str2 == "abc");
        System.out.printf("str1==str2 ? %b%n", str1 == str2);
        System.out.printf("str1.equals(str2) ? %b%n", str1.equals(str2));
        System.out.printf("str2.equals(\"abc\") ? %b%n", str2.equals("abc"));
        System.out.printf("\"abc\".equals(\"abc\") ? %b%n", "abc".equals("abc"));

    }
}
