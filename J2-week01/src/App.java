import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("할 일 관리 앱, 시작");
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            System.out.printf("입력한 명령: %s\n", cmd);
        }
        System.out.println("할 일 관리 앱, 끝");
    }

}
