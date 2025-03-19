// class InnerEx3{
//     private int outerIv = 0;
//     static int outerCv = 0;

//     class InstanceInner{
//         int iiv = outerIv;
//         int iiv2 = outerCv;
//     }

//     static class StaticInner{
//         // static 클래스는 외부 클래스의 인스턴스 멤버에 접근할 수 없다.
//         // int siv = outerIv;
//         static int scv = outerCv;
//     }

//     void myMethod(){
//         int lv = 0;
//         final int LV = 0;

//         class LocalInner{
//             int liv = outerIv;
//             int liv2 = outerCv;
//             // 외부 클래스의 지역변수는 final이 붙은 변수(상수)만 접근 가능하다.
//             int liv3 = lv;
//             int liv4 = LV;
//         }
//     }
// }