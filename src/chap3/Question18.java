package chap3;

import structure.ListNode;

/**
 * @author gutongxue
 * @date 2019/10/5 19:01
 * 在O(1)时间内删除单链表的某个节点
 **/
public class Question18 {
    /**
     * 必须假设待删除的节点在链表中，才有可能在O(1)时间内删除节点，因判断节点是否在链表中需要O(n)时间
     */
    public void deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return;
        }

        //要删除的节点是不是尾节点,则把后一节点的内容覆盖此节点，此节点指向后一节点的下一节点，时间复杂度O(1)
        if (toBeDeleted.next != null) {
            ListNode nextNode = toBeDeleted.next;
            toBeDeleted.val = nextNode.val;
            toBeDeleted.next = nextNode.next;
        }
        //既是尾节点又是头节点，即链表只有一个节点，时间复杂度O(1)
        else if (head == toBeDeleted) {
            head = null;
        }
        //链表有多个节点，待删除的是尾节点，则仍需要从头顺序遍历到尾节点的前序节点，时间复杂度O(n)
        else {
            ListNode node = head;
            while (node.next != toBeDeleted) {
                node = node.next;
            }
            //删除尾节点
            node.next = null;
        }
    }
    /**
     * 平均时间复杂度[(n-1)*O(1)+O(n)]/n = O(1)
     */
}
