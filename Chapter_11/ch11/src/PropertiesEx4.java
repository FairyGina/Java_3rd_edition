import java.util.*;
class PropertiesEx4 {
    public static void main(String[] args) {
        Properties sysProp = new Properties(); // Properties 객체 생성

        System.out.println("java.version: "+sysProp.getProperty("java version")); // Properties 객체 생성 출력
        System.out.println("user.language "+sysProp.getProperty("user.language")); // Properties 객체 생성 출력

        sysProp.list(System.out); // Properties 객체 생성 출력
    }
}
