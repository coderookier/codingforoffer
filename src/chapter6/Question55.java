package chapter6;

import structure.TreeNode;

/**
 * @author gutongxue
 * @date 2019/12/6 16:16
 * 55.求二叉树的深度
 * 55.2 根据深度判断是否为平衡二叉树
 **/
public class Question55 {
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左子树深度
        int left = treeDepth(root.left);
        //右子树深度
        int right = treeDepth(root.right);
        //左右子树深度较大的+1即为该树的深度
        return (left > right) ? left + 1 : right + 1;
    }

    boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int different = left - right;
        if (different > 1 || different < -1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
