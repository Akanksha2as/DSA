//https://leetcode.com/problems/swapping-nodes-in-a-linked-list/submissions/1698713975/?envType=problem-list-v2&envId=linked-list
public class SwapKNodesInLinkedList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode temp = first;
        ListNode second = head;
        while (temp.next != null) {
            temp = temp.next;
            second = second.next;
        }

        int t = first.val;
        first.val = second.val;
        second.val = t;

        return head;
    }

    public static void main(String[] args) {
        SwapKNodesInLinkedList solution = new SwapKNodesInLinkedList();

        // Example: [1,2,3,4,5], k=2 => Output: [1,4,3,2,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        head = solution.swapNodes(head, k);

        // Print the list
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
