# ch9 java.lang 패키지와 유용한 클래스

## 1.java.lang 패키지

- java.lang 패키지는 자바 프로그래밍에서 가장 기본이 되는 클래스들을 포함해 import문 없이도 사용 가능

### 1.1. Object 클래스

- Object 클래스는 모든 클래스의 최고 조상으로, Object클래스의 멤버들은 모든 클래스에서 바로 사용 가능

|Object클래스의 메서드|설명|
|---|---|
|protected Object clone()|객체 자신의 복사본 반환|
|public boolean equals{Object obj}|객체 자신과 객체 obj가 같은 객체인지 알려줌(같으면 true)|
|protected void finalize()|객체가 소멸될 때 가비지 컬렉터에 의해 자동적으로 호출되며 이 때 수행되어야할 코드가 있을 때 오버라이딩(거의 사용 안함)|
|public Class getClass()|객체 자신의 클래스 정보를 담고 있는 Class인스턴스를 반환|
|public int hashCode()|객체 자신의 해쉬코드 반환|
|public String toString()|객체 자신의 정보를 문자열로 반환|
|public void notify()|객체 자신을 사용하려고 기다리는 쓰레드 하나만 깨움|
|public void notifyAll()|객체 자신을 사용하려고 기다리는 모든 쓰레드를 깨움|
|Public void wait() / Public void wait (long timeout) / public void wait(long timeout, int nanos)|타 쓰레드가 notifyAll()을 호출할 때까지 현재 쓰레드를 무한히 또는 지정된 시간(timeout, nanos)동안 기다리게 함(timeout은 천 분의 1초, nonos는 10e9분의 1초)|

- Object클래스는 멤버변수는 없고 오직 11개의 메서드만 가지고 있으며, 이 메서드들은 모든 인스턴스가 가져야할 기본적인 것들임

#### equals(Object obj)

- 매개변수로 객체의 참조변수를 받아 비교해 그 결과를 boolean값으로 알려주는 역할
- public boolean equals(Object obj){ return (this==obj) }
- 두 객체의 같고 다름을 참조변수 값으로 판단하며 서로 다른 두 객체를 equals메서드로 비교하면 항상 false를 결과로 얻게 됨
*객체 생성 시, 메모리의 비어있는 공간을 찾아 생성하므로 서로 다른 두 개의 객체가 같은 주소를 갖는 일은 있을 수가 없음. 두 개 이상의 참조변수가 같은 주소값을 갖는 것(한 객체를 참조하는 것)은 가능*
- Object클래스로부터 상속받은 equals메서드는 결국 두 개의 참조변수가 같은 객체를 참조하고 있는지, 두 참조변수에 저장된 값(주솟값)이 같은지를 판단하는 기능인데, equals메서드로 Value인스턴스가 가지고 있는 value값을 비교하도록 하려면 Value클래스에서 equals메섣르르 오버라이딩해 주소가 아닌 객체에 저장된 내용을 비교하도록 변경
- String 클래스도 Object클래스의 equals메서드를 그대로 사용하는 것이 아닌, 오버라이딩을 통해 String인스턴스가 갖는 문자열 값을 비교하도록 되어있어 같은 내용의 문자열을 갖는 두 String인스턴스에 equals메서드를 사용하면 항상 true값을 얻음
String, Data, File, wrapper클래스(Integer, Double 등)의 equals메서드도 주소값이 아닌 내용을 비교하도록 오버라이딩되어있으며, StringBuffer클래스는 오버라이딩이 되어있지 않음

#### hashCode()

- 해싱(hashing)기법에 사용되는 해쉬함수(hash function) 구현한 것
- 해싱은 데이터 관리 기법중 하나로 다량의 데이터를 저장하고 검색하는데 유용
- 해시함수는 찾고자 하는 값을 입력하면, 그 값이 저장된 위치를 알려주는 해쉬코드를 반환
- 일반적으로 해시코드가 같은 두 객체가 존재하는 것이 가능하다, Object클래스에 정의된 hashCode메서드는 객체의 주소값으로 해시코드로 만들어 반환하기 때문에 32 bit JVM에서는 서로 다른 두 객체는 결코 같은 해시코드를 가질 수 없지만, 64bit JVM에서는 8 byte 주소값으로 해시코드(4 byte)를 만들기 때문에 해시코드가 중복될 수 있음
- 클래스의 인스턴스변수 값으로 객체의 같고 다름을 판단해야하는 경우라면 equals 메서드뿐만 아니라 hashCode메서드도 적절히 오버라이딩해야함
- 같은 객체라면 hashCode메서드 호출 시 결과값인 해시코드도 같아야하기 때문
*해싱 기법을 사용하는 HashMap이나 HashSet과 같은 클래스에 저장할 객체라면 반드시 hashCode메서드를 오버라이딩 해야함*
- String클래스는 문자열의 내용이 같으면 동일한 해쉬코드를 반환하도록 hashCode메서드가 오버라이딩되어있어, 문자열의 내용이 같은 두 변수에 대해 hashCode()를 호출 시 항상 동일한 해시코드값을 얻음
- System.identityHashCode(Object x)는 Object클래스의 hashCode메서드처럼 객체의 주소값으로 해시코드를 생성하기에 모든 객체에 대해 항상 다른 해시코드값을 반환한 것을 보장해 해시코드는 같지만 서로 다른 객체임을 알 수 있음
*System.identityHashCode(Object x)의 호출결과는 실행할 때마다 달라질 수 있음*

