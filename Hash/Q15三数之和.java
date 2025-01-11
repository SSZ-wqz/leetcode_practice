package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15三数之和 {
   public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> resultList = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        return resultList;
      }
      if (i > 0 && nums[i] == nums[i - 1]) {  // 去重
        continue;
      }
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        if (nums[j] + nums[k] < (-nums[i])) {
          j++;
        } else if (nums[j] + nums[k] > (-nums[i])) {
          k--;
        } else {
          List<Integer> tempList = new ArrayList<>();
          tempList.add(nums[i]);
          tempList.add(nums[j]);
          tempList.add(nums[k]);
          resultList.add(tempList);
          j++;
          k--;
          while (j < k && nums[j - 1] == nums[j]) {
            j++;
          }
          while (j < k && nums[k + 1] == nums[k]) {
            k--;
          }
        }
      }
    }
    return resultList;
  }
}
