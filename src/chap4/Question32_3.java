package chap4;

import structure.TreeNode;

import java.util.Stack;

/**
 * @author gutongxue
 * @date 2019/10/26 19:49
 * 之字形打印二叉树
 * 第一行从左到右，第二行从右到左，以此类推
 **/
public class Question32_3 {
    /**
     * 符合先进后出，用栈实现
     */
    public void print(TreeNode root) {
        if (root == null) {
            return;
        }

        //两个栈，打印一个栈中节点时，子节点存放到另一个节点中
        Stack<TreeNode>[] levels = new Stack[2];
        levels[0] = new Stack<TreeNode>();
        levels[1] = new Stack<TreeNode>();

        //两个标识用来轮换两个栈
        int current = 0;
        int next = 1;

        levels[current].push(root);
        while (!levels[0].isEmpty() || !levels[1].isEmpty()) {
            TreeNode node = levels[current].pop();
            System.out.print(node.val + " ");

            //子节点从左到右放入另一个栈中
            if (current == 0) {
                if (node.left != null) {
                    levels[next].push(node.left);
                }
                if (node.right != null) {
                    levels[next].push(node.right);
                }
            }
            //子节点从右到左放入另一个栈中
            else {
                if (node.right != null) {
                    levels[next].push(node.right);
                }
                if (node.left != null) {
                    levels[next].push(node.left);
                }
            }
            if (levels[current].isEmpty()) {
                System.out.println();
                current = 1 - current;
                next = 1 - next;
            }
        }
    }

    public static void main(String[] args) {
        Question32_3 question32_3 = new Question32_3();
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
        question32_3.print(root);
    }
}
