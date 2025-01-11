import java.util.Stack;

public class Q232用栈实现队列 {
  Stack<Integer> stackIn;
  Stack<Integer> stackOut;

  public Q232用栈实现队列() {
    this.stackIn = new Stack<>();
    this.stackOut = new Stack<>();
  }

  public void push(int x) {
    this.stackIn.push(x);
  }

  public int pop() {
    dumpStackIn();
    return stackOut.pop();
  }

  public int peek() {
    dumpStackIn();
    return stackOut.peek();
  }

  public boolean empty() {
    return this.stackIn.empty() && this.stackOut.empty();
  }

  // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
  private void dumpStackIn() {
    if (!this.stackOut.empty()) {
      return;
    }
    while (!this.stackIn.empty()) {
      this.stackOut.push(this.stackIn.pop());
    }
  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */