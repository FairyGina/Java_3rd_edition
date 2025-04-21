# ch10 날짜와 시간 & 형식화

## 1. 날짜와 시간

### 1.1. Calendar와 Date

- Date는 날짜와 시간을 다룰 목적으로 JDK1.0부터 제공되었으며, 후에 Calendar라는 새로운 클래스를 JDK1.1부터 제공
- Calendar은 기존 Date보다 낫지만 단점이 존재해 JDK1.8부터 java.time패키지로 새롭게 추가
- 지금도 세 개의 클래스로 존재
*Date클래스는 java.util패키지에 속하며 java.sql패키지의 Date클래스와 다름*

#### Calendar와 GregorianCalendar

- Calendar은 추상클래스로 직접 객체 생성 불가, 메서드를 통해 완전히 구현된 클래스의 인스턴스를 얻어야함
- Calendar을 상속받아 완전히 구현한 클래스로는 GregorianCalendar / BuddhistCalendar 가 존재
- getInstance(): 시스템의 국가와 지역설저을 확인해 태국은 BuddhistCalendar의 인스턴스를 반환, 그 외는 GregorianCalendar 인스턴스 반환
- 경우에 따라 타 종류의 역법(calendar)을 사용하는 국가에서 실행, 혹은 새로운 역법이 추가되는 경우 같이 타 종류의 인스턴스를 필요로 하는 경우 Calendar.getInstance()같이 사용
- getInstance()메서드가 static인 이유: 메서드 내 코드에서 인스턴스 변수를 사용하거나 인스턴스 메서드를 호출하지 않으며, 추상 클래스인데 static이 아닐경우 객체 생성이 불가능해지기 때문

#### Date와 Calendar간의 변환

- deprecated: 더이상 사용을 권장하지 않음 
- Date 대부분 메서드는 deprecated가 붙어있음

##### 그럼에도 불구하고 사용하는 경우

1. Calendar을 Date로 변환
2. Date를 Calendar로 변환

- getInstance()를 통해 얻은 인스턴스는 기본적으로 현재 시스템의 날짜와 시간에 대한 정보를 담고 있어, 원하는 날짜나 시간으로 설정하려면 set메서드를 사용
- get메서드의 매개변수로 사용되는 int값들은 Calendar에 정의된 static상수
- get(Calendar.MONTH)로 얻어오는 값의 범위는 0~11
- 두 날짜 간 차이를 구하기 위해 두 날짜를 최소단위인 초 단위로 변경 후 그 차이를 구하면 됨
- 시간 상의 전후를 알고 싶으면 두 날짜 간 차이가 양수/음수인지를 판단(간단히는 boolean after / boolean before 사용도 가능)
- add(int field, int amount)를 사용 시 지정한 필드 값을 원하는 만큼 증가 혹은 감소가 가능해 add메서드를 이용 시 특정 날짜/시간을 기점으로 일정 기간 전후의 날짜와 시간을 알아낼 수 있음
- roll(int field, int amound)도 가능하나, add메서드와의 차이점은 타 필드에 영향을 미치지 않음
- 예외: 일 필드(Calendar.DATE)가 말일(end of month)일 때, roll메서드를 이용해 월 필드(Calendar.MONTH)를 변경 시 일 필드(Calendar.DATE)에 영향을 미칠 수 있음
*예: 1월 31일에서 월 하나 증가 시, 1월 31일은 없으므로 2월 28일로 자동 변경(add메서드도 마찬가지)*

***

## 2. 형식화 클래스

- java.text패키지에 포함됐으며 숫자, 날짜, 텍스트 데이터를 일정한 형식에 맞게 표현할 수 있느 방법을 객체지향적으로 설꼐해 표준화
- 형식화에 사용될 패턴을 정의하는데, 데이터를 정의된 패턴에 맞춰 형식화하고, 역으로 형식화된 데이터에서 원래의 데이터 얻기 가능

### 2.1. DecimalFormat

- 숫자를 형식화하는데 사용
- 숫자 데이터를 정수, 부동소수점, 금액 등 다양한 형식으로 표현이 가능하며, 일정한 형식의 텍스트 데이터를 숫자로 쉽게 변환하는 것도 가능
- 사용하는 방법: 원하는 출력형식의 패턴을 작성해 DecimalFormat 인스턴스 생성 후, 출력하고자 하는 문자열로 format메서드를 호출 시 원하는 패턴에 맞게 변환된 문자열 획득
*Integer.parseInt메서드는 콤마(,)가 포함된 문자열을 숫자로 변환X*
- parse(String source)는 DEcimalFormat의 조상인 NumberFormat에 정의된 메서드임
- Number클래스는 Integer, Double과 같은 숫자를 저장하는 래퍼 클래스의 조상으로, doubleValue()는 Number에 저장된 값을 double형의 값으로 변환해 반환

