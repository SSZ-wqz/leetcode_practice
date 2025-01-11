package Hash;

import java.util.HashMap;
import java.util.Map;

public class Q454四数相加II {
  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;
    for (int i : nums1) {
      for (int j : nums2) {
        map.put(i + j, map.getOrDefault(i + j, 0) + 1); // key存值sum, val存出现的次数
      }
    }
    for (int i : nums3) {
      for (int j : nums4) {
        res = res + map.getOrDefault(0 - (i + j), 0);
      }
    }
    return res;
  }
}
