// class A{
//     void autoPlay(I i) {
//         i.play();
//     }
// }

// interface I{
//     void play();
// }

// class B implements I{
//     public void play() {
//         System.out.println("play in B class");
//     }
// }

// class C implements I{
//     public void play() {
//         System.out.println("play in C class");
//     }
// }

// class InterfaceTest2 {
//     public static void main(String[] args) {
//         A a = new A();
//         a.autoPlay(new B());
//         a.autoPlay(new C());
//     }
// }