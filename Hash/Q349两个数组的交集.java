package Hash;

import java.util.HashSet;
import java.util.Set;

public class Q349两个数组的交集 {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> resultSet = new HashSet<>();
    for (int i = 0; i < nums1.length; i++) { // 先把nums1的存在一个set中
      set1.add(nums1[i]);
    }
    for (int i = 0; i < nums2.length; i++) {
      if (set1.contains(nums2[i])) {   // set1 如果有的话就加，因为找并集
        resultSet.add(nums2[i]);
      }
    }
    int[] resultArr = new int[resultSet.size()];
    int i = 0;
    for (int item : resultSet) {
      resultArr[i++] = item;
    }
    return resultArr;
  }
}
