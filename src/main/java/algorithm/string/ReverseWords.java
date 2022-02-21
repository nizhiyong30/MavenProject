package algorithm.string;

/**
 * @author nizy
 * @date 2021/12/19 11:08 上午
 */
public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        s = s.trim();
        int start = s.length() - 1;
        int end = s.length();
        while (start >= 0) {
            if (s.charAt(start) == ' ') {
                if (start + 1 != end) {
                    result.append(s.substring(start + 1, end));
                    result.append(" ");
                }
                end = start;
            }
            start--;
        }
        result.append(s.substring(start + 1, end));
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        ReverseWords reverseWords = new ReverseWords();
        String result = reverseWords.reverseWords(s);
        System.out.println(result);
    }
}
