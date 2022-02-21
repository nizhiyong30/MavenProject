package algorithm.dfs;

/**
 * @author nizy
 * @date 2022/2/14 5:45 下午
 */
public class FindCircleNum {
    private boolean[] visit;
    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        visit = new boolean[provinces];
        int result = 0;
        for(int i = 0; i < provinces; i++) {
            if(!visit[i]) {
                dfs(isConnected, i, provinces);
                result++;
            }
        }
        return result;
    }

    public void dfs(int[][] isConnected, int i, int provinces) {
        for(int j = 0; j < provinces; j++) {
            if(isConnected[i][j] == 1 && !visit[j]) {
                visit[j] = true;
                dfs(isConnected, j, provinces);
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1,1,0},{1,1,0},{0,0,1}};
        FindCircleNum findCircleNum = new FindCircleNum();
        System.out.println(findCircleNum.findCircleNum(nums));
    }
}
