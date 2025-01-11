import java.util.Stack;

public class Q150逆波兰表达式求值 {
  public int evalRPN(String[] tokens) {
    Stack<Integer> st = new Stack<>();
    for (String token : tokens) {
      if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
        int num2 = st.pop();
        int num1 = st.pop();
        switch (token) {
          case "+" -> st.push(num1 + num2);
          case "-" -> st.push(num1 - num2);
          case "*" -> st.push(num1 * num2);
          case "/" -> st.push(num1 / num2);
        }
      } else {
        st.push(Integer.valueOf(token));
      }
    }
    return st.pop();
  }
}

