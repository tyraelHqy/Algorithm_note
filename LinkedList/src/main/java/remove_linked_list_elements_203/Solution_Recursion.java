package remove_linked_list_elements_203;

public class Solution_Recursion {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return head;
        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution_Recursion()).removeElements(head, 6);
        System.out.println(res);
    }

}
