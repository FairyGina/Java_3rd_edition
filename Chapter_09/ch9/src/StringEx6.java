class StringEx6{
    public static void main(String[] args) {
        int iVal = 100;
        String strVal = String.valueOf(iVal); // int -> String 변환

        Double dVal = 200.0; // double -> Double 변환
        String strVal2 = dVal + "";

        double sum = Integer.parseInt(strVal) + Double.parseDouble(strVal2); // String -> int, double 변환

        double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2); // String -> Integer, Double 변환

        System.out.println(String.join("", strVal, "+", strVal2, "=")+sum); // String -> String 변환
        System.out.println(String.join("", strVal, "+", strVal2, "=")+sum2); // String -> String 변환

    }
}