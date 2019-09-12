package chap2;

/**
 * @author gutongxue
 * @date 2019/9/12 20:14
 **/

/**
 * 给定二叉树和其中的一个节点，找出中序遍历的下一个节点
 * 分类讨论给定节点
 */
class BinaryTreeNode {
    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode father;
    public BinaryTreeNode (int val) {
        this.val = val;
    }
}
public class Question8 {
    public BinaryTreeNode getNextNode(BinaryTreeNode pNode) {
        if (pNode == null) {
            return null;
        }
        BinaryTreeNode nextNode = null;
        //如果给定的节点有右子树，则其下一个节点就是该右子树的最左子节点
        if (pNode.right != null) {
            nextNode = pNode.right;
            while (nextNode.left != null) {
                nextNode = nextNode.left;
            }
        }
        //给定节点没有右子树
        else if (pNode.father != null){
            BinaryTreeNode pFather = pNode.father;
            BinaryTreeNode pCurrent = pNode;
            //给定节点是其父节点的左子节点，则其下一个节点就是其父节点
            if (pFather.left == pCurrent) {
                nextNode = pFather;
            }
            //给定节点是其父节点的右子节点，则一直指向其父节点，知道该节点是某个父节点的左子节点
            else {
                while (pFather != null && pCurrent == pFather.right) {
                    pCurrent = pFather;
                    pFather = pFather.father;
                }
                nextNode = pFather;
            }
        }
        return nextNode;
    }
}
