package LinkedList;

public class Q19删除链表的倒数第N个节点 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return null;
    }
    ListNode dH = new ListNode(-1, head);
    ListNode fast = dH;
    ListNode slow = dH;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    } 
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return dH.next;
  }
}
