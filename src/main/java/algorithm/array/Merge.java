package algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nizy
 * @date 2022/2/17 11:19 上午
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(i == 0 || list.get(list.size() - 1)[1] < interval[0]) {
                list.add(interval);
            } else {
                list.get(list.size() - 1)[1] = Math.max(interval[1], list.get(list.size() - 1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
