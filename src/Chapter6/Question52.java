package Chapter6;

import structure.ListNode;


/**
 * @author gutongxue
 * @date 2019/12/3 14:40
 * 寻找两个链表的第一个公共节点
 * 由于链表每个节点只能指向一个后继节点，所以第一个公共节点后两个链表的所有节点都是重合的
 * 时间复杂度O(m+n)
 **/
public class Question52 {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int len1 = getListLength(pHead1);
        int len2 = getListLength(pHead2);
        int lenDif = len1 - len2;

        //初始默认链表1较长，再根据判断调整
        ListNode pHeadLong = pHead1;
        ListNode pHeadShort = pHead2;

        if (len2 > len1) {
            lenDif = len2 - len1;
            pHeadLong = pHead2;
            pHeadShort = pHead1;
        }

        //较长的链表先走lenDif步
        for (int i = 0; i < lenDif; i++) {
            pHeadLong = pHeadLong.next;
        }

        //同时遍历两个链表，直到两个节点相同则退出
        while (pHeadLong != null && pHeadShort != null && pHeadLong != pHeadShort) {
            pHeadLong = pHeadLong.next;
            pHeadShort = pHeadShort.next;
        }
        ListNode firstCommonNode = pHeadLong;
        return firstCommonNode;
    }

    /**
     * 遍历得到链表的长度
     */
    private int getListLength (ListNode pHead) {
        int length = 0;
        ListNode node = pHead;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        p1.next = p2;
        p2.next = p3;
        ListNode q1 = new ListNode(4);
        ListNode q2 = new ListNode(5);
        q1.next = q2;
        ListNode node = new ListNode(6);
        ListNode node2 = new ListNode(7);
        p3.next = node;
        q2.next = node;
        node.next = node2;
        Question52 question52 = new Question52();
        ListNode commonNode = question52.findFirstCommonNode(p1, q1);
        System.out.println(commonNode.val);
    }
}
