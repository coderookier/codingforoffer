package chap4;

/**
 * @author gutongxue
 * @date 2019/10/26 21:00
 * 输入一个整数数组，判断该数组是不是某个二叉搜索树的后续遍历
 **/
public class Question33 {
    boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        if (sequence == null || end < start) {
            return false;
        }
        //根节点
        int root = sequence[end];
        //左子树遍历滑动指针
        int i = 0;
        //确定左子树节点
        for (; i < end; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        //右子树滑动指针
        int j = i;
        for (; j < end; j++) {
            //右子树中存在小于根节点的点，则直接返回false
            if (sequence[j] < root) {
                return false;
            }
        }

        //判断左子树是否为二叉搜索树
        boolean left = true;
        if (i > 0) {
            left = verifySequenceOfBST(sequence, 0, i - 1);
        }

        //判断右子树是否为二叉搜索树
        boolean right = true;
        if (i < end) {
            right = verifySequenceOfBST(sequence, i, end - 1);
        }
        return left && right;
    }

    public static void main(String[] args) {
        int[] sequence = {5,7,6,9,11,10,8};
        int[] sequence2 = {7,4,6,5};
        Question33 question33 = new Question33();
        System.out.println(question33.verifySequenceOfBST(sequence, 0, sequence.length - 1));
        System.out.println(question33.verifySequenceOfBST(sequence2, 0, sequence2.length - 1));
    }
}
