public class StringExample {
    public static void main(String[] args) {
        String str = "안녕하세요!";
        String str_2 = new String("안녕하세요!");
        String str_3 = "안녕하세요!";


        //문자열 비교
        if (str == str_2){
            System.out.println("str == str_2");

        }if (str == str_3){
            System.out.println("str == str_3");
        }
        if (str_2 == str_3){
            System.out.println("str_2 == str_3");
        }

        if(str.equals(str_2)){
            System.out.println("str.equals(str_2)");
        }

        if(str_2.equals(str_3)){
            System.out.println("str_2.equals(str_3)");
        }
        if(str.equals(str_3)){
            System.out.println("str.equals(str_3)");
        }


        //문자열 접합
        StringBuilder strBdr_1 = new StringBuilder();
        strBdr_1.append("World");

        String str_new  = strBdr_1.toString();
        System.out.println(str_new);


        //문자열 대소문자 비교
        String str_new_1 = "abc";
        String str_new_2 = "ABC";

        if(str_new_1.equalsIgnoreCase(str_new_2)){
            System.out.println("str_new_1.equalsIgnoreCase(str_new_2)");
        }

        //문자열 공백 제거
        String str_new_3 = "  Hel   lo";
        str_new_3 = str_new_3.trim();
        str_new_3 = str_new_3.replace(" ", "");
        System.out.println(str_new_3);
    }
}
