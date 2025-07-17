//https://leetcode.com/problems/reverse-nodes-in-even-length-groups/submissions/1700713012/?envType=problem-list-v2&envId=linked-list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevGroupEnd = dummy;
        ListNode curr = head;

        int groupSize = 1;

        while (curr != null) {
            ListNode groupStart = curr;
            int count = 0;

            while (count < groupSize && curr != null) {
                curr = curr.next;
                count++;
            }

            if (count % 2 == 0) {
                prevGroupEnd.next = reverse(groupStart, count);
            }

            for (int i = 0; i < count; i++) {
                prevGroupEnd = prevGroupEnd.next;
            }

            groupSize++;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null, curr = head, next = null;
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = curr;
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i <= 9; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        ReverseEvenLengthGroups sol = new ReverseEvenLengthGroups();
        ListNode res = sol.reverseEvenLengthGroups(head);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