#### toString()

- 이 메서드는 인스턴스에 대한 정보를 문자열(String)로 제공할 목적으로 정의한 것
- 인스턴스의 정보를 제공한다는 것은 대부분의 경우 인스턴스 변수에 저장된 값들을 문자열로 표현한다는 것
- public String toString(){ return getClass().getName()+"@"+Integer.toHexString(hashCode()); }
- 클래스 작성 시 toString()을 오버라이딩하지 않는다면, 이 내용이 사용되며 호출 시 클래스 이름에 16진수의 해시코드를 얻게 됨
*getClass()와 hashCode() 역시 Object클래스에 정의된 것으로 인스턴스 생성 없이 바로 호출 가능*
- 서로 다른 인스턴스에 대해 toString()을 호출했으므로 클래스 이름은 같아도 해쉬코드값이 다르다는 것 확인 가능
- toString()은 일반적으로 인스턴스나 클래스에 대한 정보 또는 인스턴스 변수들의 값을 문자열로 변환해 반환하도록 오버라이딩되는 것이 일반적
- 조상에 정의된 메서드를 자손에서 오버라이딩 시 조상에 정의된 접근 범위보다 같거나 더 넓어야함

#### clone()

- 자신을 복제하여 새로온 인스턴스를 생성하는 일
- 어떤 인스턴스에 대해 작업 시, 원래의 인스턴스는 보존하고 clone메서드를 이용해 새로운 인스턴스를 생성해 작업을 하면 작업 이전의 값이 보존되므로 작업에 실패해 원래의 상태로 되돌리거나 변경되기 전 값을 참고하는데 도움
- Object클래스에 정의된 clone()은 단순히 인스턴스 변수의 값만 복사하기에, 참조 타입의 인스턴스 변수가 있는 클래스는 완전한 인스턴스 복제가 이뤄지지 않음
- 배열은 복제된 인스턴스도 같은 배열의 주소를 가져 복제된 인스턴스의 작업이 원래의 인스턴스애 영향을 미치므로, clone메서드를 오버라이딩해 새로운 배열을 생성하고 배열의 내용을 복사하도록 함
- Cloneable 인터페이스를 구현한 클래스의 인스턴스만 clone()을 통해 복제가 가능한 이유는 인스턴스의 데이터를 보호할 목적
- Cloneable인터페이스가 구현되어있다는 것: 클래스 작성자가 복제를 허용

#### 공변 반환 타입

- 이 기능은 오버라이딩할 때 조상 메서드의 반환타입을 자손 클래스의 타입으로 변경을 허용하는 것
- 조상의 타입이 아닌, 실제로 반환되는 자손 객체의 타입으로 반환할 수 있어 번거로운 형변환이 줄어드는 장점 존재
- 일반적으로 배열을 복사할 때, 같은 길이의 새로운 배열을 생성한 다음에 System.arraycopy()를 이용해 내용을 복사하지만, 간단하게 clone()을 이용해 복사 가능
- 배열 뿐만 아니라 java.util패키지의 Vector, ArrayList, LincedList, HashSet, TreeSet, HashMap, TreeMap, Calender, Date와 같은 클래스들이 이와 같은 방식으로 복제 가능
clone()으로 복제가 가능한 클래스인지 확인하려면 java API에서 Cloneable을 구현하였는지 확인하면 되며 src.zip의 압축 풀고 예제를 이용해 Cloneable을 구현한 클래스의 목록 생성 가능

#### 앝은 복사와 깊은 복사

- clone()은 단순히 객체에 저장된 값을 그대로 복제할 뿐, 객체가 참조하고 있는 객체까지 복제하지 않음
- 객체 배열을 clone()으로 복제하는 경우에는 원본과 복제본이 같은 객체를 공유하므로 완전한 복제라고 보기 어려움
=> 얕은 복사(shallow copy)로 원본을 변경하면 복사본도 영향을 받음
=> 깊은 복사(deep copy)는 원본이 참조하고 있는 객체까지 복제하는 것

#### getClass()

- 이 메서드는 자신이 속한 클래스의 Class객체를 반환하는 메서드
- Class객체는 이름이 'Class'인 클래스의 객체
- public final class Class implements...{   }
- Class객체는 클래스의 모든 정보를 담고 있으며, 클래스 당 1개만 존재
- 클래스 파일이 클래스 로더(ClassLoader)에 의해 메모리에 올라갈 때 자동으로 생성
- 클래스 로더: 실행 시에 필요한 클래스를 동적으로 메모리에 로드하는 역할
- 기존 생성된 클래스 객체가 메모리에 존재하는지 확인하고, 있으면 객체의 참조를 반환하고 없으면 클래스 패스(classpath)에 지정된 경로를 따라 클래스 파일을 찾음
- 못 찾으면 ClassNotFoundException이 발생하고, 찾으면 해당 클래스 파일을 읽어 Class객체로 변환
- 클래스 객체: 파일 형태로 저장되어 있는 클래스를 읽어서 Class클래스에 정의된 형식으로 변환하는 것으로 클래스 파일을 읽어 사용하기 편한 형태로 저장해 놓은 것

