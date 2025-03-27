// final class Card{
//     String kind;
//     int number;

//     Card(){
//         this("SPADE", 1);
//     }

//     Card(String kind, int number){
//         this.kind = kind;
//         this.number = number;
//     }

//     public String toString(){
//         return kind + ":" + number;
//     }
// }

// public class ClassEx1 {
//     public static void main(String[] args) throws Exception {
//         Card c = new Card("HEART", 3);
//         Card c2 = Card.class.newInstance();

//         Class cObj = c.getClass();

//         System.out.println(c);
//         System.out.println(c2);
//         System.out.println(cObj.getName());
//         System.out.println(cObj.toGenericString());
//         System.out.println(cObj.toString());
//     }
// }