// import java.io.*;
// import java.text.*;
// import java.util.*;

// class MessageFormatEx4 {
//     public static void main(String[] args)throws Exception {
//         String tableName = "CUST_INFO";
//         String filename = "data4.txt";
//         String msg = "INSERT INTO " + tableName + " VALUES ({0},{1}, {2},{3});";

//         Scanner s=new Scanner(new File(filename));

//         String pattern = "{0},{1},{2},{3}";
//         MessageFormat mf = new MessageFormat(pattern);

//         while(s.hasNextLine()){
//             String line = s.nextLine();
//             Object[] objs = mf.parse(line);
//             System.out.println(MessageFormat.format(msg, objs));
//         }

//         s.close();
//     }    
// }
