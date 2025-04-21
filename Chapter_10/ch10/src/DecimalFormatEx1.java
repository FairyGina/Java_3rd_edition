
// import java.text.DecimalFormat;


// class DecimalFormatEx1 {
//     public static void main(String[] args) {
//         double number = 1234567.89;

//         String[] patterns = {
//             "0",
//             "#",
//             "0.0",
//             "#.#",
//             "0000000000000.0000",
//             "#############.####",
//             "#.#-",
//             "-#.#",
//             "#,###.##",
//             "#,####.##",
//             "#E0",
//             "0E0",
//             "##E0",
//             "00E0",
//             "####E0",
//             "0000E0",
//             "#.#E0",
//             "0.0E0",
//             "0.00000000000000E0",
//             "00.0000000000000E0",
//             "000.000000000000E0",
//             "#.##############E0",
//             "##.#############E0",
//             "###.############E0",
//             "#,###.##+;#,###.##-",
//             "#.#%",
//             "#.#\u2030",
//             "\u00A4 #,###",
//             "'#'#,###",
//             "''#,###",
//         };

//         for (int i=0; i<patterns.length; i++) {
//             DecimalFormat df = new DecimalFormat(patterns[i]);
//             System.out.printf("%19s : %s\n",patterns[i],df.format(number));
//         }
//     }
// }