#### Class 객체를 얻는 방법

- 클래스 정보가 필요할 때 Class객체에 대한 참조를 얻어와야하는데, 해당 Class 객체에 대한 참조를 얻는 방법

Class cObj=new Card().getClass(); //생성된 객체로부터 얻는 방법
Class cObj=Card.class; // 클래스 리터럴(*.class)로부터 얻는 방법
Class cObj=Class.forName("Card"); // 클래스 이름으로부터 얻는 방법

- forName()은 특정 클래스 파일로 DB 드라이버를 메모리에 올릴 떼 주로 사용
- Class객체를 이용하면 클래스에 정의된 멤버의 이름이나 개수 등, 클래스에 대한 모든 정보를 얻을 수 있기 때문에 Class 객체를 통해 객체를 생성하고 메서드를 호출하는 등보다 동적인 코드 작성

Card c=new Card(); // new 연산자를 이용해서 객체 생성
Card c=Card.class.newInstance(); //Class객체를 이용해 객체 생성
*newInstance()는 InstantiationException이 발생할 수 있으므로 예외처리 필요*

***

### 1.2. String 클래스

- 문자열을 위한 클래스로 문자열을 저장하고 다루는데 필요한 메서드를 함게 제공

#### 변경 불가능한(immutable) 클래스

- 문자열을 저장하기 위해 문자형 배열 참조변수(char[]) value를 인스턴스 변수로 정의
- 인스턴스 생성 시 생성자의 매개변수로 입력받는 문자열은 이 인스턴스 변수(value)에 문자형 배열(char[])로 저장되는 것
*String 클래스는 앞에 final이 붙어 있으므로 다른 클래스의 조상이 될 수 없음*
- 한 번 생성된 String인스턴스가 갖고 있는 문자열은 읽어올 수만 있고, 변경할 수 없음
- + 연산자를 이용해 문자열을 결합하는 경우 인스턴스 내의 문자열이 바뀌는 것이 아니라 새로운 문자열이 담긴 String 인스턴스가 생성되는 것
- 덧셈 연산자 +를 사용해 문자열을 결합하는 것은 매 연산 시마다 새로운 문자열을 가진 String인스턴스가 생성돼 메모리공간을 차지하게 되므로 가능한 결합횟수를 줄이는 것이 좋음
- 문자열 간 결합이나 추출 등 문자열을 다루는 작업이 많이 필요한 경우 String클래스 대신 StringBuffer클래스를 사용하는 것이 좋으며, StringBuffer인스턴스에 저장된 문자열은 변경이 가능하므로 하나의 StringBuffer 인스턴스 만으로 문자열을 다루는 것이 가능

#### 문자열의 비교

- 문자열 생성 시 문자열 리터럴을 지정하는 방법 / String클래스의 생성자를 사용해 만드는 방법으로 2가지 존재
- String 클래스의 생성자를 이용한 경우 new 연산자에 의해 메모리할당이 이루어지기 때문에 항상 새로운 String인스턴스가 생성
- 문자열 리터럴은 이미 존재하는 것을 재사용
- equals()를 사용했을 때 두 문자열의 내용을 비교하기 때문에 두 경우 모두 true 결과를 얻지만 각 String인스턴스 주소를 등가비교연산자==로 비교했을 때는 결과가 다름

#### 문자열 리터럴

- 자바 소스파일에 포함된 모든 문자열 리터럴은 컴파일 시 클래스 파일에 저장
- 같은 내용의 문자열 리터럴은 한번만 저장
- 문자열 리터럴도 String인스턴스고, 한 번 생성하면 내용 변경이 불가하므로 하나의 인스턴스를 공유하면 되기 때문
- 클래스 파일에는 소스 파일에 포함된 모든 리터럴의 목록이 있으며 해당 클래스 파일이 클래스 로더에 의해 메모리에 올라갈 때, 이 리터럴의 목록에 있는 리터럴들이 JVM내에 있는 상수 저장소(constant pool)에 저장되며 문자열 리터럴이 자동적으로 생섣되어 저장되는 것

#### 빈 문자열(empty string)

- 길이가 0 배열이 존재할 수 있으며 char형 배열도 길이가 0인 배열을 생성할 수 있고, 이 배열을 내부적으로 가지고 있는 문자열이 빈 문자열
- String s="";같은 문장은 내부에 new char[0]과 같이 길이가 0인 char형 배열을 저장하고 있는 것
- char형 변수는 반드시 하나의 문자를 지정해야함
*C언어에서는 문자열의 끝에 널 문자가 항상 붙었지만 자바에서는 널 문자를 사용하지 않으며, 대신 문자열의 길이 정보를 따로 저장*

#### String클래스의 생성자와 메서드

