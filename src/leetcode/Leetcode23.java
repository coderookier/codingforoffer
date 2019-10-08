package leetcode;

import structure.ListNode;

/**
 * @author gutongxue
 * @date 2019/10/8 11:01
 * 合并K个递增排序的链表
 * 采用分治算法，逐一两两合并链表
 **/
public class Leetcode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        return dividedMerge(lists, 0, lists.length - 1);
    }

    /**
     * 分治核心
     * @param lists
     * @param left 需要合并的区间左
     * @param right 需要合并的区间右
     * @return
     */
    private ListNode dividedMerge(ListNode[] lists, int left, int right) {
        //合并完成
        if (left == right) {
            return lists[left];
        }
        int mid = left + ((right - left) >> 1);
        ListNode lNode = dividedMerge(lists, left, mid);
        ListNode rNode = dividedMerge(lists, mid + 1, right);
        return mergeTwoLists(lNode, rNode);
    }

    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        else if (head2 == null) {
            return head1;
        }

        ListNode mergeHead = null;
        if (head1.val < head2.val) {
            mergeHead = head1;
            mergeHead.next = mergeTwoLists(head1.next, head2);
        }
        else {
            mergeHead = head2;
            mergeHead.next = mergeTwoLists(head1, head2.next);
        }
        return mergeHead;
    }
}
