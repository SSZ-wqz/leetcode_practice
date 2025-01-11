package LinkedList;

public class Q707DesignLinkedList {
  class ListNode {
    int val;
    ListNode prev, next;
  
    ListNode(int val) {
      this.val = val;
    }
  }
  
  class MyLinkedList {
    ListNode head, tail; // 虚拟头结点和尾节点
    int size; // 链表大小
  
    public MyLinkedList() {
      this.head = new ListNode(-1); // 虚拟头结点
      this.tail = new ListNode(-1); // 虚拟尾结点
      this.head.next = this.tail; // 连接头尾
      this.tail.prev = this.head;
      this.size = 0;
    }
  
    public int get(int index) {
      if (index < 0 || index >= this.size) { // 检查越界
        return -1;
      }
      ListNode cur;
      if (index < this.size / 2) { // 从头部遍历
        cur = this.head;
        for (int i = 0; i <= index; i++) {
          cur = cur.next;
        }
      } else { // 从尾部遍历
        cur = this.tail;
        for (int i = 0; i < this.size - index; i++) {
          cur = cur.prev;
        }
      }
      return cur.val;
    }
  
    public void addAtHead(int val) {
      addAtIndex(0, val);
    }
  
    public void addAtTail(int val) {
      addAtIndex(this.size, val);
    }
  
    public void addAtIndex(int index, int val) {
      if (index < 0 || index > this.size) { // 检查越界
        return;
      }
      ListNode pre = this.head;
      for (int i = 0; i < index; i++) {
        pre = pre.next;
      }
      ListNode toAdd = new ListNode(val);
      toAdd.next = pre.next;
      toAdd.prev = pre;
      pre.next.prev = toAdd;
      pre.next = toAdd;
      this.size++;
    }
  
    public void deleteAtIndex(int index) {
      if (index < 0 || index >= this.size) { // 检查越界
        return;
      }
      ListNode pre = this.head;
      for (int i = 0; i < index; i++) {
        pre = pre.next;
      }
      ListNode toDelete = pre.next;
      toDelete.next.prev = pre;
      pre.next = toDelete.next;
      this.size--;
    }
  }
}
