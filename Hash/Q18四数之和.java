package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18四数之和 {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> resultList = new ArrayList<>();
    
    for (int i = 0; i < nums.length - 3; i++) { // Outer loop bounds check
      if (nums[i] > target && nums[i] >= 0) { // Prune based on positivity
        break;
      }
      if (i > 0 && nums[i] == nums[i - 1]) { // Skip duplicates for i
        continue;
      }
      
      for (int j = i + 1; j < nums.length - 2; j++) { // Second loop bounds check
        if (nums[i] + nums[j] > target && nums[i] + nums[j] >= 0) { // Prune
          break;
        }
        if (j > i + 1 && nums[j] == nums[j - 1]) { // Skip duplicates for j
          continue;
        }
        
        int left = j + 1;
        int right = nums.length - 1;
        
        while (left < right) {
          int sum = nums[i] + nums[j] + nums[left] + nums[right];
          
          if (sum < target) {
            left++;
          } else if (sum > target) {
            right--;
          } else {
            resultList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
            left++;
            right--;
            
            // Skip duplicates for left
            while (left < right && nums[left] == nums[left - 1]) {
              left++;
            }
            
            // Skip duplicates for right
            while (left < right && nums[right] == nums[right + 1]) {
              right--;
            }
          }
        }
      }
    }
    
    return resultList;
  }
}
