public class ReferenceType {
    public static void main(String[] args) {
        String a = new String("Hello");
        String b = "Hello";
        String c = "Hello";

        if (a == b){
            System.out.println("a == b");
        }

        if (b == c){
            System.out.println("b == c");
        }
    }
}