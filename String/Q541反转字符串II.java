package String;

public class Q541反转字符串II {
  public String reverseStr(String s, int k) {
    char[] sArr = s.toCharArray();
    for (int i = 0; i < sArr.length; i += 2 * k) {
      int start = i;
      int end = Math.min(i + k, sArr.length) - 1;
      reverse(sArr, start, end); 
    }
    return new String(sArr);
  }

  private void reverse(char[] sArr, int start, int end) {
    while(start < end) {
      char temp = sArr[start];
      sArr[start] = sArr[end];
      sArr[end] = temp;
      start++;
      end--;
    }
  }
}
