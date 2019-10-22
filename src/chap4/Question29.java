package chap4;

/**
 * @author gutongxue
 * @date 2019/10/22 20:55
 * 顺时针打印矩阵
 **/
public class Question29 {
    public void printMatrixClockwisely(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        //矩阵遍历可分解成多个外围一圈遍历
        int start = 0;
        //边界条件
        while (rows > start * 2 && cols > start * 2) {
            printMatrixInCircle(matrix, rows, cols, start);
            start++;
        }
    }

    private void printMatrixInCircle(int[][] matrix, int rows, int cols, int start) {
        //每次按圈遍历的边界点
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        //左->右
        for (int i = start; i <= endX; i++) {
            System.out.print(matrix[start][i] + ",");
        }
        //上->下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.print(matrix[i][endX] + ",");
            }
        }
        //右->左
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                System.out.print(matrix[endY][i] + ",");
            }
        }
        //下->上
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                System.out.print(matrix[i][start] + ",");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix2 = {{1,2,3,4}};
        int[][] matrix3 = {{4},{8},{12},{16}};
        int[][] matrix4 = {{1}};
        Question29 question29 = new Question29();
        question29.printMatrixClockwisely(matrix);
        System.out.println();
        question29.printMatrixClockwisely(matrix2);
        System.out.println();
        question29.printMatrixClockwisely(matrix3);
        System.out.println();
        question29.printMatrixClockwisely(matrix4);
    }
}