|메서드|설명|
|---|---|
|String(String a)|주어진 문자열(s)을 갖는 String인스턴스를 생성|
|String(char[] value)|주어진 문자열(value)을 갖는 String인스턴스를 생성|
|String(StringBuffer buf)|StringBuffer인스턴스가 갖고 있는 문자열과 같은 내용의 String인스턴스 생성|
|char charAt(int index)|지정된 위치(index)에 있는 문자를 알려주며 index는 0부터 시작|
|int compareTo(String str)|문자열(str)과 사전순서로 비교하며 같으면 0, 사전순 이전이면 음수, 이후면 양수 반환|
|String concat(String str)|문자열(str)을 덧붙임|
|boolean contains(CharSequence s)|지정된 문자열(s)가 포함되었느닞 검사|
|boolean endsWith(String suffix)|지정된 문자열(suffix)로 끝나는지 검사|
|boolean equals(Object obj)|매개변수로 받은 문자열(obj)과 String인스턴스의 문자열을 비교하며, obj가 String이 아니거나 문자열이 다르면 false반환|
|boolean equalsIgnoreCase(String str)|문자열과 String인스턴스의 문자열을 대소문자 구분없이 비교|
|int indexOf(int ch)|주어진 문자(ch)가 문자열에 존재하는지 확인하여 위치(index)를 알려줌, 못 찾으면 -1을 반환(index는 0부터 시작)|
|int indexOf(int ch, int pos)|주어진 문자(ch)가 문자열에 존재하는지 지정된 위치(pos)부터 확인해 위치(index)를 알려주며, 못 찾으면 -1 반환(index는 0부터 시작)|
|String intern()|문자열을 상수풀(constant pool)에 등록하며, 이미 상수풀에 같은 내용의 문자열이 있을 경우 그 문자열의 주소값 반환|
|int lastIndexOf(int ch)|지정된 문자 또는 문자코드를 문자열의 오른쪽 끝에서부터 찾아서 위치(index)를 알려주며, 못찾으면 -1 반환|
|int lastIndexOf(String str)|지정된 문자열을 인스턴스 문자열 끝에서부터 찾아 위치(index)를 알려주묘, 못찾으면 -1 반환|
|int length()|문자열 길이 반환|
|String replace(char old, char nw)|문자열 중 문자(old)를 새로운 문자(nw)로 바꾼 문자열 반환|
|String replaceAll(String reges, String replacement())|문자열 중 지정된 문자열(regex)과 일치하는 것을 새로운 문자열(replacement)로 모두 변경|
|String replaceFirst(String regex, String replacement)|문자열 중 지정된 문자열(regex)과 일치하는 것 중, 첫 번재 것만 새로운 문자열(replacement)로 변경|
|String[] split(String regex)|문자열을 지정된 분리자(regex)로 나눠 문자열 배열에 담아 반환|
|String[] split(String regex, int limit)|문자열을 지정된 분리자(regex)로 나눠 문자열 배열에 담아 반환하며 문자열 전체를 지정된 수(limit)로 자름|
|boolean startsWith(String prefix)|주어진 문자열(prefix)로 시작하는지 검사|
|String substring(int begin) / String substring(int begin, int end)|주어진 시작위치(begin)부터 끝 위치(end)범위에 포함된 문자열을 얻으며 시작 위치의 문자는 범위에 포함되지만, 끝 위치의 문자는 포함되지 않음(begin<=x<end)|
|String toLowerCase()|String인스턴스에 저장되어있는 모든 문자열을 솜누자로 변환해 반환|
|String toString()|String인스턴스에 저장되어있는 문자열 반환|
|String toUpperCase()|String인스턴스에 저장되어있는 모든 문자열을 대문자로 변환해 반환|
|String trim()|문자열의 왼쪽 끝과 오른쪽 끝에 있는 공백을 없앤 결과를 반환, 이 때 문자열 중간에 있는 공백은 제거 X|
|static String valueOf(boolean b)|지정된 값을 문자열로 변환해 반환하며 참조변수의 경우 toString()을 호출한 결과 반환|
|static String valueOf(char c)||
|static String valueOf(int i)||
|static String valueOf(long l)||
|static String valueOf(folat f)||
|static String valueOf(double b)||
|static String valueOf(Object o)||

*CharSequence는 JDK1.4부터 추가된 인터페이스로 String, StringBuffer 등 클래스 구현*
*contains(CharSequence s),replace(CharSequence old, CharSequence nw)는 JDK1.5부터 추가*
*java.util.Date dd=new java.util.Date();애서 생성된 Date인스턴스는 현재 시간을 가짐*

#### join()과 ㅏSTringJoiner

- join()은 여러 문자열 사이 구분자를 넣어 결합
- 구분자로 문자열을 자르는 split()과 반대 작업

#### 유니코드의 보충문자

- 문자를 다루는 메서드의 매개변수 타입이 char이 아닌 int인 이유: 확장된 유니코드를 다르기 위함
- 유니코드는 원래 2 byte로 16비트 문자체계나 모자라서 20비트로 확장함에 따라 하나의 문자를 char타입으로 다루지 못하고, int타입으로 다루게 됨
- 보충 문자(supplementary characters): 확장에 의해 새로 추가된 문자들
- String클래스의 메서드 중 보충 문자를 지원하는 것이 있고 지원하지 않는 것이 있음
- 구별하는 방법: 매개변수가 int ch 같은 것들은 보충 문자를 지원하는 것이고, char ch것은 지원하지 않는 것
- 보충문자를 사용할 일은 거의 없음
*확장된 유니코드(20bit)가 적용된 것은 JDK1.5부터*

