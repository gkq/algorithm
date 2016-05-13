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

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode p = head, left = odd, right = even;
       int i = 1;
        while(p!=null){
            if(i%2!=0){
                left.next = p;
                left = left.next;
            }
            else{
                right.next = p;
                right = right.next;
            }
            p = p.next;
            i++;
        }
        left.next = even.next;
        right.next = null;
        return odd.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode res = null;
        if(head.val != head.next.val) {
            res = head;
            res.next = deleteDuplicates(head.next);
        }
        else {
            res = deleteDuplicates(head.next);
        }
        return res;
    }

    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)
            return false;
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast)
                return true;
        }
        return false;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1), res = result;
        while(l1!=null && l2!=null) {
            if(l1.val<l2.val){
                res.next = l1;
                l1 = l1.next;
            }
            else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        while(l1!=null){
            res.next = l1;
            l1 = l1.next;
            res = res.next;
        }
        while(l2!=null){
            res.next = l2;
            l2 = l2.next;
            res = res.next;
        }
        return result.next;
    }

    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode res = new ListNode(-1),  prev = res, cur = head, next =null;
        res.next = cur;
        while(cur!= null && cur.next!=null) {
            next = cur.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
            prev = cur;
            cur = cur.next;
        }
        return res.next;
    }

    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)
            return null;
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast){
                ListNode slow2 = head;
                while(slow2!=slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        int a = 0, b = 0;
        ListNode p = headA, q = headB;
        while(p!=null){
            a++;
            p = p.next;
        }
        while(q!=null){
            b++;
            q = q.next;
        }
        p = headA; q = headB;
        if(a>b){
            for(int i=a-b; i>0; i--)
                p = p.next;
        }
        else
            for(int i=b-a; i>0; i--)
                q = q.next;
        while(p!=q && p!=null && q!=null){
            p = p.next;
            q = q.next;
        }
        if(p!=null && q!=null)
            return p;
        else
            return null;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null)
            return null;
        int len = 0;
        ListNode p = head;
        while(p!=null){
            len++;
            p = p.next;
        }

        int k = len - n%len;
        if(n==len) k = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        p = dummy;
        while(k>0){
            k--;
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}
