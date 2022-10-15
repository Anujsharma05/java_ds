package introduction.swap;

public class Main {
    public static void main(String[] args) {
        Num a = new Num(10);
        Num b = new Num(20);

        swap(a, b);

        System.out.println(a.num);
        System.out.println(b.num);
    }

    static void swap(Num a, Num b) {
        Num temp = a;
        a = b;
        b = temp;
    }

    static void valueSwap(Num a, Num b) {
        int temp = a.num;
        a.num = b.num;
        b.num = temp;
    }
}
