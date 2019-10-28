package chap4;

import structure.TreeNode;

import java.util.ArrayList;

/**
 * @author gutongxue
 * @date 2019/10/27 10:40
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径
 **/
public class Question34 {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<Integer> path = new ArrayList<>();
        helper(root, target, path, 0);
        return res;
    }

    /**
     *
     * @param root
     * @param target 目标和
     * @param path 当前的某条路径
     * @param currentSum 当前路径和
     */
    public void helper(TreeNode root, int target, ArrayList<Integer> path, int currentSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        currentSum += root.val;
        boolean isLeaf = root.left == null && root.right == null;
        //找到一条路径
        if (currentSum == target && isLeaf) {
            res.add(new ArrayList<>(path));
        }
        //左子节点添加到路径
        helper(root.left, target, path, currentSum);
        //右子节点添加到路径
        helper(root.right, target, path, currentSum);
        //回退，在返回父节点之前，在路径上删除当前节点
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(12);
        root.left = node2;
        root.right = node3;
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.left = node4;
        node2.right = node5;

        Question34 question34 = new Question34();
        ArrayList<ArrayList<Integer>> res = question34.findPath(root, 22);
        for (ArrayList<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
