package chap4;

import structure.ComplexListNode;

/**
 * @author gutongxue
 * @date 2019/10/28 20:34
 * 复杂链表的复制
 **/
public class Question35 {

    public ComplexListNode clone(ComplexListNode pHead) {
        cloneNodes(pHead);
        connectSiblingNodes(pHead);
        return reconnectNodes(pHead);
    }

    /**
     * @param pHead
     * 复制各节点，并将复制的节点连接为原节点的下一个节点
     */
    public void cloneNodes(ComplexListNode pHead) {
        //遍历指针
        ComplexListNode pNode = pHead;
        while (pNode != null) {
            //复制节点
            ComplexListNode pCloned = new ComplexListNode(pNode.value);
            pCloned.next = pNode.next;
            pCloned.sibling = null;
            //复制的节点连接到原节点后
            pNode.next = pCloned;
            //循环
            pNode = pCloned.next;
        }
    }

    /**
     * 确定复制的节点的sibling指向
     * @param pHead
     */
    public void connectSiblingNodes(ComplexListNode pHead) {
        //遍历指针
        ComplexListNode pNode = pHead;
        while (pNode != null) {
            ComplexListNode pCloned = pNode.next;
            //根据原节点的sibling确定复制节点的sibling
            if (pNode.sibling != null) {
                pCloned.sibling = pNode.sibling.next;
            }
            pNode = pCloned.next;
        }
    }

    //将原节点与复制节点分离并分别连接，返回复制链
    public ComplexListNode reconnectNodes(ComplexListNode pHead) {
        //滑动指针
        ComplexListNode pNode = pHead;
        //复制链表的头节点
        ComplexListNode pClonedHead = null;
        //滑动指针
        ComplexListNode pClonedNode = null;

        if (pNode != null) {
            pClonedHead = pClonedNode = pNode.next;
            pNode.next = pClonedHead.next;
            pNode = pNode.next;
        }

        while (pNode != null) {
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedHead.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        return pClonedHead;
    }
}
