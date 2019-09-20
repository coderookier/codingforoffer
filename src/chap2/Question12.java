package chap2;

/**
 * @author gutongxue
 * @date 2019/9/20 15:00
 *
 * 判断一个矩阵中是否存在一条包含给定字符串的路径
 *
 **/
public class Question12 {

    boolean hasPath(char[][] matrix, String str) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0 || str == null) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        //由于不能重复进入矩阵的某点，因此定义一个与矩阵大小一样的布尔值矩阵，用来标识这点是否已经进入，已访问则为true
        boolean[][] visited = new boolean[rows][cols];
        //当前已匹配的路径长度
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, str, rows, cols, row, col, visited, count)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean hasPathCore(char[][] matrix, String str, int rows, int cols, int row, int col, boolean[][] visited, int count) {
        //所有字符均匹配
        if (count == str.length()) {
            return true;
        }
        //当前点是否匹配
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row][col] == str.charAt(count) && !visited[row][col]) {
            count++;
            visited[row][col] = true;
            hasPath = hasPathCore(matrix, str, rows, cols, row, col - 1, visited, count)
                    || hasPathCore(matrix, str, rows, cols, row - 1, col, visited, count)
                    || hasPathCore(matrix, str, rows, cols, row, col + 1, visited, count)
                    || hasPathCore(matrix, str, rows, cols, row + 1, col, visited, count);
            if (!hasPath) {
                count--;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
        String str = "bfce";
        String str2 = "abfb";
        Question12 question12 = new Question12();
        System.out.println(question12.hasPath(matrix, str));
        System.out.println(question12.hasPath(matrix, str2));
    }
}
