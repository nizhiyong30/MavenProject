package algorithm.string;

/**
 * @author nizy
 * @date 2022/2/16 11:37 下午
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String result = "0";

        for(int j = num2.length() - 1; j >= 0; j--) {
            int zeroNum = num2.length() - j - 1;
            String tmpResult = multiply(num1, num2.charAt(j) -'0');
            for(int k = 0; k < zeroNum; k++) {
                tmpResult += "0";
            }
            result = add(result, tmpResult);

        }
        return result;
    }

    public String multiply(String num1, int digit) {
        if(digit == 0 || num1.equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int digit_num = num1.charAt(i) - '0';
            int num = (digit_num * digit + carry) % 10;
            carry = (digit_num * digit + carry) / 10;
            sb.append(num);
        }
        if(carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public String add(String num1, String num2) {
        if(num1.equals("0")) {
            return num2;
        }
        if(num2.equals("0")) {
            return num1;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int num1_index = num1.length() - 1;
        int num2_index = num2.length() - 1;
        while(num1_index >= 0 && num2_index >= 0) {
            int num = (num1.charAt(num1_index) - '0' + num2.charAt(num2_index) - '0' + carry) % 10;
            carry =  (num1.charAt(num1_index) - '0' + num2.charAt(num2_index) - '0' + carry) / 10;
            sb.append(num);
            num1_index--;
            num2_index--;
        }
        while(num1_index >= 0) {
            int num = (num1.charAt(num1_index) - '0' + carry) % 10;
            carry =  (num1.charAt(num1_index) - '0' + carry) / 10;
            sb.append(num);
            num1_index--;

        }
        while(num2_index >= 0) {
            int num = (num2.charAt(num2_index) - '0' + carry) % 10;
            carry =  (num2.charAt(num2_index) - '0' + carry) / 10;
            sb.append(num);
            num2_index--;
        }
        if(carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        multiply.multiply("123", "456");
    }
}
