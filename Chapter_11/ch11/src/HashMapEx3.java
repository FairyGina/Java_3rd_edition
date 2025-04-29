import java.util.*;

class HashMapEx3 {
    static HashMap phoneBook = new HashMap(); // HashMap 생성
    public static void main(String[] args) {
        addPhoneNo("친구", "이자바", "010-111-1111"); // 친구의 전화번호 추가
        addPhoneNo("친구", "김자바", "010-222-2222"); // 친구의 전화번호 추가
        addPhoneNo("친구", "김자바", "010-333-3333"); // 친구의 전화번호 추가
        addPhoneNo("회사", "김대리", "010-444-4444"); // 가족의 전화번호 추가
        addPhoneNo("회사", "김대리", "010-555-5555"); // 가족의 전화번호 추가
        addPhoneNo("회사", "박대리", "010-666-6666"); // 가족의 전화번호 추가
        addPhoneNo("회사", "이과정", "010-777-7777"); // 가족의 전화번호 추가
        addPhoneNo("세탁", "010-666-6666"); // 가족의 전화번호 추가

        printList();
        

    }
    static void addPhoneNo(String groupName, String name, String tel) {
        addGroup(groupName);
        HashMap group = (HashMap) phoneBook.get(groupName); // 그룹의 전화번호부 가져오기
        group.put(tel, name); // 전화번호 추가
    }
    static void addGroup(String groupName) {
        if(!phoneBook.containsKey(groupName)) { // 그룹이 존재하지 않으면
            phoneBook.put(groupName, new HashMap()); // 새로운 그룹 생성
        }
    }
    static void addPhoneNo(String name, String tel) {
        addPhoneNo("기타", name, tel); // 그룹 추가
    }
    static void printList() {
        Set set = phoneBook.entrySet(); // HashMap의 엔트리 세트 가져오기
        Iterator it = set.iterator(); // Iterator 생성

        while(it.hasNext()) { // 다음 요소가 있으면
            Map.Entry e = (Map.Entry) it.next(); // 다음 요소 가져오기

            Set subSet = ((HashMap) e.getValue()).entrySet(); // 그룹의 전화번호부에서 키 세트 가져오기
            Iterator subIt = subSet.iterator(); // Iterator 생성

            System.out.println(" * "+e.getKey() + " [" + subSet.size()+"]"); // 그룹 이름 출력

            while(subIt.hasNext()) { // 다음 요소가 있으면
                Map.Entry subE = (Map.Entry) subIt.next(); // 다음 요소 가져오기
                String telNo = (String) subE.getKey(); // 이름 가져오기
                String name = (String) subE.getValue(); // 전화번호 가져오기
                System.out.println(name + " " + telNo); // 이름과 전화번호 출력
            }
            System.out.println();
        }
    }
}
