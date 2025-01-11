package LinkedList;

public class Q24两两交换链表中的节点 {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummyHead = new ListNode(-1, head);
    ListNode cur = dummyHead;
    while (cur != null && cur.next != null && cur.next.next != null) {
      ListNode nex = cur.next;
      ListNode nexNex = cur.next.next;
      ListNode temp = nexNex.next;
      cur.next = nexNex;
      nexNex.next = nex;
      nex.next = temp;
      cur = nex;
    }
    return dummyHead.next;
  }
}
