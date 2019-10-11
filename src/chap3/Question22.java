package chap3;

import structure.ListNode;

/**
 * @author gutongxue
 * @date 2019/10/11 20:10
 * 输入一个链表，输出该链表的倒数第k个节点，本题从1开始计数
 * 注意三种特殊情况的处理: 1.输入为空
 *                       2.链表总节点小于k个
 *                       3.输入参数k为0
 **/
public class Question22 {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode firstPoint = head;
        ListNode secondPoint = head;

        //第一个指针先移动k-1步
        for (int i = 0; i < k - 1; i++) {
            if (firstPoint.next != null) {
                firstPoint = firstPoint.next;
            }
            //链表总数小于k个
            else {
                return null;
            }
        }
        //同时移动两个指针，第一个指针到达链表尾时，第二个指针到达倒数第k个节点
        while (firstPoint.next != null) {
            firstPoint = firstPoint.next;
            secondPoint = secondPoint.next;
        }
        return secondPoint;
    }
}
