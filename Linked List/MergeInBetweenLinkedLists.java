//https://leetcode.com/problems/merge-in-between-linked-lists/submissions/1699638271/?envType=problem-list-v2&envId=linked-list
public class MergeInBetweenLinkedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevA = list1;
        for (int i = 0; i < a - 1; i++) {
            prevA = prevA.next;
        }

        ListNode afterB = prevA;
        for (int i = 0; i < (b - a + 2); i++) {
            afterB = afterB.next;
        }

        prevA.next = list2;

        ListNode tail = list2;
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = afterB;

        return list1;
    }

    public static void main(String[] args) {
        MergeInBetweenLinkedLists solution = new MergeInBetweenLinkedLists();

        ListNode list1 = new ListNode(0);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1000000);
        list2.next = new ListNode(1000001);
        list2.next.next = new ListNode(1000002);

        int a = 3, b = 4;

        ListNode result = solution.mergeInBetween(list1, a, b, list2);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
