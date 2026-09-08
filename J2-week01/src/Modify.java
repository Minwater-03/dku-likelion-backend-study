import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Modify {
    private String content;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Todo(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public void run() {
        System.out.println("할 일 관리 앱, 시작");
        try (Scanner sc = new Scanner(System.in)) {
            long todoLastId = 0;
            List<Todo> todoList = new ArrayList<>();
            while (true) {
                System.out.print("명령) ");
                String cmd = sc.nextLine().trim();

                if (cmd.equals("exit")) break;
                else if (cmd.equals("add")) {
                    long id = todoLastId + 1;
                    System.out.print("할일: ");
                    String content = sc.nextLine().trim();


                    Todo todo = new Todo(id, content);
                    todos.add(todo);

                    System.out.println(todo.getContent());

                    System.out.printf("%d번 할일이 생성되었습니다.\n", id);

                }else if (cmd.equals("modify")) {
                    System.out.println("수정할 할 일의 번호 : ");
                    long id = sc.parseLong(scanner.nextLine().trim());

                    Todo foundTodo = todos.stream() Stream < Todo >
                        .filter(t -> t.getId() == id).findFirst() Optional<Todo>.orElse(null);

                    if((!isRemoved) {
                        System.out.println("%d번 할 일은 존재하지 않습니다\n", id);
                    }
                    }

                }
            }
        }
    }
}
