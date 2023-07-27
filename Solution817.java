import java.util.ArrayList;

class Solution817 {
    public static int numComponents(ListNode head, int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : nums) list.add(i);

        int components = 0;
        int connections = 0;
        while (head != null) {
            if (list.contains(head.val)) {
                connections++;
            } else {
                if (connections > 0) {
                    components++;
                }
                connections = 0;
            }
            head = head.next;
        }
        if (connections > 0) components += 1;
        return components;
    }  

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        a.next = new ListNode(2);
        a.next.next = new ListNode(1);
        int[] nums = {1, 2, 3};
        System.out.println(numComponents(a, nums));
    }
}