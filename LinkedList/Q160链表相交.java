package LinkedList;

public class Q160链表相交 {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode curA =  headA;
    ListNode curB =  headB;
    while (curA != curB) {
      curA = curA != null ? curA.next : headB;
      curB = curB != null ? curB.next : headA;
    }
    return curA;
  }
}