#### 문자 인코딩 변환

- getBytes(String charsetName)를 사용하면, 문자열의 문자 인코딩을 타 인코딩으로 변경 가능
- 자바는 UTF-16을 사용하나 문자열 리터럴에 포함되는 문자들은 OS의 인코딩을 사용
- 한글 윈도우즈 경우 문자 인코딩으로 CP949를 사용하며, UTF-8로 변경도 가능
- 서로 다른 문자 인코딩을 사용하는 컴퓨터 간 데이터를 주고받을 때는 적절한 문자 인코딩 필요
- UTF-8은 한글 한 글자로 3byte 로 표현하고, CP949(==MS)는 2 byte로 표현

#### String.format()

- format()은 형식화된 문자열을 만들어내는 방법

#### 기본형 값을 String으로 변환

- 숫자로 이루어진 문자열을 숫자로, 그 반대로 변환하는 경우가 흔한데 기본형을 문자열로 변경하는 방법
- 숫자+""는 문자열로 변경, valueOf() 사용도 가능하며, 더 성능이 좋지만 빈 문자열을 더하는 방법도 간단하고 편함
*참조변수에 String을 더하면, 참조변수가 가리키는 인스터스의 toString()을 호출해 STring을 얻은 다음 결합*

#### String을 기본형 값으로 변환

- valueOf(), parseInt() 사용
- valueOf() 반환타입은 int가 아니라 Integer인데, 오토박싱(auto-boxing)에 의해 Integer가 int로 자동 변환
- 예전에는 parseInt()같은 메서들르 많이 사용했으나, 현재는 메서드 이름을 통일하기 위해 valueOf()추가. 이는 메서드 내부애서 parseInt(String s)를 호출해 반환타입만 다를 뿐 같은 메서드
- 메서드 내 문자열에 공백 또는 문자가 포함되는 경우 변환 시 예외(NumberFormatException)가 발생할 수 있으므로 주의
=> 문자열 양끝의 공백을 제거해주는 trim()을 습관적으로 같이 사용
- 문자열을 숫자로 변환하는 과정에서 예외가 발생하기 쉽기에 주의를 해야하며, 예외 발생시 처리를 적절히 해야함

### 1.3. StringBuffer클래스와 StringBuilder클래스

- String클래스는 인스턴스를 생성할 때 지정된 문자열을 변경할 수 없지만 StringBuffer클래스는 변경 가능
- 내부적으로 문자열 편집을 위한 버퍼(Buffer)를 가지고 있으며, StringBuffer인스턴스를 생성할 때 그 크기 지정 가능
- 편집할 문자열의 길이를 고려해 버퍼의 길이를 충분히 잡아주기 => 편집 중인 문자열이 버퍼의 길이를 넘으면 버퍼의 길이를 늘려주는 작업이 추가 수행할 필요가 있어 작업 효율이 떨어짐
- StringBuffer클래스는 String 클래스와 같이 문자열을 저장하기 위한 char형 배열의 참조 변수를 인스턴스변수로 선언해 놓음
- StringBuffer인스턴스가 생성될 때, char형 배열이 생성되며 이 때 생성된 char형 배열을 인스턴스 변수 value가 참조

#### StringBuffer의 생성자

- 인스턴스 생성 시, 적절한 길이의 char형 배열이 생성되고, 이 배열은 문자열을 저장하고 편집하기 위한 공간(buffer)으로 사용
- StringBuffer인스턴스 생성 시 생성자 StringBuffer(int length)를 사용해 StringBuffer인스턴스에 저장될 문자열의 길이를 고려해 충분히 여유있는 크기로 지정 권함
- StringBuffer인스턴스 생성 시, 버퍼크기를 지정하지 않으면 16개의 문자를 저장할 크기의 버퍼 생성
- StringBuffer인스턴스로 문자열을 다루는 작업 시, 버퍼의 크기가 작업하려는 문자열의 길이보다 작을 때는 내부적으로 버퍼의 크기를 증가시키는 작업 수행
- 배열의 길이는 변경될 수 없어 새로운 길이의 배열을 생성한 후 이전 배열 값을 복사해야함
=> StringBuffer클래스의 인스턴스 변수 value는 길이가 증가된 새로운 배열 참조

#### StringBuffer의 변경

- String과 달리 StringBuffer는 내용 변경 가능
- 하나의 StringBuffer인스턴스에 대해 연속적으로 append()출력 가능 => 반환 타입이 void라면 불가능
*StringBuffer클래스에는 append()처럼 객체 자신을 반환하는 메서드가 많이 존재*

#### StringBuffer의 비교

