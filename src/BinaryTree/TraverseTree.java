package BinaryTree;

import java.util.Stack;

/**
 * @author gutongxue
 * @date 2020/1/31 20:19
 * 非递归方式前序、中序、后序遍历二叉树
 * 使用自己申请的数据结构内存空间来代替递归调用的函数栈，即可实现所有递归实现的非递归实现
 **/
public class TraverseTree {
    /**
     * 前序
     * @param head
     */
    public void preOrderUnRecur(TreeNode head) {
        System.out.println("pre-order: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                //弹出栈顶元素并打印
                head = stack.pop();
                System.out.print(head.value + " ");
                //压入右子节点
                if (head.right != null) {
                    stack.push(head.right);
                }
                //压入左子节点
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 中序
     * @param head
     */
    public void inOrderUnRecur(TreeNode head) {
        System.out.println("in-order: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                //一直压入左子节点
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                }
                //已输出的边界
                else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 后序
     */
    public void postOrderUnRecur(TreeNode head) {
        System.out.println("post-order: ");
        if (head != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
        }
    }
}
