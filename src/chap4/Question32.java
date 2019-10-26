package chap4;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gutongxue
 * @date 2019/10/26 11:55
 * 从上到下打印二叉树的每个节点，同一层的节点按照从左到右顺序打印
 **/
public class Question32 {

    /**
     * 将节点放入队列中,弹出并打印队列头部节点，如果该节点有子节点，则将左右节点按顺序压入队列
     */

    public void printFromTopToBottom(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Question32 question32 = new Question32();
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

        question32.printFromTopToBottom(root);
    }
}