### 2.1. SimpleDateFormat

- DateFormat은 추상클래스로 SimpleDateFormat의 조상
- 추상클래스로 인스턴스를 생성하기 위해 getDateInstance()와 같이 static메서드를 이용해야 하며, getDateInstance()에 의해 반환되는 것은 DateFormat을 상속받아 완전하게 구현된 SimpleDateFormat인스턴스임
- 사용 방법: 원하는 출력형식의 패턴을 작성해 SimpleDateFormat인스턴스를 생성 후, 출력하고자 하는 Date 인스턴스를 가지고 format(Date d)를 호출 시 지정한 출력 형식에 맞게 변환된 문자열 획득
- substring메서드를 이용해 날짜를 뽑는 것보다 parse를 사용 시 더 간편함
*지정된 형식과 입력된 형식이 불일치할 경우 예외 발생이 되므로 적절한 예외처리가 필요*

### 2.3. ChoiceFormat

- 특정 범위에 속하는 값을 문자열로 변환
- 연속/불연속적인 범위의 값들을 처리하는데에 if문이나 switch문이 적절하지 않은 경우, 간단하고 직관적으로 사용 가능
- 배열 대신 패턴을 사용 시 간결하게 처리 가능
- 패턴은 구분자로 # / < 두 가지를 제공하며, limit#value의 형태로 사용. #은 경계값을 범위에 포함시키나 <는 경계값을 포함시키지 않음

### 2.4. MessageFormat

- 데이터를 정해진 양식에 맞게 출력하도록 도움
- 데이터가 들어갈 자리를 마련해 놓은 양식을 미리 작성하고 프로그램을 이용해 다수의 데이터를 같은 양식으로 출력할 때 사용하면 좋음
*예: 고객들에게 보낼 안내문 출력 시 같은 안내문 양식에 받는 사람의 이름과 같은 데이터만 달라지도록 출력*

## 3. java.time 패키지

- JDK1.8부터 사용됐으며, 4개의 하위 패키지가 존재

|패키지|설명|
|---|---|
|java.time|날짜와 시간을 다루는데 필요한 핵심 클래스 제공|
|java.time.chrono|표준(ISO)이 아닌 달력 시스템을 위한 클래스 제공|
|java.time.format|날짜와 시간을 파싱하고, 형식화하기 위한 클래스 제공|
|java.time.temporal|날짜와 시간의 필드(field)와 단위(unit)를 위한 클래스 제공|
|java.time.zone|시간대(time-zone)와 관련된 클래스 제공|

- String클래스처럼 불변(immutable)으로, 날짜나 시간을 변경하는 메서드들은 기존 객체를 변경하는 대신 항상 변경된 새로운 객체를 반환
*기존 Calendar클래스는 변경이 가능해 멀티쓰레드 환경에서는 안전하지 못함*
- 쓰레드가 안전하지 않음: 멀티쓰레드 환경에서 동시에 여러 쓰레드가 같은 객체에 적븐이 가능하기에, 변경 가능한 객체는 데이터가 잘못될 가능성이 존재

### 3.1. java.time패키지의 핵십 클래스

- Calendar클래스는 날짜와 시간을 하나로 표현하나 java.time 패키지는 날짜와 시간을 별도의 클래스로 분리
LocalTime클래스: 시간 표현 / LocalDate클래스: 날짜 표현
*날짜와 시간이 모두 필요할 경우 두 클래스를 더해서 사용하면 됨*
ZoneDateTime: 시간대(time-zone)
- Calendar은 ZonedDateTime처럼 날짜,시간,시간대 모두 포함
- Date는 유사한 클래스로 Instant가 존재하는데, 날짜와 시간을 초 단위(나노초)로 표현
- 타임스탬프(time-stamp): 날짜와 시간을 초 단위로 표현한 값
- 타임스태프로 날짜와 시간을 하나의 정수로 표현할 수 있어 날짜와 시간의 차이를 계산하거나 순서를 비교하는데 유리해 데이터베이스에 많이 사용

#### Period와 Duration

- 날짜와 시간의 간격을 표현하기 위한 클래스
- pariod: 두 날짜 간의 차이 / Duration: 시간의 차이

#### 객체 생성하기 - now(), of()

