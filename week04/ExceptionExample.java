import java.util.ArrayList;

public class ExceptionExample {
    public static void main(String[] args) {
        // 예외
//        int a = 10;
//        int b = 0;

        //int c = a/b; -> 자바가 예측 가능했던 에러

        ArrayList arrayList = new ArrayList(3);
        try{
            int a =10;
            int b = 0;
            int c = a/ b;
        }
        catch(IndexOutOfBoundsException ioe){
            System.out.println("IndexOutOfBoundsException 발생");
        }
        catch(IllegalArgumentException iae){
            System.out.println("IllegalArgumentException 발생");
        }
        catch(Exception e){
            System.out.println("Exception 발생");
        }finally{
            System.out.println("finally");
        }
    }
}
