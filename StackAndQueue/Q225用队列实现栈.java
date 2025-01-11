import java.util.LinkedList;
import java.util.Queue;

public class Q225用队列实现栈 {

  Queue<Integer> queue1;
  Queue<Integer> queue2;

  public Q225用队列实现栈() {
    this.queue1 = new LinkedList<>();
    this.queue2 = new LinkedList<>();
  }

  public void push(int x) {
    queue1.offer(x);
  }

  public int pop() {
    while (queue1.size() > 1) {
      queue2.offer(queue1.poll());
    }
    int result = queue1.poll();
    while (!queue2.isEmpty()) {
      queue1.offer(queue2.poll());
    }
    return result;
  }

  public int top() {
    while (queue1.size() > 1) {
      queue2.offer(queue1.poll());
    }
    int result = queue1.peek();
    queue2.offer(queue1.poll());
    while (!queue2.isEmpty()) {
      queue1.offer(queue2.poll());
    }
    return result;
  }

  public boolean empty() {
    return queue1.isEmpty() && queue2.isEmpty();
  }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */