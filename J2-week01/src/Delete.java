import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Delete {
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

                } else if (cmd.equals("del")) {
                    System.out.print("삭제할 할 일의 번호 : ");
                    long id = Long.parseLong(sc.nextLine().trim());

                    boolean isRemoved = todoList.removeIf(todo -> todo.getId() == id);
                    todos.forEach(todo -> System.out.printf("%d / %s\n", todo.getId(), todo.getContent()));
                }
            }

        }
    }
}