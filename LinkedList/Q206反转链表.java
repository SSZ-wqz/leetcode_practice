package LinkedList;

public class Q206反转链表 {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode nex = cur.next;
      cur.next = pre;
      pre = cur;
      cur = nex;
    }
    return pre;
  }
}
