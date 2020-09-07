package reverse_linked_list_206;

public class Solution_Recursion {
    public ListNode reverseList(ListNode head){

        if(head == null || head.next == null){
            return head;
        }

        ListNode rev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }
}
