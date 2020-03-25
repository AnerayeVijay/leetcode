package fb;

import fb.helper.ListNode;
import fb.helper.TreeNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * 2->1
 * Current is 1
 * previous =2
 * next 1;
 */
public class ReverseNodesIn_K_Group {
    //
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        int count =0;

        while(k<count && current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }

        if (next != null && count ==k)
            head.next = reverseKGroup(next, k);
        return previous;

    }

    public static void main(String[] args) {

    }
}
