package Hash;

import java.util.HashSet;
import java.util.Set;

public class Q202快乐数 {
  public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    while (n != 1) {
      int sum = 0;
      while (n > 0) {
        int digit = n % 10;   // 获取最左面的个位数字
        sum = sum + digit * digit;
        n = n / 10;
      }
      if (set.contains(sum)) {
        return false;
      }
      set.add(sum);
      n = sum;
    }
    return true;
  }
}
