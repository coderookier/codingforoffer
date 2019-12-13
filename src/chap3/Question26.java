package chap3;

import structure.BinaryTreeNode;

/**
 * @author gutongxue
 * @date 2019/10/15 19:51
 * 输入两棵二叉树A和B，判断B是不是A的子结构
 **/
public class Question26 {

    /**
     * 1.遍历查找树A中是否存在与树B根节点一样的节点
     * 2.存在则继续判断以该节点为根节点的子树结果与树B结构是否相同
     */
    public boolean hashSubTree(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        boolean result = false;
        if (pRoot1 != null && pRoot2 != null) {
            if (equal(pRoot1.value, pRoot2.value)) {
                result = doesTree1HaveTree2(pRoot1, pRoot2);
            }
            if (!result) {
                result = hashSubTree(pRoot1.left, pRoot2);
            }
            if (!result) {
                result = hashSubTree(pRoot1.right, pRoot2);
            }
        }
        return result;
    }

    /**
     * 由于计算内表示小数时存在误差，因此不能直接写pRoot1.value == pRoot2.value
     * 规定两个小数绝对值相差很小时，则两个小数相等
     */
    boolean equal(double num1, double num2) {
        return (num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001);
    }

    public boolean doesTree1HaveTree2(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        //匹配
        if (pRoot2 == null) {
            return true;
        }
        if (pRoot1 == null) {
            return false;
        }
        if (!equal(pRoot1.value, pRoot2.value)) {
            return false;
        }
        return doesTree1HaveTree2(pRoot1.left, pRoot2.left) && doesTree1HaveTree2(pRoot1.right, pRoot2.right);
    }
    public static void main(String[] args) {
        Question26 question26 = new Question26();
        BinaryTreeNode pRoot1 = new BinaryTreeNode(1);
        BinaryTreeNode node1_2 = new BinaryTreeNode(2);
        pRoot1.left = node1_2;
        BinaryTreeNode node1_3 = new BinaryTreeNode(3);
        pRoot1.right = node1_3;
        BinaryTreeNode node1_4 = new BinaryTreeNode(4);
        node1_2.left = node1_4;
        BinaryTreeNode node1_5 = new BinaryTreeNode(5);
        node1_2.right = node1_5;

        BinaryTreeNode pRoot2 = new BinaryTreeNode(2);
        BinaryTreeNode pRoot2_2 = new BinaryTreeNode(4);
        BinaryTreeNode pRoot2_3 = new BinaryTreeNode(5);
        pRoot2.left = pRoot2_2;
        pRoot2.right = pRoot2_3;
        System.out.println(question26.hashSubTree(pRoot1, pRoot2));
    }
}
