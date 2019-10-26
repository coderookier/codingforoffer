package chap4;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gutongxue
 * @date 2019/10/26 14:54
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行
 **/
public class Question32_2 {
    public void print(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //当前层还需要打印的节点数
        int toBePrint = 1;
        //下一层中节点的数量
        int nextLevel = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.offer(node.left);
                nextLevel++;
            }

            if (node.right != null) {
                queue.offer(node.right);
                nextLevel++;
            }
            toBePrint--;
            if (toBePrint == 0) {
                System.out.println();
                toBePrint = nextLevel;
                nextLevel = 0;
            }
        }
    }

    public static void main(String[] args) {
        Question32_2 question32_2 = new Question32_2();
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
        question32_2.print(root);
    }
}
