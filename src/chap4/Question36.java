package chap4;

import structure.TreeNode;

/**
 * @author gutongxue
 * @date 2019/10/29 15:19
 * 输入一棵二叉搜索树，将该二叉搜索树转换成为一个排序的双向链表，要求不能创建任何新的节点，只能调整节点指针的指向
 **/
public class Question36 {
    public TreeNode convert(TreeNode rootOfTree) {
        TreeNode lastNodeInList = null;
        convertNode(rootOfTree, lastNodeInList);

        //根据尾节点的左指针找到头节点并返回
        TreeNode headOfList = lastNodeInList;
        while (headOfList != null && headOfList.left != null) {
            headOfList = headOfList.left;
        }
        return headOfList;
    }

    /**
     * 转换
     */
    public void convertNode(TreeNode pNode, TreeNode lastNodeInList) {
        if (pNode == null) {
            return;
        }
        TreeNode currentNode = pNode;
        //左子树转换成排序的双向链表
        if (currentNode.left != null) {
            convertNode(currentNode.left, lastNodeInList);
        }
        //左子树与根节点连接
        currentNode.left = lastNodeInList;
        if (lastNodeInList != null) {
            lastNodeInList.right = currentNode;
        }

        //右子树转为双向链表
        lastNodeInList = currentNode;
        if (currentNode.right != null) {
            convertNode(currentNode.right, lastNodeInList);
        }
    }
}
