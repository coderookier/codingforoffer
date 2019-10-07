package chap3;

import structure.ListNode;

/**
 * @author gutongxue
 * @date 2019/10/7 16:17
 * 合并两个递增排序的链表
 **/
public class Question25 {
    public ListNode merge(ListNode head1, ListNode head2) {
        //输入空链表
        if (head1 == null) {
            return head2;
        }
        else if (head2 == null) {
            return head1;
        }

        ListNode mergeHead = null;
        //递归
        if (head1.val < head2.val) {
            mergeHead = head1;
            mergeHead.next = merge(head1.next, head2);
        }
        else {
            mergeHead = head2;
            mergeHead.next = merge(head1, head2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        Question25 question25 = new Question25();
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode head2 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(8);
        head2.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode mergeNode = null;
        mergeNode = question25.merge(head1, head2);
        while (mergeNode != null) {
            System.out.println(mergeNode.val);
            mergeNode = mergeNode.next;
        }
    }
}
