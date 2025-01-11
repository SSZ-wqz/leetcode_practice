/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Arrays;

/**
 *
 * @author shenweizhang
 */
public class Q977有序数组的平方 {
  public int[] sortedSquares(int[] nums) {
    int[] resultArr = new int[nums.length];
    int mergePos = resultArr.length - 1;
    int left = 0;
    int right = mergePos;
    while (left <= right) {  
      if (nums[left] * nums[left] > nums[right] * nums[right]) {
        resultArr[mergePos] = nums[left] * nums[left];
        left++;
      } else {
        resultArr[mergePos] = nums[right] * nums[right];
        right--;
      }
      mergePos--;
    }
    return resultArr;
  }
}
