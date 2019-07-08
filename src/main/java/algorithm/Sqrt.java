package algorithm;

public class Sqrt {
    public static double solution() {
        double low = 1.4;
        double high = 1.5;
        double mid = (1.4 + 1.5) / 2;
        double exp = 0.000000001;
        while (high - low > exp) {
            if (mid * mid < 2) {
                low = mid;
            } else {
                high = mid;
            }
            mid = (low + high) /2;
        }
        System.out.println(mid);
        System.out.println(mid * mid);
        return mid;
    }

    public static void main(String[] args) {
        solution();
    }
}
