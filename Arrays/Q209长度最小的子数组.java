/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Arrays;

/**
 *
 * @author shenweizhang
 */
public class Q209长度最小的子数组  {
  public int minSubArrayLen(int target, int[] nums) {
    int j = 0;
    int result = Integer.MAX_VALUE;
    int currSum = 0;
    for (int i = 0; i < nums.length; i++) {
      currSum += nums[i];
      while (currSum >= target) {
        result = Math.min(result, i - j + 1);
        currSum -= nums[j];
        j++;
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }
}
