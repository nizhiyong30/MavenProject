package algorithm.backTrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nizy
 * @date 2022/2/17 12:07 上午
 * 复原ip地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/solution/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by/
 */
public class RestoreIpAddresses {
    List<String> res = new ArrayList<>();
    Deque<String> path = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(0, s.length(), s, 0);
        return res;
    }

    public void dfs(int begin, int len, String s, int split) {
        if (begin == len) {
            if (split == 4) {
                res.add(String.join(".", path));
            }
        }
        if ((len - begin < 4 - split) || (len - begin) > 3 * (4 - split)) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (begin + i >= len) {
                break;
            }
            int ipSegment = judge(s, begin, begin + i);
            if(ipSegment != -1) {
                path.addLast(ipSegment + "");
                dfs(begin + i + 1, len, s, split + 1);
                path.removeLast();
            }
        }
    }

    public int judge(String s, int begin, int end) {
        if (end - begin + 1 > 4) {
            return -1;
        }
        if (end - begin + 1 > 1) {
            if (s.startsWith("0")) {
                return -1;
            }
        }
        int num = 0;
        for (int i = begin; i <= end; i++) {
            num = num * 10 + s.charAt(i) - '0';
        }
        if (num > 255) {
            return -1;
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        restoreIpAddresses.restoreIpAddresses(s);
    }
}
