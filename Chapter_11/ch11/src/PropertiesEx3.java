import java.io.*;
import java.util.*;

class PropertiesEx3 {
    public static void main(String[] args) {
        Properties prop = new Properties(); // Properties 객체 생성

        prop.setProperty("timeout", "30");
        prop.setProperty("language", "한글");
        prop.setProperty("size", "10");
        prop.setProperty("capacity", "10");

        try {
            prop.store(new FileOutputStream("output.txt"), "Properties Example"); // 속성을 파일에 저장
            prop.storeToXML(new FileOutputStream("output.xml"), "Properties Example");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