- Stirng클래스에서는 equals메서드를 오버라이딩해 문자열의 내용을 비교하도록 구현됐지만, StringBuffer클래스는 equals메서드를 오버라이딩하지 않아 StringBuffer클래스의 equals메서드를 사용해도 등가비교 연산자(==)로 비교한 것과 같은 결과를 얻음
- toString()은 오버라이딩되어 있어 StringBuffer인스턴스에 toString()을 호출하면, 담고있는 문자열을 String으로 반환
- StringBuffer인스턴스에 담긴 문자열을 비교하기 위해 StringBuffer인스턴스에 toString()을 호출해서 String인스턴스를 얻은 후, equals메서드를 사용해 비교

#### StringBuffer클래스의 생성자와 메서드

- 문자열을 다루기 위해 String클래스와 유사한 메서드가 많으며 추가, 변경, 삭제같은 저장된 내용을 변경할 수 있는 메서드들이 추가 제공

|메서드|설명|
|---|---|
|StringBuffer()|16문자를 담을 수 있는 버퍼를 가진 StringBuffer인스턴스 생성|
|StringBuffer(int length)|지정된 개수의 문자를 담을 수 있는 버퍼를 가진 StringBuffer 인스턴스 생성|
|StringBuffer(String str)|지정된 문자열 값(str)을 갖는 StringBuffer인스턴스 생성|
|StringBuffer append(boolean b)|매개변수로 입력된 값을 문자열로 변환해 StringBuffer인스턴스가 저장하고 있는 문자열의 뒤에 덧붙임|
|StringBuffer append(char c)||
|StringBuffer append(char[] str)||
|StringBuffer append(double d)||
|StringBuffer append(float t)||
|StringBuffer append(int i)||
|StringBuffer append(long l)||
|StringBuffer append(Object obj)||
|StringBuffer append(String str)||
|int capacity()|StringBuffer인스턴스의 버퍼크기를 알려주며, length()는 버퍼에 담긴 문자열의 길이를 알려줌|
|char charAt(int index)|지정된 위치(index)에 있는 문자 반환|
|StringBuffer delete(int start, int end)|시작위치(start)브타 끝 위치(end) 사이에 있는 문자를 제거하며, 끝 위치의 문자는 제외|
|StringBuffer deleteCharAt(int index)|지정된 위치(index) 문자 제거|
|StringBuffer insert(int pos, boolean b)|두 번째 매개변수로 받은 값을 문자열로 변환해 지정된 위치(pos)애 추가. pos는 0부터 시작|
|StringBuffer insert(int pos, char c)||
|StringBuffer insert(int pos, char[] str)||
|StringBuffer insert(int pos, double d)||
|StringBuffer insert(int pos, float f)||
|StringBuffer insert(int pos, int i)||
|StringBuffer insert(int pos, long l)||
|StringBuffer insert(int pos, Object obj)||
|StringBuffer insert(int pos, String str)||
|int length()|StringBuffer인스턴스에 저장되어 있는 문자열의 길이 반환|
|StringBuffer replace(int start, int end, String str)|지정된 범위(start~end)의 문자들을 주어진 문자열로 바꾸며, end위치의 문자는 범위에 포함되지 않음(start<=x<end)|
|StringBuffer reverse()|StringBuffer인스턴스에 저장되어 있는 문자열의 순서를 거꾸로 나열|
|void setCharAt(int index, char ch)|지정된 위치의 문자를 주어진 문자(ch)로 바꿈|
|void setLength(int newLength)|지정된 길이로 문자열의 길이를 변경하며, 길이를 늘리는 경우 나머지 빈공간을 널 문자 '\u0000'로 채움|
|String toString()|StringBuffer인스턴스의 문자열을 String으로 반환|
|String substring(int start)|지정된 범위 내 문자열을 String으로 뽑아서 반환, 시작 위치(start)만 지정하면 시작위치부터 문자열 끝까지 뽑아 반환|
|String substring(int start, int end)||

#### StringBuilder란?

- StringBuffer는 멀티쓰레드에 안전(thread safe)하도록 동기화되어있음
- 멀티쓰레드로 작성된 프로그램이 아닌 경우, StringBuffer의 동기화는 불필요하게 성능을 떨어뜨림
- StringBuilder: StringBuffer에서 쓰레드의 동기화만 뺀 완전히 똑같은 기능으로 작성
- 다만 StringBuffer도 충분히 성능이 좋음

#### Math클래스

- 수학계산에 유용한 메서드로 구성
- Math클래스의 생성자는 접근 제어자가 private로 다른 클래스에서 Math인스턴스를 생성할 수 없게 함
=> 클래스 내 인스턴스 변수가 하나도 없어서 인스턴스를 생성할 필요가 없어 Math클래스 메서드는 모두 static으로 2개의 상수만 정의함(자연 로그 밑, 원주율)

#### 올림, 버림, 반올림

- round(): 소수점 n번째 자리에서 반올림한 값을 얻는 코드로 항상 소수점 첫째자리에서 반올림을 해서 정수값(long)을 결과로 돌려줌
- 정수형간 연산은 반올림이 이루어지지 않음
- rint(): round()처럼 소수점 첫째자리에서 반올림하지만 반환값이 double이고, 두 정수 정 가운데에 있는 값은 가장 가까운 짝수 정수를 반환

