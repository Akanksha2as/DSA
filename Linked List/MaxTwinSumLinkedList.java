//https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/submissions/1699627547/?envType=problem-list-v2&envId=linked-list
public class MaxTwinSumLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public int pairSum(ListNode head) {
     
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        int maxSum = 0;
        ListNode first = head, second = prev;
        while (second != null) {
            maxSum = Math.max(maxSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaxTwinSumLinkedList solution = new MaxTwinSumLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        int result = solution.pairSum(head);
        System.out.println("Maximum Twin Sum: " + result);
    }
}
