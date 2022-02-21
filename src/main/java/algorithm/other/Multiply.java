package algorithm.other;

/**
 * 字符串相乘
 * @author nizy
 * @date 2021/4/7 3:13 下午
 */
public class Multiply {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存计算结果
        String res = "0";

        // num2 逐位与 num1 相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            // 保存 num2 第i位数字与 num1 相乘的结果
            StringBuilder temp = new StringBuilder();
            // 补 0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            int n2 = num2.charAt(i) - '0';

            // num2 的第 i 位数字 n2 与 num1 相乘
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            // 将当前结果与新计算的结果求和作为新的结果
            res = addStrings(res, temp.reverse().toString());
        }
        return res;
    }

    private String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String result = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < num2.length() - i - 1; j++) {
                sb.append("0");
            }
            int n2 = num2.charAt(i) - '0';
            int carry = 0;
            for (int k = num1.length() - 1; k >= 0; k--) {
                int n1 = num1.charAt(k) - '0';
                int n = n1 * n2 + carry;
                carry = n / 10;
                n = n % 10;
                sb.append(n);
            }
            if (carry > 0) {
                sb.append(carry);
            }
            result = addStrings(result, sb.reverse().toString());
        }
        return result;
    }

    /**
     * 对两个字符串数字进行相加，返回字符串形式的和
     */
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        System.out.println(multiply.multiply1("9", "99"));
    }
}
