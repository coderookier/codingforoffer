package chap3;

import structure.ListNode;

/**
 * @author gutongxue
 * @date 2019/10/5 19:07
 * 给定一个排序的链表，删除重复的节点
 **/
public class Question18_2 {
    public ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = null;
        //滑动指针
        ListNode pNode = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (pNode != null) {
            ListNode nextNode = pNode.next;
            boolean needDelete = false;
            //出现重复
            if (nextNode != null && nextNode.val == pNode.val) {
                needDelete = true;
            }

            //无重复则继续滑动指针
            if (!needDelete) {
                preNode = pNode;
                pNode = pNode.next;
            }
            //出现重复则删除
            else {
                //重复值value
                int value = pNode.val;
                //需在重复节点区域滑动的指针
                ListNode toBeDeleted = pNode;
                while (toBeDeleted != null && toBeDeleted.val == value) {
                    nextNode = toBeDeleted.next;
                    //滑动重复区域指针
                    toBeDeleted = nextNode;
                }
                //头节点重复
                if (preNode == null) {
                    dummy.next = nextNode;
                }
                else {
                    preNode.next = nextNode;
                }
                //滑动原指针
                pNode = nextNode;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Question18_2 question18_2 = new Question18_2();
        ListNode resNode = question18_2.deleteDuplication(l1);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }
}