- java.time패키지에 속한 클래스의 객체를 생성하는 가장 기본적인 방법은 now()와 of()를 사용하는 것
- now(): 현재 날짜와 시간을 저장하는 객체를 생성
- of(): 단순히 해당 필드의 값을 순서대로 지정헤주며 각 클래스마다 다양한 종류의 of()가 정의되어 있음

#### Temporal과 TemporalAmount

- Date,Time: Temporal~
- Period/Duration: TemporalAmount
*temporal과 chrono의미는 모두 시간이지만 time으로 사용하지 않는 이유: 시간을 더 큰 개념(년월일시분초)로 구분하기 위함*

#### TemporalUnit과 TemporalField

- TemporalUnit인터페이스: 날짜와 시간의 단위를 정의해놓은 것
- 열거형 ChronoUnit: 위 인터페이스를 구현한 것
- TemporalField: 년,월,일 등 날짜와 시간의 필드를 정의해놓은 것
- 열거형 Chronofield: 위 인터페이스를 구현한 것

### 3.2. LocalDate와 LocalTime

- java.time패키지의 가장 기본 클래스로, 나머지 클래스는 이 클래스의 확장임
- 객체를 생성하는 방법: 현재의 날짜와 시간을 LocalDate와 LocalTime으로 각각 반환하는 now()와 지정된 날짜와 시간으로 LocalDate와 LocalTime객체를 생성하는 of()가 존재하며 둘 다 static 메서드

#### 특정 필드의 값 가져오기 - get().getXXX()

- calendar과 달리 월 범위(1~12), 요일(1~7)인 것을 주의

#### 필드의 값 변경하기 - with(), plus(), minus()

- 날짜와 시간에서 특정 필드 값을 변경 시, with로 시작하는 메서드 사용
- with 사용 시, 원하는 필드를 직접 지정 가능
- 핖드를 변경하는 메서드들은 항상 새로운 객체를 생성해 반환하므로 대입연산자를 같이 사용해줘야함
- 특정 필드에 값을 더하거나 빼는 plus() / minus()가 존재
- LocalTime의 truncatedTo()는 지정된 것보다 작은 단위의 필드를 0으로 만듦
- LocalDate는 truncatedTo()가 없는데, LocalDate는 년,월,일이 0이 될 수 없기 때문

#### 날짜와 시간의 비교 - isAfter(), isBefore(), isEqual()

- LocalDate / LocalTime도 compareTo()가 적절히 오버라이딩되어 있어, compareTo()로 비교 가능
- equals()가 있어도 isEqual()를 제공하는 이유는 연표(chronology)가 다른 두 날짜를 비교하기 위함
*equals는 모든 필드가 일치해야하나 isEqual()은 날짜만 비교하며, 대부분의 경우 두 결과는 같음*

### 3.3. instant

- 에포크 타입(EPOCH TIME, 1970-01-01 00:00:00 UTC)부터 경괴된 시간을 나노초 단위로 표햔
- 단일진법으로만 다뤄져 사람에게는 불편하지만 계산하기는 쉬움(사람이 사용하는 날짜와 시간은 여러 진법이 섞여있어 계산이 어려움)
- Instant 생성방법: now(), ofEpochSecond()를 사용
- 시간을 초 단위와 나노초 단위로 나눠 저장하며, 오라클 db의 타임스탬프처럼 밀리초 단위의 epochtime을 필요로 하는 경우를 위해 toEpochMilli()가 정의
- 항상 UTC(+00:00)를 기준으로 해서 LocalTime과 차이가 존재할 수 있음
- UTC(Coordinated Universal Time): 세계 협정시로 1972년 1월 1일부터 시행된 국제 표준시로, 이전에 사용되던 GMT와 동일하나 UTC가 더 정확함

#### instant와 Date간의 변환

- 기존 java.util.Date를 대체하기 위한 것으로, JDK1.8부터 Date에 Instant로 변환할 수 있는 새로운 메서드가 추가

### 3.4. LocalDateTime과 ZonedDateTime

- LocalDate + LocalTime = LocalDateTime
- LocalDateTime + 시간대 = ZonedDateTime

#### LoalDate와 LocalTime으로 LocalDateTime 만들기

#### LocalDateTime의 변환

#### LocalDateTime으로 ZonedDateTime 만들기

- 기존에는 TimeZone클래스로 시간대를 다뤘지만 새로운 시간 패키지에서는 ZoneId라는 클래스를 사용
- ZoneId: 일광 절약시간(DST)을 자동 처리
사용 가능한 ZoneId의 목록은 ZoneId.getAvailableZonelds()로 획득 가능
- LocalDate에 atStartOfDay()라는 메서드가 존재하는데, 이 메서드에 매개변수로 ZoneId를 저장해도 ZonedDateTime 획득 가능

