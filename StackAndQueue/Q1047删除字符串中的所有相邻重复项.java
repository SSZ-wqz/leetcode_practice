import java.util.Stack;

public class Q1047删除字符串中的所有相邻重复项 {
  public String removeDuplicates(String s) {
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (!st.isEmpty() && st.peek() == s.charAt(i)) {
        st.pop();
      } else {
        st.push(s.charAt(i));
      }
    }
    StringBuilder sb = new StringBuilder();
    while(!st.empty()) {
      sb.append(st.pop());
    }
    return sb.reverse().toString();
  }
}
