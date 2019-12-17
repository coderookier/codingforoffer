package chapter6;

import structure.TreeNode;

/**
 * @author gutongxue
 * @date 2019/12/5 20:43
 * 二叉查找树中的第k大节点，k从1开始
 **/
public class Question54 {
    private int index = 0;
    public TreeNode getKthNode(TreeNode root, int k) {
        if (root != null) {
            //左
            TreeNode node = getKthNode(root.left, k);
            if (node != null) {
                return node;
            }
            //根
            index++;
            if (index == k) {
                return root;
            }
            //右
            node = getKthNode(root.right, k);
            if (node != null) {
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(8);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        Question54 question54 = new Question54();
        System.out.println(question54.getKthNode(root, 7).val);
    }
}
