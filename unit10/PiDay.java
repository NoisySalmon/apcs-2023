package unit10;

public class PiDay {

  // infinite series for π
  // https://en.wikipedia.org/wiki/Pi#Rate_of_convergence
  public static double piday(int n, boolean subtract) {
    // TODO
    if (n >= 4000) {
      return 0;
    } else {
      if (subtract == true) {
        return -4.0 / n + piday(n + 2, false);
      } else {
        return 4.0 / n + piday(n + 2, true);
      }

    }
  }

  public static void main(String args[]) {
    // Gregory–Leibniz
    double pi = piday(1, false);

    // Nilakantha
    // double pi = 3.0 + piday(3, false);

    System.out.println("pi = " + pi);
  }
}