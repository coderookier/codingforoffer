package chap3;

import structure.ListNode;

/**
 * @author gutongxue
 * @date 2019/10/11 20:10
 * 确定链表中环的入口节点
 *
 * 1.根据快慢指针确定链表中是否有环
 * 2.遍历得到环中节点的数量
 * 3.根据环中节点数量再得到环的入口节点
 **/
public class Question23 {

    /**
     * 判断链表中是否有环，并返回两个指针相遇的节点，即环中的一个节点
     */
    public ListNode meetingNode(ListNode pHead){
        if (pHead == null) {
            return null;
        }
        //慢指针一次一步，快指针一次两步
        ListNode pSlow = pHead.next;
        if (pSlow == null) {
            return null;
        }
        ListNode pFast = pSlow.next;
        while (pFast != null && pSlow != null) {
            //快慢指针相遇
            if (pFast == pSlow) {
                return pFast;
            }
            //慢指针移动一步
            pSlow = pSlow.next;
            //快指针移动两步
            pFast = pFast.next;
            if (pFast != null) {
                pFast = pFast.next;
            }
        }
        return null;
    }

    /**
     * 确定环中节点数量，进而得到环入口节点
     */
    public ListNode entryNodeOfLoop(ListNode pHead) {
        //相遇的环中节点
        ListNode meeting = meetingNode(pHead);
        if (meeting == null) {
            return null;
        }
        //环中节点数量
        int nodesInLoop = 1;
        //滑动指针
        ListNode pNode = meeting;
        while (pNode.next != meeting) {
            pNode = pNode.next;
            nodesInLoop++;
        }

        //快慢指针初始指向头节点，快指针先移动nodesInLoop步
        pNode = pHead;
        ListNode pNode2 = pHead;
        for (int i = 0; i < nodesInLoop; i++) {
            pNode = pNode.next;
        }
        while (pNode != pNode2) {
            pNode = pNode.next;
            pNode2 = pNode2.next;
        }
        return pNode;
    }
}
