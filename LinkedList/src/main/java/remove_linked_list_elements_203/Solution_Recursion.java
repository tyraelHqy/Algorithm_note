package remove_linked_list_elements_203;

public class Solution_Recursion {
    public ListNode removeElements(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);
        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return head;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        ListNode returnNode;
        if (head.val == val) {
            returnNode = res;
        } else {
            head.next = res;
            returnNode = head;
        }

        System.out.print(depthString);
        System.out.println("Return: " + returnNode);
        return returnNode;
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution_Recursion()).removeElements(head, 6, 0);
        System.out.println(res);
    }

}
