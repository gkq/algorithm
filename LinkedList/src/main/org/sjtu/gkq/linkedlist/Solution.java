package org.sjtu.gkq.linkedlist;

public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    public void deleteNode(ListNode node) {
        ListNode tmp = node.next;
        node.next = node.next.next;
        node.val = tmp.val;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head, tmp = null;
        while(p!= null) {
            tmp = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = tmp;
        }
        head.next = null;
        return dummy.next;
    }
}
