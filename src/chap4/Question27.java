package chap4;

import structure.TreeNode;

/**
 * @author gutongxue
 * @date 2019/10/22 15:38
 * 输入一个二叉树，输出该二叉树的镜像
 * 就是调换左右子树位置
 **/
public class Question27 {
    public void mirrorRecursively(TreeNode pNode) {
        if (pNode == null) {
            return;
        }
        if (pNode.left == null && pNode.right == null) {
            return;
        }
        //交换根节点左右子树位置
        TreeNode tempNode = pNode.left;
        pNode.left = pNode.right;
        pNode.right = tempNode;
        //对子树进行相同的处理
        if (pNode.left != null) {
            mirrorRecursively(pNode.left);
        }
        if (pNode.right != null) {
            mirrorRecursively(pNode.right);
        }
    }

    //测试
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        root.left = node2;
        root.right = node3;
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        Question27 question27 = new Question27();
        question27.printPreOrder(root);
        System.out.println("--------------------------------");
        question27.mirrorRecursively(root);
        question27.printPreOrder(root);
    }

    //前序遍历
    private void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
}
