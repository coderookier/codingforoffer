package chap4;

import structure.TreeNode;

/**
 * @author gutongxue
 * @date 2019/10/22 19:10
 * 判断一棵二叉树是不是对称的
 * 根->左->右遍历与根->右->左遍历相同时，则对称
 **/
public class Question28 {

    public boolean isSymmetrical(TreeNode pRoot){
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }
        if (pRoot1 == null || pRoot2 == null) {
            return false;
        }
        if (pRoot1.val != pRoot2.val) {
            return false;
        }
        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(6);
        root.left = node2;
        root.right = node3;
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(5);
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        Question28 question28 = new Question28();
        System.out.println(question28.isSymmetrical(root));
    }
}
