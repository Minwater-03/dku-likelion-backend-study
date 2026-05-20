# Backend VOD 학습 정리

## 1. 클래스와 객체

Java에서 클래스는 객체를 만들기 위한 설계도 역할을 한다.  
클래스 내부에는 객체가 가질 데이터인 필드와 객체가 수행할 동작인 메서드를 정의할 수 있다.

`BankAccount` 클래스에서는 은행 계좌 정보를 표현하기 위해 다음과 같은 필드를 사용한다.

```java
int bankCode;
int accountNo;
String owner;
int balance;
boolean isDormant;
int password;
```

이러한 필드는 객체가 생성되었을 때 각 객체가 가지는 상태값이 된다.  
예를 들어 계좌 번호, 예금주, 잔액 등은 계좌 객체마다 서로 다른 값을 가질 수 있다.

## 2. 생성자

생성자는 객체가 생성될 때 자동으로 호출되는 특수한 메서드이다.  
생성자의 이름은 클래스 이름과 동일해야 하며, 반환 타입을 작성하지 않는다.

```java
BankAccount(int bankCode, int accountNo, String owner, int balance, int password, boolean isdormant) {
    this.bankCode = bankCode;
    this.accountNo = accountNo;
    this.owner = owner;
    this.balance = balance;
}
```

생성자는 객체를 만들 때 필요한 초기값을 전달받아 필드를 초기화하는 데 사용된다.  
`this`는 현재 생성되는 객체 자신을 의미한다.

```java
this.bankCode = bankCode;
```

위 코드는 매개변수로 전달받은 `bankCode` 값을 현재 객체의 `bankCode` 필드에 저장한다는 의미이다.  
필드 이름과 매개변수 이름이 같을 때 `this`를 사용하면 둘을 명확하게 구분할 수 있다.

## 3. 메서드

메서드는 객체가 수행할 기능을 정의하는 코드 블록이다.  
`BankAccount` 클래스에는 계좌 조회, 입금, 출금, 휴면 계좌 처리와 관련된 메서드가 선언되어 있다.

```java
void inquiry() {}
void deposit() {}
void withdraw() {}
void helpInDormant() {}
```

현재 코드에서는 메서드의 구조만 작성되어 있고 내부 기능은 구현되어 있지 않다.  
이후 각 메서드 내부에 계좌 조회, 입금 처리, 출금 처리 등의 구체적인 로직을 작성할 수 있다.

## 4. Scanner와 사용자 입력

`Scanner`는 콘솔에서 사용자의 입력을 받을 때 사용하는 클래스이다.  
회원가입 실습 코드에서는 `Scanner`를 사용해 ID, 비밀번호, 이름, 생년월일, 이메일을 입력받는다.

```java
Scanner sc = new Scanner(System.in);
String username = sc.nextLine();
```

`nextLine()`은 사용자가 입력한 한 줄 전체를 문자열로 읽어오는 메서드이다.  
콘솔 기반 프로그램에서 사용자와 상호작용할 때 자주 사용된다.


## 5. 문자열 비교

Java에서 문자열의 내용을 비교할 때는 `==`이 아니라 `equals()`를 사용한다.  
`==`은 객체의 주소값을 비교하고, `equals()`는 문자열의 실제 내용을 비교한다.

```java
if (password.equals(password_confirm)) {
    break;
}
```

`equalsIgnoreCase()`는 대소문자를 구분하지 않고 문자열을 비교하는 메서드이다.

```java
if (register_input.equalsIgnoreCase("y")) {
    ...
}
```

이를 사용하면 사용자가 `y`, `Y`처럼 대소문자를 다르게 입력해도 같은 값으로 처리할 수 있다.



## 6. HashMap

`HashMap`은 key-value 형태로 데이터를 저장하는 자료구조이다.  
하나의 key에 하나의 value를 연결하여 저장할 수 있기 때문에 회원 정보처럼 여러 속성을 가진 데이터를 관리할 때 사용할 수 있다.

```java
HashMap user = new HashMap();

user.put("username", username);
user.put("password", password);
user.put("name", name);
user.put("birth_date", birth_date);
user.put("email", email);
```

`put()`은 데이터를 저장할 때 사용하고, `get()`은 key를 이용해 저장된 값을 가져올 때 사용한다.

```java
user.get("name");
```

즉, `HashMap`을 사용하면 하나의 회원 정보를 `username`, `password`, `name`, `birth_date`, `email`과 같은 key로 구분해서 저장할 수 있다.


## 7. 추가로 정리한 내용

현재 코드에서는 `ArrayList`와 `HashMap`을 제네릭 없이 사용하고 있다.

```java
ArrayList users = new ArrayList();
HashMap user = new HashMap();
```

Java에서는 타입 안정성을 높이기 위해 제네릭을 사용하는 것이 좋다.

```java
ArrayList<HashMap<String, String>> users = new ArrayList<>();
HashMap<String, String> user = new HashMap<>();
```

제네릭을 사용하면 리스트와 맵에 어떤 타입의 데이터가 들어가는지 명확하게 표현할 수 있다.  
또한 잘못된 타입의 데이터가 들어가는 것을 컴파일 단계에서 방지할 수 있다.

그리고 회원가입 완료 메시지에서 ID를 출력하는 부분은 다음과 같이 작성되어 있다.

```java
user.get("userr")
```

하지만 회원 ID는 `"username"`이라는 key로 저장했기 때문에 `"userr"`로 조회하면 원하는 값이 출력되지 않는다.  
따라서 다음과 같이 수정하는 것이 적절하다.

```java
user.get("username")
```