import java.util.HashMap;

public class MapsExample {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap();
        map.put("age", "30");
        map.put("mbti", "INFP");

        System.out.println(map.get("age"));
    }
}
