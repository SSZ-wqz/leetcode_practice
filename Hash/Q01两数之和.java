package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q01两数之和 {
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    return new int[2];
  }

  public int[] twoSum2(int[] nums, int target) {
    int[] cpArr = Arrays.copyOf(nums, nums.length); // Copy of the original array
    Arrays.sort(nums); // Sort the array
    int left = 0;
    int right = nums.length - 1;
    
    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum > target) {
        right--; // Decrease the right pointer
      } else if (sum < target) {
        left++; // Increase the left pointer
      } else {
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < cpArr.length; i++) {
          if (cpArr[i] == nums[left] && index1 == -1) {
            index1 = i;
          } else if (cpArr[i] == nums[right] && index2 == -1) {
            index2 = i;
          }
        }
        return new int[] {index1, index2};
      }
    }
    return new int[2]; // Default return if no solution is found
  }

  public int[] twoSum3(int[] nums, int target) {
    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int balance = target - nums[i];
      if (indexMap.containsKey(balance)) {
        return new int[] {indexMap.get(balance), i};
      } else {
        indexMap.put(nums[i], i);
      }
    }
    return new int[2];
  }
}
