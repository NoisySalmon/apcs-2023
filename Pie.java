public class Pie {

    static int factorialIter(int n) {
        int result = 1;
        for (int i = n; i >= 1; i--) {
            result *= i;
        }
        return result;
    }

    static int factorialRec(int n) {
        // base case
        if (n == 1) {
            return 1;
        }
        // recursive case
        return n * factorialRec(n - 1);
    }

    static int fibonacci(int n) {
        System.out.println("called fib " + n);
        if (n == 1)
            return 1;
        if (n == 0)
            return 0;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static String reverse(String input) {
        // base case
        if (input.length() == 1) {
            return input;
        }
        String head = input.substring(0, 1);
        String tail = input.substring(1);
        // recursive case
        return reverse(tail) + head;

    }

    static int powerIter(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    static int power(int a, int b) {
        // base case
        if (b == 1) {
            return a;
        } else {
            int nextPower = power(a, b / 2);
            if (b % 2 == 1) {
                // b is odd, so...
                return nextPower * nextPower *a;
            } else {
                return nextPower * nextPower;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(power(2, 4));
        // System.out.println("Reverse NatWasHere:" + reverse("NatWasHere"));
        // System.out.println("Happy PiDay! " + Math.PI);
        System.out.println(power(2,16));
        System.out.println(power(2,17));
        // System.out.println("factorial(5) = " + factorialIter(5));
        // System.out.println("fibonacci(10)= " + fibonacci(10));
    }
}
