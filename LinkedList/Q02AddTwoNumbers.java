package LinkedList;

public class Q02AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(-1);
    ListNode curA = l1;
    ListNode curB = l2;
    ListNode curC = dummyHead;
    int carry = 0;
    while (curA != null && curB != null) {
        int sum = curA.val + curB.val + carry;
        if (sum >= 10) {
            carry = 1;
            sum = sum % 10;
        } else {
            carry = 0;
        }
        ListNode tempNode = new ListNode(sum);
        curC.next = tempNode;
        curC = curC.next;
        curA = curA.next;
        curB = curB.next;
    }
    while (curA != null) {
        int sum = curA.val + carry;
        if (sum >= 10) {
            carry = 1;
            sum = sum % 10;
        } else {
            carry = 0;
        }
        ListNode tempNode = new ListNode(sum);
        curC.next = tempNode;
        curC = curC.next;
        curA = curA.next;
    }
    while (curB != null) {
        int sum = curB.val + carry;
        if (sum >= 10) {
            carry = 1;
            sum = sum % 10;
        } else {
            carry = 0;
        }
        ListNode tempNode = new ListNode(sum);
        curC.next = tempNode;
        curC = curC.next;
        curB = curB.next;
    }
    if (carry == 1) {
        ListNode tempNode = new ListNode(1);
        curC.next = tempNode;
    }
    return dummyHead.next;
}
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        Q02AddTwoNumbers q02 = new Q02AddTwoNumbers();
        ListNode result = q02.addTwoNumbers(l1, l2);
        System.out.println(result);
    }

}
