import java.util.*;
import static java.util.Collections.*;

class CollectionsEx {
    public static void main(String[] args) {
        List list = new ArrayList(); // ArrayList 객체 생성
        System.out.println();

        addAll(list, 1, 2, 3, 4, 5); // addAll 메소드 호출
        System.out.println(list); // list 출력

        rotate(list,2);
        System.out.println(list); // list 출력

        swap(list, 0, 1); // swap 메소드 호출
        System.out.println(list); // list 출력

        shuffle(list); // shuffle 메소드 호출
        System.out.println(list); // list 출력

        sort(list, reverseOrder()); // sort 메소드 호출
        System.out.println(list); // list 출력

        sort(list);
        System.out.println(list); // list 출력

        int idx = binarySearch(list, 3); // binarySearch 메소드 호출
        System.out.println("index of 3 = " + idx); // index 출력

        System.out.println("max = " + max(list)); // max 메소드 호출
        System.out.println("min = " + min(list)); // min 메소드 호출
        System.out.println("min= "+max(list, reverseOrder()));

        fill(list, 9); // fill 메소드 호출
        System.out.println("list="+list); // list 출력

        List newList = nCopies(3, 7); // nCopies 메소드 호출
        System.out.println("newList="+newList); // newList 출력

        System.out.println(disjoint(list,newList)); // list 출력

        copy(list, newList); // copy 메소드 호출
        System.out.println("list="+list); // list 출력
        System.out.println("newList="+newList); // newList 출력

        replaceAll(list, 2, 1); // replaceAll 메소드 호출
        System.out.println("list="+list); // list 출력

        Enumeration e = enumeration(list); // Enumeration 객체 생성
        ArrayList list2 = list(e);

        System.out.println("list2="+list2); // list2 출력

    }
}
