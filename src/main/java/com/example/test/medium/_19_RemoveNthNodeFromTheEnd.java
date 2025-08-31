package com.example.test.medium;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 30/08/2025 5:50 PM
 */

public class _19_RemoveNthNodeFromTheEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;    //1 from the last
        ListNode delayN = head; //n+1 from the last

        int i = 0;
        //move end (n) steps forward
        while (i < n && end.next != null) {
            end = end.next;
            i++;
        }

        if (i == n-1) {
            head = head.next;
            return head;
        } else if (i < n-1){    //size < n
            return head;
        }
        //move both to the end
        while (end.next != null) {
            end = end.next;
            delayN = delayN.next;
        }

            delayN.next = delayN.next.next;

        return head;
    }

    public static void main(String[] args) {
        _19_RemoveNthNodeFromTheEnd i = new _19_RemoveNthNodeFromTheEnd();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(i.removeNthFromEnd(head, 2));

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        System.out.println(i.removeNthFromEnd(head, 1));
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