#### 예외를 발생시키는 메서드

- 메서드 이름에 Exact가 포함된 메서드가 정수형 간의 연산에서 발생할 수 있는 오버플로우를 감지
- 연산자는 단지 결과를 반환할 뿐, 오버플로우 발생 여부에 대해 알려주지 않는데, 이 메서드는 오버플로우 발생시 예외를 발생

#### 삼각함수와 지수, 로그

- float타입 정밀도: 7자리 / double타입 정밀도: 15자리

#### StrictMath클래스

- Math클래스는 최대한의 성능을 얻기 위해 JVM이 설치된 OK의 메서드를 호출해 사용해서 OS 의존 계산을 수행. OS마다 수행 결과 능력이 다르면 자바로 작성한 프로그램이여도 다른 결과가 나오기에, 성능을 포기해도 항상 같은 결과를 얻도록 만들어진 Math클래스

#### Math클래스의 메서드

|메서드|설명|
|---|---|
|static double abs(double a)|주어진 절대값을 반환|
|static double abs(float f)||
|static double abs(int f)||
|static double abs(long f)||
|static double ceil(double a)|주어진 값을 올림하여 반환|
|static double floor(double a)|주어진 값을 버림하여 반환|
|static double max(double a, double b)|주어진 두 값을 비교하여 큰 쪽을 반환|
|static float max(float a, float b)||
|static int max(int a, int b)||
|static long max(long a, long b)||
|static double min(double a, double b)|주어진 두 값을 비교하여 작은 쪽을 반환|
|static float min(float a, float b)||
|static int min(int a, int b)||
|static long min(long a, long b)||
|static double random()|0.0~1.0범위의 임의의 double값을 반환(1.0은 범위에 포함되지 않음)|
|static double rint(double a)|주어진 double값과 가장 가까운 정수값을 double형으로 반환. 두 정수가 정가운데에 있는 값(1.5,2.5,3.5 등)은 짝수 반환|
|static long round(double a)|소수점 첫째자리에서 반올림한 정수값(long)을 반환. 매개변수의 값이 음수인 경우, round()와 rint()의 결과가 다름|
|static long round(float a)||

#### 래퍼(wrapper)클래스

- 자바는 8개의 기본형은 객체로 안 다루는 대신 더 높은 성능을 얻음
- 기본형(primitive type)변수도 어쩔 수 없이 객체로 다뤄야 할 경우가 있는데, 매개변수로 객체를 요구할 때 기본형 값이 아닌 객체로 저장할 때 객체 간 비교가 필요할 때 경우 기본형 값들을 객체로 변환해 작업 수행 필요
- 8개의 기본형을 대표하는 8개의 래퍼 클래스를 사용하면 기본형을 객체로 다룰 수 있음
- 래퍼 클래스의 생성자는 매개변수로 문자열이나 각 자료형의 값들을 인자로 받음
*주의점: 생성자의 매개변수로 문자열을 제공 시, 각 자료형에 알맞는 문자열 사용 필요*

|기본형|래퍼 클래스|
|---|---|
|boolean|Boolean|
|char|Character|
|byte|Byte|
|short|Short|
|int|Integer|
|long|Long|
|float|Float|
|double|Double|

- 래퍼 클래스들은 모두 equals()가 오버라이딩되어 있어 주소값이 아닌 객체가 가지고 있는 값을 비교
=> 실행결과를 equals()를 이용한 두 Integer객체의 비교 결과가 true로 확인
- 오토박싱이 돼도 Integer객체에 비교연산자를 사용할 수 없어 compareTo()를 제공
- toString()도 오버라이딩되어 있어 객체가 가지고 있는 값을 문자열로 변환해 반환
- MAX_VALUE, MIN_VALUE, SIZE, BYTES, TYPE 등 static상수를 공통적으로 지님

#### Number클래스

- 추상클래스로 내부적으로 숫자를 멤버변수로 갖는 래퍼 클래스들의 조상
- 기본형 중 숫자와 관련된 래퍼 클래스들은 모두 Number클래스의 자손
- BigInteger: long으로 다룰 수 없는 큰 범위 정수
- BigDecimal: double로 다룰수 없는 큰 범위의 부동 소수점수를 처리하기 위한 것으로 연산자의 역할을 대신하는 다양한 메서드 제공
- 실제 소스는 객체가 가지고 있는 값을 숫자와 관련된 기본형으로 변환해 반환하는 메소드들을 정의

#### 문자열을 숫자로 변환하기

- int i=new Integer("100").intValue(); // floatValue(), longValue(), ...
- int i2=Integer.paeseInt("100");
- Integer i3=Integer.valueOf("100");

- 래퍼 클래스의 타입.parse타입(String s) 형식의 메서드와 타입.valueOf()메서드가 존재하는데, 둘 다 문자를 숫자로 바꿔주는 일을 하지만, 전자는 반환값이 기본형(primitive type)이고, 후자는 반환값이 래퍼클래스 타입이라는 차이가 존재

