# IntelliJ IDEA Java 주요 자동완성 약어 정리

IntelliJ IDEA에서는 자주 사용하는 Java 코드 구조를 짧은 약어로 자동완성할 수 있다.  
약어를 입력한 뒤 `Tab` 또는 `Enter`를 누르면 코드가 자동으로 생성된다.

---

## 1. 주로 쓰이는 약어

| 약어 | 생성되는 코드 | 설명 |
| --- | --- | --- |
| `psvm` | `public static void main(String[] args)` | Java 프로그램의 main 메서드 생성 |
| `main` | `public static void main(String[] args)` | main 메서드 생성 |
| `sout` | `System.out.println();` | 콘솔 출력문 생성 |
| `serr` | `System.err.println();` | 에러 출력문 생성 |

### 예시

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Java!");
    }
}
```

---

## 2. 기본 자료형(primtive) vs 참조 자료형

- `int`, `double` → 값 자체 저장
- `String` → Heap 메모리 객체 주소 참조  

## 3. float와 double의 표현 가능 자리수

Java의 실수형 타입은 `float`와 `double`이 있다.

| 타입 | 크기 | 표현 가능한 정밀도 |
| --- | --- | --- |
| `float` | 4바이트 | 약 7자리 |
| `double` | 8바이트 | 약 15자리 |

실수형은 정수를 저장하듯이 값을 그대로 저장하지 않고, **부호부 + 지수부 + 가수부**로 나누어 저장한다.

```text
실수 = 부호 × 가수 × 2의 지수
```

여기서 실제 숫자의 정밀도를 결정하는 부분은 **가수부**이다.

```text
float  → 가수부 약 24비트 → 10진수 약 7자리 정밀도
double → 가수부 약 53비트 → 10진수 약 15자리 정밀도
```

따라서 `double`은 8바이트를 사용하지만, 그 8바이트 전체를 숫자 자리수 저장에 쓰는 것이 아니다.  
일부는 부호와 지수를 저장하는 데 사용되고, 나머지 가수부가 실제 정밀도를 결정한다.

또한 컴퓨터는 실수를 2진수로 저장하기 때문에 `0.1` 같은 일부 10진수 실수는 정확히 표현할 수 없다.  
그래서 `float`, `double`은 정확한 값이 아니라 **근삿값**을 저장한다.

정리하면 다음과 같다.

```text
float와 double의 자리수 차이 = 가수부 비트 수 차이
실수형의 오차 발생 이유 = 10진수 실수를 2진수로 근사 저장하기 때문
```

## 4. 참조형
- 참조형 데이터의 값 => 힙 메모리 영역
- 변수에 대입되는 값 => 힙 메모리 영역의 주소값

`String`은 참조 자료형이므로 변수에는 문자열 값이 아니라 **객체의 주소값**이 저장된다.

```text
new String("Hello") → Heap에 새로운 객체 생성
"Hello" → String Pool에 저장된 객체 사용
```

`String b = "Hello";`와 `String c = "Hello";`는 같은 문자열 리터럴이므로 **String Pool의 같은 객체**를 참조한다.

```text
a → Heap의 "Hello"
b, c → String Pool의 같은 "Hello"
```

`==`는 주소 비교, `equals()`는 내용 비교이다.

```text
a == b → false
b == c → true
a.equals(b) → true
```

## 5. 형변환
```text
형변환 우선 순위: byte < short < int < long <<< float < double
```
- 작은 타입에서 큰 타입으로 변환될 때는 자동 형변환이 일어난다.

```java
int a = 10;
double b = a; // int → double
```

- 큰 타입에서 작은 타입으로 변환할 때는 강제 형변환이 필요하다.

```java
double x = 3.14;
int y = (int) x; // double → int
```

- 강제 형변환을 하면 데이터 손실이 발생할 수 있다.

```text
3.14 → 3
```

```text
자동 형변환: 작은 타입 → 큰 타입
강제 형변환: 큰 타입 → 작은 타입
```

## 6. String

- `String` => 문자열 객체
- 객체 => 힙 메모리 영역에 저장
- 변수 => 힙 메모리 영역의 주소 참조
- `String`은 한 번 생성되면 내용이 바뀌지 않는 불변 객체

---

### 문자열 접합

- `+` 연산자: 간단한 문자열 연결에 사용
- `StringBuilder`: 문자열을 여러 번 연결할 때 효율적
- `append()`: `StringBuilder`에 문자열을 추가할 때 사용

```text
+ 연산자 → 간단한 문자열 연결
StringBuilder → 반복적인 문자열 연결에 적합
```

---

### 대소문자 구분 없이 비교

- `equals()`: 대소문자를 구분하여 비교
- `equalsIgnoreCase()`: 대소문자를 구분하지 않고 비교

```text
equals() → 대소문자 구분
equalsIgnoreCase() → 대소문자 구분 안 함
```

---

### 문자열 변경

- `replace()`: 문자열 안의 특정 값을 다른 값으로 변경
- `String`은 불변 객체이므로 원본 문자열이 직접 바뀌는 것이 아니라, 변경된 새로운 문자열이 생성된다.

```text
replace("기존값", "새값")
```

---

### 공백 제거

- `trim()`: 문자열 앞뒤 공백 제거
- 문자열 중간의 공백은 제거하지 않는다.

```text
trim() → 앞뒤 공백 제거
```

## 7. 배열, 리스트, Map

### 배열

- 같은 타입의 데이터를 여러 개 저장한다.
- 처음 생성할 때 크기가 고정된다.
- 인덱스로 값에 접근한다.

```text
배열 → 크기 고정, 인덱스 사용
```

---

### 리스트

- 데이터를 순서대로 저장한다.
- 크기가 고정되지 않아 추가, 삭제가 쉽다.
- Java에서는 주로 `ArrayList`를 사용한다.

```text
리스트 → 크기 변경 가능, 인덱스 사용
```

---

### Map

- 데이터를 `key`와 `value` 형태로 저장한다.
- 인덱스가 아니라 `key`를 사용해서 값에 접근한다.
- Java에서는 주로 `HashMap`을 사용한다.

```text
Map → key-value 구조, key로 값 접근
```

---

### 핵심 차이

| 구분 | 배열 | 리스트 | Map |
| --- | --- | --- | --- |
| 구조 | 값들을 순서대로 저장 | 값들을 순서대로 저장 | key-value 쌍으로 저장 |
| 크기 | 고정 | 변경 가능 | 변경 가능 |
| 접근 방식 | 인덱스 | 인덱스 | key |
| 값 추가 | 불편 | `add()` | `put()` |
| 값 조회 | `arr[0]` | `list.get(0)` | `map.get(key)` |
| 대표 예시 | `int[]` | `ArrayList` | `HashMap` |






