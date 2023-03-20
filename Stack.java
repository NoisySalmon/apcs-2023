public class Stack {

    static void a() {
        System.out.println("a() was entered");
        b();
        System.out.println("a() is finished");
    }

    static void b() {
        System.out.println("b() was entered");
        a();
        System.out.println("b() is finished");
    }

    static void c() {
        System.out.println("c() was entered");

        System.out.println("c() is finished");
    }

    static void count(int n) {

        if (n == 1000) {
            // base case
            // STOP!
        } else {
            // recursive case
            System.out.println("" + n);
            count(n + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello, Class!");
        // a();
        try {
            count(1);
        } catch (StackOverflowError e) {
            System.out.println("overflowed");
        }
    }
}
