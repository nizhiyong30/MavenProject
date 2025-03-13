package algorithm.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nizy
 * @date 2021/4/6 5:35 下午
 */
public class PermuteUnique {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private boolean[] visit;

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        visit = new boolean[num.length];
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(num);
        backTrack(num, list);
        return result;
    }

    public void backTrack(int[] num, ArrayList<Integer> list) {
        if (list.size() == num.length) {
            ArrayList<Integer> tmpList = new ArrayList<>(list);
            result.add(tmpList);
        } else if (list.size() < num.length) {
            for (int i = 0; i < num.length; i++) {
                if (visit[i] || ((i > 0) && (num[i - 1] == num[i]) && !visit[i - 1])) {
                    continue;
                }
                list.add(num[i]);
                visit[i] = true;
                backTrack(num, list);
                visit[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}
