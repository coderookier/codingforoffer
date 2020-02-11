package dp;

/**
 * @author gutongxue
 * @date 2020/1/21 16:58
 * 矩阵中的最小路径和，不使用二维数组，使用压缩空间至一维数组解决，对于这种不需要输出具体路径可用
 **/
public class MinPathSum {
    public int minPathSum(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        //行数与列数中较大与较小值
        int more = Math.max(m.length, m[0].length);
        int less = Math.min(m.length, m[0].length);
        //行数是否大于等于列数
        boolean rowmore = more == m.length;
        int[] arr = new int[less];
        arr[0] = m[0][0];
        //数组初始化为第一行（行数大于列数）或者第一列（行数小于列数）
        for (int i = 1; i < less; i++) {
            arr[i] = arr[i-1] + (rowmore ? m[0][i] : m[i][0]);
        }
        for (int i = 1; i < more; i++) {
            arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);
            for (int j = 1; j < less; j++) {
                arr[j] = Math.min(arr[j-1], arr[j]) + (rowmore ? m[i][j] : m[j][i]);
            }
        }
        return arr[less - 1];
    }

    public static void main(String[] args) {
        MinPathSum mi = new MinPathSum();
        int[][] m = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        System.out.println(mi.minPathSum(m));
    }
}
