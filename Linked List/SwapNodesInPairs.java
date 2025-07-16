//https://leetcode.com/problems/swap-nodes-in-pairs/submissions/1699619875/?envType=problem-list-v2&envId=linked-list
public class SwapNodesInPairs {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode newHead = head.next;

        head.next = swapPairs(head.next.next);

        newHead.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        SwapNodesInPairs solution = new SwapNodesInPairs();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode result = solution.swapPairs(head);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
