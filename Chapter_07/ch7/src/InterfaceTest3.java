// class InterfaceTest3 {
//     public static void main(String[] args) {
//         A a = new A();
//         a.methodA();
//     }
// }

// class A{
//     void methodA() {
//         I i = InstanceManager.getInstance();
//         i.methodB();
//         System.out.println(i.toString());
//     }
// }

// interface I{
//     public abstract void play();
// }

// class B implements I{
//     public void play() {
//         System.out.println("MethodB in B class");
//     }
//     public String toString() {
//         return "class B";
//     }
// }

// class InstanceManager{
//     public static I getInstance() {
//         return new B();
//     }
// }