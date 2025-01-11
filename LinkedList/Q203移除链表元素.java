/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package LinkedList;

/**
 *
 * @author shenweizhang
 */
public class Q203移除链表元素 {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) return null;
    ListNode Dhead = new ListNode(-1, head);
    ListNode currNode = Dhead;
    while (currNode.next != null) {
      if (currNode.next.val == val) {
        currNode.next = currNode.next.next;
      } else {
        currNode = currNode.next;
      }
    }
    return Dhead.next;
  }
}
