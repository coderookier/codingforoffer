package chap3;

import structure.ListNode;

/**
 * @author gutongxue
 * @date 2019/10/11 20:11
 * 输入一个链表的头节点，反转该链表并输出反转后链表的头节点
 **/
public class Question24 {
    public ListNode reverseList(ListNode pHead){
        ListNode pReverseHead = null;
        //指向当前节点
        ListNode pNode = pHead;
        //当前节点的前一个节点
        ListNode pPrev = null;
        //当前节点的下一个节点
        ListNode pNext = null;
        while (pNode != null) {
            pNext = pNode.next;

            //已遍历并反转到链表尾
            if (pNext == null) {
                pReverseHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pReverseHead;
    }

    public ListNode reverse(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode newHead = reverse(pHead.next);
        pHead.next.next = pHead;
        pHead.next = null;
        return newHead;
    }
}
