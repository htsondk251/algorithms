package com.example.test.medium;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 30/08/2025 5:50 PM
 */

public class _19_RemoveNthNodeFromTheEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode end = dummy;    //0 from the last
        ListNode delayNPlus1 = dummy; //n+1 from the last

        //move end pointer n steps forward
        for (int j = 0; j <= n; j++) {
            if (end != null) {
                end = end.next;
            } else {
                return head;
            }
        }
        //move both to the end
        while (end != null) {
            end = end.next;
            delayNPlus1 = delayNPlus1.next;
        }

        delayNPlus1.next = delayNPlus1.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        _19_RemoveNthNodeFromTheEnd i = new _19_RemoveNthNodeFromTheEnd();
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        System.out.println(i.removeNthFromEnd(head, 2));

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(i.removeNthFromEnd(head, 2));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