#### ZoneOffset

- UTC로부터 얼마만큼 떨어져있는지를 표현

#### OffsetDateTime

- ZonedDateTime은 ZoneId로 구역을 표현하는데, ZoneOffset를 사용
- ZoneId는 일광절약시간처럼 시간대와 관련된 규칙들을 포함하나 ZoneOffset은 단지 시간대를 시간의 차이로만 구분
- 서로 다른 시간대에 존재하는 컴퓨터간 통신에는 OffsetDateTinme이 필요

#### ZonedDateTime의 변환

- LocalDateTime처럼 날짜와 시간에 관련된 타 클래스로 변환하는 메서드를 가짐

### 3.5. TemmporalAdjusters

- 자주 쓰일만한 날짜 계산들을 대신 해주는 메서드를 정의해놓은 것

#### TemporalAdjuster 직접 구현

- with() 메서드를 구현해야 하며, with() / adjustInfo() 중 어느 쪽을 사용해도 되나 adjustInfo()는 내부적으로만 사용하므로 with()를 사용하도록 권장
- 날짜와 시간에 관련된 대부분의 클래스는 Temporal인터페이스로 adjustInfo()의 매개변수가 될 수 있음

### 3.6. Period와 Duration

- Period: 두 날짜 date1, date2 차이를 나타내며 between()으로 획득 가능
- date1이 date2보다 빠르면 양수, 이후면 음수로 저장
- Duration: 시간 차이를 구함

#### between()과 until()

- until(): between()과 거의 같은 일을 하지만, between()은 static메서드, until()은 인스턴스 메서드로 존재
- Period는 년월일을 분리해 저장해서 D-day를 구할 경우 두 개의 매개변수를 받는 until()을 사용하는 것을 추천
- 날짜가 아닌 시간에도 until()사용이 가능하나, Duration을 반환하는 until()은 존재하지 않음

#### of(), with()

#### 사칙연산, 비교연산, 기타 메서드

- plus(), minus(), multi(), divied()
- Peired에 나눗셈을 위한 메서드가 없는데, 날짜와 기간을 표현하기 위한 것으로 나눗셈을 위한 메서드가 유용하지 않다고 판단하에 넣지 않음
- 부호를 반대로 변경하는 negate(), 부호를 없애는 abs() 존재
- normalized(): 월(month)의 값이 12를 넘지 않게, 일(day)의 길이는 일정하지 않으므로 그대로 냅둚

#### 다른 단위로 변환 - toTotalMonths(), toDays(), toHours(), toMinutes()

- to로 시작하는 메서드: Period, Duration을 다른 단위의 값으로 변환하는데 사용
- get()은 특정 필드 값을 그대로 가져오지만, 해당 메서드는 특정 단위로 변환한 결과를 반환
*메서드들의 반환타입은 모두 정수(long타입)인데, 이 단위 이하 값들은 버려짐*
- LocalDate의 toEpochDay()라는 메서드는 Epoch Day인 1970-01-01부터 날짜를 세어 반환
- 이 메서드를 이용하면 Period를 사용하지 않고 두 날짜간 일수를 편하게 계산 가능(해당 두 날짜 모두 Epoch Day 이후여야함)

### 3.7. 파싱과 포맷

- 파싱(parsing): 날짜와 시간을 원하는 형식으로 출력하고 해석하는 방법
- 형식화(formatting)와 관련된 클래스들은 ajva.time.format 패키지에 들어있으며, DateTimeFormmatter가 핵심
- 날짜와 시간의 형식화에는 format()이 사용되는데, DateTimeFormatter뿐만 아니라 LocalDate / LocalTime같은 클래스도 존재

#### 로케일에 종속된 형식화

- DateTimeFormatter의 static메서드 ofLocalizedDate(), ofLocalizedTime(), ofLocallized DateTime()은 로케일(local)에 종속적인 포멧터를 생성

#### 출력 형식 직접 정의하기

- DateTimeFormatter의 ofPattern()으로 원하는 출력 형식 직접 작성 가능

#### 문자열을 날짜와 시간으로 파싱하기

- 문자열을 날짜 또는 시간으로 변환하는 방법은 static 메서드 parse()를 사용
- parse()는 오버로딩된 메서드가 여러 개 있으며 2개가 자주 쓰임
- 자주 사용되는 기본적인 형식의 문자열은 ISO_LOCAL_DATE와 같은 형식화 상수를 사용하지 않고도 파싱 가능