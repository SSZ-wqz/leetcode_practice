import java.util.Stack;

public class Q20有效的括号 {
  public boolean isValid(String s) {
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
        switch (ch) {
            case '(' -> st.push(')');
            case '[' -> st.push(']');
            case '{' -> st.push('}');
            case ')', ']', '}' -> {
                if (st.empty()) {
                    return false;
                }       if (st.pop() != ch) {
                    return false;
                }
            }
            default -> {
            }
        }
    }
    return st.empty();
  }
}
