package leetcode.round1.greedy;

/**
 * @author nizy
 * @date 2021/11/23 2:53 下午
 */
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int i = 0;
        while(i < length) {
            int cnt = 0;
            int summaryGas = 0;
            int summaryCost = 0;
            while(cnt < length) {
                int j = (i + cnt) % length;
                summaryGas += gas[j];
                summaryCost += cost[j];
                if (summaryCost > summaryGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == length) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CanCompleteCircuit canCompleteCircuit = new CanCompleteCircuit();
        canCompleteCircuit.canCompleteCircuit(new int[]{1,2,3,4,}, new int[]{3,4,5,1,2});
    }
    
}
