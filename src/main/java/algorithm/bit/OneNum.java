package algorithm.bit;

public class OneNum {
    public static void solution(int i) {
        int result = 0;
        while (i != 0) {
            result++;
            i = i & (i-1);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        solution(15);
    }
}
