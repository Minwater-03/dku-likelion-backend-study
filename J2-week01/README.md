# 📝 CRUD 할 일 관리 서비스 학습 정리

할 일 관리 서비스를 직접 구현하면서 새롭게 알게 된 Java 문법과 Spring Controller 관련 내용을 정리했습니다.

---

## 1. 배열보다 List를 사용하는 이유

여러 개의 할 일(`Todo`)을 저장해야 할 때 배열을 사용할 수도 있습니다.

```java
Todo[] todos;
```

하지만 배열은 생성할 때 크기를 정해야 하기 때문에 저장할 데이터의 개수를 미리 알고 있어야 합니다.

할 일 관리 서비스에서는 사용자가 몇 개의 할 일을 추가할지 알 수 없기 때문에 `List`를 사용하는 것이 더 적합합니다.

```java
List<Todo> todos;
```

`List`는 필요에 따라 요소를 추가하거나 삭제할 수 있습니다.

```java
todos.add(todo);
todos.remove(todo);
```

### 정리

- `Todo[]` : 크기가 고정되어 있음
- `List<Todo>` : 크기를 동적으로 변경할 수 있음
- 저장될 데이터의 개수를 미리 알 수 없는 경우 `List`를 사용하는 것이 편리함

---

## 2. 향상된 for문

리스트에 저장된 모든 요소를 하나씩 확인할 때 향상된 `for`문을 사용할 수 있습니다.

```java
for (Todo todo : todos) {
    // 반복해서 실행할 코드
}
```

`todos`에 들어 있는 `Todo` 객체를 처음부터 하나씩 꺼내 `todo` 변수에 저장하면서 반복합니다.

예를 들어 `todos`에 3개의 할 일이 있다면 반복문 내부의 코드도 3번 실행됩니다.

```java
for (Todo todo : todos) {
    System.out.println(todo);
}
```

기존 for문처럼 인덱스를 직접 관리하지 않아도 되기 때문에 리스트의 모든 요소를 조회할 때 편리합니다.

---

## 3. `List.removeIf()`

리스트에서 특정 조건을 만족하는 요소를 삭제할 때 `removeIf()`를 사용할 수 있습니다.

```java
todos.removeIf(todo -> 조건식);
```

조건식의 결과가 `true`인 요소가 리스트에서 제거됩니다.

예를 들어 특정 ID를 가진 할 일을 삭제한다면 다음과 같이 사용할 수 있습니다.

```java
todos.removeIf(todo -> todo.getId() == id);
```

동작 과정은 다음과 같습니다.

```text
Todo 요소 확인
      ↓
조건식 검사
      ↓
true  → 삭제
false → 유지
```

반복문을 직접 작성해서 삭제할 요소를 찾는 것보다 간결하게 표현할 수 있다는 점을 알게 되었습니다.

---

## 4. Stream을 이용해 특정 요소 찾기

리스트에서 특정 조건을 만족하는 객체 하나를 찾기 위해 `Stream`을 사용할 수 있습니다.

```java
todos.stream()
        .filter(todo -> 조건식)
        .findFirst()
        .orElse(null);
```

각 메서드의 역할은 다음과 같습니다.

### `stream()`

```java
todos.stream()
```

리스트의 요소들을 순서대로 처리할 수 있도록 Stream으로 변환합니다.

### `filter()`

```java
.filter(todo -> todo.getId() == id)
```

조건식이 `true`인 요소만 남깁니다.

### `findFirst()`

```java
.findFirst()
```

조건을 만족하는 요소 중 첫 번째 요소를 가져옵니다.

### `orElse(null)`

```java
.orElse(null)
```

조건을 만족하는 객체가 존재하면 해당 객체를 반환하고, 존재하지 않는다면 `null`을 반환합니다.

따라서 다음 코드는

```java
Todo todo = todos.stream()
        .filter(t -> t.getId() == id)
        .findFirst()
        .orElse(null);
```

`id`가 일치하는 `Todo` 객체 하나를 찾는 코드라고 이해할 수 있습니다.

---

## 5. Controller 클래스

Spring에서 **Controller는 클라이언트의 HTTP 요청을 가장 먼저 받아 처리하는 클래스**입니다.

예를 들어 사용자가

```text
GET /todos
```

라는 요청을 보내면 Controller가 해당 요청을 받아 적절한 코드를 실행합니다.

```java
@RestController
public class TodoController {

}
```

`@RestController`를 사용하면 해당 클래스가 HTTP 요청을 처리하는 Controller임을 Spring에게 알려줄 수 있습니다.

### 주요 HTTP 요청

CRUD 기능은 주로 다음 HTTP Method와 연결됩니다.

| 기능 | HTTP Method | 예시 |
| --- | --- | --- |
| Create | POST | 할 일 추가 |
| Read | GET | 할 일 조회 |
| Update | PUT / PATCH | 할 일 수정 |
| Delete | DELETE | 할 일 삭제 |

예를 들어 할 일 전체 조회는 다음과 같이 작성할 수 있습니다.

```java
@GetMapping("/todos")
public List<Todo> getTodos() {
    return todos;
}
```

할 일을 추가한다면 다음과 같이 작성할 수 있습니다.

```java
@PostMapping("/todos")
public Todo createTodo(@RequestBody Todo todo) {
    todos.add(todo);
    return todo;
}
```

특정 ID의 할 일을 조회할 때는 `@PathVariable`을 사용할 수 있습니다.

```java
@GetMapping("/todos/{id}")
public Todo getTodo(@PathVariable Long id) {
    return todos.stream()
            .filter(todo -> todo.getId().equals(id))
            .findFirst()
            .orElse(null);
}
```

URL의 `{id}` 부분에 들어온 값을 Java 변수 `id`로 받아 사용할 수 있습니다.

```text
GET /todos/1

        ↓

@PathVariable Long id

        ↓

id = 1
```

요청 데이터를 객체로 전달받을 때는 `@RequestBody`를 사용할 수 있습니다.

```java
@PostMapping("/todos")
public Todo createTodo(@RequestBody Todo todo) {
    todos.add(todo);
    return todo;
}
```

클라이언트가 JSON 형태로 데이터를 보내면 Spring이 이를 `Todo` 객체로 변환해서 전달해 줍니다.

---

## 6. 이번 실습에서 새롭게 알게 된 점

이번 CRUD 할 일 관리 서비스 실습을 통해 다음 내용을 새롭게 학습했습니다.

- 저장할 객체의 개수를 미리 알 수 없는 경우 배열보다 `List`를 사용하는 것이 적합하다는 점
- 향상된 `for`문을 이용해 리스트의 요소를 하나씩 순회하는 방법
- `removeIf()`를 이용해 조건을 만족하는 리스트 요소를 간단하게 삭제하는 방법
- `stream()`, `filter()`, `findFirst()`, `orElse()`를 조합해 원하는 객체를 찾는 방법
- Controller가 HTTP 요청을 받아 CRUD 기능과 연결하는 역할을 한다는 점
- `@GetMapping`, `@PostMapping`, `@PathVariable`, `@RequestBody` 등의 기본적인 Controller 사용 방법 -