|문자열->기본형|문자열->래퍼 클래스|
|---|---|
|byte b=Byte.parseByte("100")|byte b=Byte.valueOf("100")|
|short b=Short.parseShort("100")|short b=Short.valueOf("100")|
|int b=Integer.parseInt("100")|Integer b=Integer.valueOf("100")|
|long b=Long.parseLong("100")|Long b=Long.valueOf("100")|
|float b=Float.parseFloat("100")|Float b=Float.valueOf("100")|
|double b=Float.parseDouble("100")|Double b=Double.valueOf("100")|

- 오토박싱(autoboxing)기능으로 반환값이 기본형일 때와 래퍼 클래스일때 차이는 없어져서 구별없이 valueOf()를 사용해도 되자만, 성능은 조금 더 느림
- 문자열이 10진수가 아닌 다른 진법(radix)의 숫자일 때도 변환이 가능하도록 메서드가 제공
- 진법 생략 시 10진수로 간주하기에 이 이상의 진법을 사용하면 NumberFormatException 발생

#### 오토박싱 & 언박싱(autoboxing & unboxing)

- 기본형과 참조형 간 연산은 컴파일러가 자동으로 변환하는 코드로 계산이 가능하게 됨. 객체를 기본형으로 바꿔주는 Value()코드 추가
- 내부적으로 객체 배열을 가지는 Vector클래스나 ArrayList클래스에 기본형 값을 저장해야할 때나 형변환이 필요할 때도 컴파일러가 자동적으로 코드를 추가
- 오토박싱(autoboxing): 기본형 값을 래퍼 클래스의 객체로 자동 변환해주는 것
- 언박싱(unboxing): 래퍼 클래스의 객체를 기본형 값으로 자동 변환해주는 것
- 기본형과 참조형 간 형변환이 가능하며 참조형 간 연산도 가능함
- 생성자가 없는 클래스에 컴파일러가 기본 생성자를 자동적으로 추가해주듯 개발자가 간략하게 쓴 구문을 컴파일러가 원래의 구문으로 변경해주는 것

## 2. 유용한 클래스

### 2.1. java.util.Objects클래스

- Object클래스의 보조 클래스로 Math클래스처럼 모든 메서드가 static
- 객체 비교나 널 체크(null check)에 유용
- isNull(): 해당 객체가 널인지 확인해 null일시 true, 아니면 false 반환
- nonNull(): == !Objects. isNull(obj)
- requireNonNull(): 해당 객체가 널이 아니어야한 경우에 사용하며, 객체가 널이면 NullPointerException을 발생. 두 번째 매개변수로 지정하는 문자열은 예외 메시지가 됨
- Object 클래스에는 두 객체의 등가 비교를 위한 equals()만 있고, 대소비교를 위한 comparse()가 없었는데 Objects에는 compare()가 추가.
- compare(): 두 비교대상이 같으면 0, 크면 양수, 작으면 음수 반환
- Comparator: a,b 두 객체를 비교하는데, 사용할 비교 기준 역할
- Object 클래스에 정의된 equals()가 필요한 이유: null 검사 불필요
- equals() 내부에서 a,b의 널 검사를 하기 때문에 따로 널 검사를 위한 조건식은 넣지 않아도 됨. 두 변수가 모두 널인 경우 참을 반환.
- deepEquals(): 객체를 재귀적으로 비교해 다차원 배열 비교가 가능
- 2차원 문자열 배열을 비교하기 위헤서는 equals()+반복문 / deepEquals() 사용
- toString()도 equals()처럼 내부적으로 널 검사를 한다는 것 외에 같음. 두 번째 메서드는 o가 널일 경우, 대신 사용할 값을 지정할 수 있어 유용
- hashCode(): 내부적으로 널 검사 후 Object클래스의 hashCode() 호출. 단, 널일 때는 0 반환
- 보통 클래스에 선언된 인스턴스 변수들의 hashCode()를 조합해 반환하도록 hashCode()를 오버라이딩하는데, 대신 매개변수 타입이 가변인자인 두 번째 메서드를 사용하면 편리
- Object클래스의 메서드와 이름이 같은 것들은 충돌()컴파일러가 구분을 못함 => 클래스의 이름을 붙여 해결

### 2.2. java.util.Random클래스

- double randomNum = Math.random();
- double randNum = new Random().nextDouble();
- Math.random()과 Random의 가장 큰 차이점: 종자값(seed) 설정 가능. 종자값이 같은 Random인스턴스들은 항상 같은 난수를 같은 순서대로 반환
- 종자값은 난수를 만드는 공식에 사용되는 값으로 같은 공식에 같은 값을 넣을 시 같은 결과를 얻는 것 처럼 같은 종자값을 넣으면 같은 난수를 얻음

#### Random클래스의 생성자와 메서드

- 생성자 Random()은 System.currentTimeMillis()로 해 실행할 때마다 얻는 난수가 달라짐
*System.currentTimeMillis()는 현재 시간을 천분의 1초 단위로 변환해 반환*
- 같은 종자값을 갖는 Random인스턴스는 시스템이나 실행 시간 등에 관계 없이 항상 같은 값을 같은 순서로 반환할 것을 보장

### 2.3. 정규식(Regular Expression) - java.util.regex 패키지

- 정규식: 텍스트 데이터 중에서 원하는 