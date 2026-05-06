public class TypeCasting {
    public static void main(String[] args) {
        int a = 128;
        //short b = a; 안됨
        short b = (short) a;
        byte c = (byte) a;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        short x  = 10;
        int y = x;

        System.out.println(x);
        System.out.println(y);

        double d = 10.21421124123;
        float e = (float) d;
        System.out.println(d);
        System.out.println(e);

        int f = 10;
        short g = 20;

        short h = (short)(f+g);
        System.out.println(h);
    }
}
