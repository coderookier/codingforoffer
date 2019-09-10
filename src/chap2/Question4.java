package chap2;

/**
 * @author gutongxue
 * @date 2019/9/6 10:22
 **/
public class Question4 {
    /**
     * 二维数组查找，是否存在某整数
     *
     * 1.首先选取右上角数字，每次删除该数所在列或者行
     */

    public boolean find(int[][] matrix, int target) {
        //输入为空
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        //当前选取的位于查找范围内的右上角数
        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
            //该右上角数字等于要查找的数字，则直接返回true，结束查找
            if (matrix[row][col] == target) {
                return true;
            }
            //该右上角数字小于要查找的数字，那么需要查找的数字一定位于此数的下面，故删除所在行
            else if (matrix[row][col] < target) {
                row++;
            }
            //该右上角数字大于要查找的数字，那么需要查找的数字一定位于此数左边，故删除所在列
            else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Question4 question4 = new Question4();
        System.out.println(question4.find(matrix, 1));
    }
}
