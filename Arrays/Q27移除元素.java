package Arrays;

/**
 *
 * @author shenweizhang
 */
public class Q27移除元素 {
  public int removeElement(int[] nums, int val) {
    int slowPtr = 0;
    for (int fastPtr = 0; fastPtr < nums.length; fastPtr++) {
      nums[slowPtr] = nums[fastPtr];
      if (nums[slowPtr] != val) {
        slowPtr++;
      }
    }
    return slowPtr;
  }
}
