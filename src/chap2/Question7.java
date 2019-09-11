package chap2;

/**
 * @author gutongxue
 * @date 2019/9/11 19:14
 **/

import structure.TreeNode;

/**
 * 根据二叉树的前序和中序遍历结果重建二叉树
 * 根据前序遍历确定根节点位置
 * 根据中序遍历和根节点确定左右子树
 */
public class Question7 {

    /**确定根节点，左子树，右子树，然后对左右子树进行递归即可。
     * @param preOrder
     * @param inOrder
     * @return
     */
    public TreeNode constructTree(int[] preOrder, int[] inOrder) {
        //无效的输入
        if (preOrder == null || inOrder == null || preOrder.length <= 0 || inOrder.length <= 0 || preOrder.length != inOrder.length) {
            return null;
        }
        else {
            return helper(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
        }
    }

    /**
     * 递归重构二叉树
     * @param preOrder 当前递归子树的前序遍历结果
     * @param preStart
     * @param preEnd
     * @param inOrder 当前递归子树的中序遍历结果
     * @param inStart
     * @param inEnd
     * @return
     */
    public TreeNode helper(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        //根节点
        TreeNode root = new TreeNode(preOrder[preStart]);
        //中序遍历中根节点的位置
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            //在中序遍历中找到根节点
            if (inOrder[i] == preOrder[preStart]) {
                index = i;
            }
        }
        //左子树
        root.left = helper(preOrder, preStart + 1, preStart + index - inStart, inOrder, inStart, index - 1);
        //右子树
        root.right = helper(preOrder, preStart + index - inStart + 1, preEnd, inOrder, index + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        Question7 question7 = new Question7();
        int[] preOrder = new int[]{1,2,4,7,3,5,6,8};
        int[] inOrder = new int[]{4,7,2,1,5,3,8,6};
        TreeNode root = question7.constructTree(preOrder, inOrder);
        question7.prePrint(root);
        System.out.println("==================================");
        question7.inPrint(root);
    }

    /**
     * 前序遍历验证结果
     * @param root
     */
    public void prePrint(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        if (root.left != null) {
            prePrint(root.left);
        }
        if (root.right != null) {
            prePrint(root.right);
        }

    }

    /**
     * 中序遍历验证结果
     * @param root
     */
    public void inPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inPrint(root.left);
        }
        System.out.println(root.val);
        if (root.right != null) {
            inPrint(root.right);
        }
    }
}
