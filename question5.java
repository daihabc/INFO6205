package Assignment6;

public class question5 {
    /*
    question5
    */
    public ListNode reverse (ListNode head, int k) {
        ListNode newHead = null;
        ListNode node = head;

        while(k > 0){
            ListNode next_node = node.next;

            node.next = newHead;
            newHead = node;

            node = next_node;

            k--;
        }
        return newHead;
    }

    public ListNode reverseKGroup (ListNode head, int k){
        int n = 0;
        ListNode node = head;

        while(n < k && node != null){
            node = node.next;
            n ++;
        }

        if(n == k){
            ListNode reverseHead = this.reverse(head, k);
            head.next = this.reverseKGroup(node, k);
            return reverseHead;
        }

        return head;
    }
}
