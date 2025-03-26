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