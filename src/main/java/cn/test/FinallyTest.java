package cn.test;

/**
 * @author nizy
 * @date 2021/2/26 11:07 上午
 */
public class FinallyTest {
    public static void main(String[] args) {
        try {
            System.out.println("1");
            try {
                String s = "";
                s.length();
            } catch (Exception e) {

            } finally {
                System.out.println("finally");
            }
        } catch (Exception e) {

        }
        System.out.println("end");
    }
}
