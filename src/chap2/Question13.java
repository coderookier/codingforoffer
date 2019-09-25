package chap2;

/**
 * @author gutongxue
 * @date 2019/9/25 19:46
 * 机器人能到达多个格子。每次可以像左、右、上、下移动一格，但是该点坐标的数位之和不能大于k
 **/
public class Question13 {

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        boolean[] visited = new boolean[rows * cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    /**
     * 记录可以到达的格子数
     */
    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    /**
     * 判断能否进入该点
     */
    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && getDigitSum(row) + getDigitSum(col) <= threshold) {
            return true;
        }
        return false;
    }

    /**
     * 获取数字的各位之和
     */
    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Question13 question13 = new Question13();
        System.out.println(question13.movingCount(4,3, 4));
    }
}
