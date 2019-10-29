package chap4;

import structure.TreeNode;

/**
 * @author gutongxue
 * @date 2019/10/29 15:19
 * 序列化和反序列化二叉树
 **/
public class Question37 {

    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    public void serializeHelper(TreeNode root, StringBuilder sb) {
        //节点为空，则添加"#"到序列中并返回
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    public TreeNode deserialize(String str) {
        if (str == null) {
            return null;
        }
        String[] strs = str.split(",");
        return deserializeHelper(strs);
    }

    private int i = -1;
    public TreeNode deserializeHelper(String[] strs) {
        i++;
        //节点存在
        if (!strs[i].equals("#")) {
            TreeNode node = new TreeNode(0);
            node.val = Integer.parseInt(strs[i]);
            node.left = deserializeHelper(strs);
            node.right = deserializeHelper(strs);
            return node;
        }
        //节点为null
        return null;
    }


    public static void main(String[] args) {
        Question37 question37 = new Question37();

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        TreeNode node4 = new TreeNode(4);
        node2.left = node4;
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node3.left = node5;
        node3.right = node6;

        String str = question37.serialize(root);
        TreeNode rootOfTree = question37.deserialize(str);
        question37.printPreorder(rootOfTree);
    }

    public void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        else {
            System.out.println(root.val);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }
}
