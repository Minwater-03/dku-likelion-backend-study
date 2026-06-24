# Week06 - Book CRUD API

## 프로젝트 소개

Spring Boot와 Spring Data JPA를 활용하여 책(Book) 정보를 관리하는 CRUD API를 구현했습니다.

책 정보는 책 이름, 가격, 저자로 구성되며, 각 책은 고유한 id를 가집니다.

## 구현 내용

### 1. Book 엔티티 구현

`Book` 엔티티를 생성하여 H2 데이터베이스의 `books` 테이블과 연결했습니다.

* `id`: 책 식별자
* `title`: 책 이름
* `price`: 가격
* `author`: 저자

### 2. Repository 구현

`BookRepository`가 `JpaRepository<Book, Long>`을 상속하도록 구현했습니다.

이를 통해 책 등록, 전체 조회, 단건 조회, 삭제 기능을 사용할 수 있도록 했습니다.

### 3. DTO 구현

요청과 응답 데이터를 분리하기 위해 DTO를 구현했습니다.

* `BookRequest`: 책 등록 및 수정 요청 데이터
* `BookResponse`: 책 조회 결과 응답 데이터

### 4. Service 구현

`BookService`에서 다음 CRUD 로직을 구현했습니다.

* 책 등록
* 책 전체 조회
* 책 단건 조회
* 책 수정
* 책 삭제

존재하지 않는 책 id를 조회, 수정, 삭제하려는 경우 `404 Not Found` 응답을 반환하도록 처리했습니다.

### 5. Controller 구현

`BookController`에서 REST API를 구현했습니다.

| 기능      | Method | URL               |
| ------- | ------ | ----------------- |
| 책 등록    | POST   | `/api/books`      |
| 책 전체 조회 | GET    | `/api/books`      |
| 책 단건 조회 | GET    | `/api/books/{id}` |
| 책 수정    | PUT    | `/api/books/{id}` |
| 책 삭제    | DELETE | `/api/books/{id}` |

## 실행 방법

```bash
cd week06
./gradlew bootRun
```

Windows PowerShell에서는 아래 명령어로 실행할 수 있습니다.

```powershell
.\gradlew.bat bootRun
```

서버는 기본적으로 `http://localhost:8080`에서 실행됩니다.

## API 시연

Postman을 사용하여 아래 순서로 CRUD API를 테스트했습니다.

1. `POST /api/books`로 책 등록
2. `GET /api/books`로 전체 책 목록 조회
3. `GET /api/books/{id}`로 특정 책 조회
4. `PUT /api/books/{id}`로 책 정보 수정
5. `DELETE /api/books/{id}`로 책 삭제
6. 삭제 후 `GET /api/books`를 다시 호출하여 삭제 결과 확인

### 등록 및 수정 요청 예시

```json
{
  "title": "스프링 부트 입문",
  "price": 25000,
  "author": "김민수"
}
```
