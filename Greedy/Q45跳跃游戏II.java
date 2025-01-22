package Greedy;

public class Q45跳跃游戏II {

  public int jump(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    int result = 0;
    int currCover = 0;
    int nextCover = 0;
    for (int i = 0; i < nums.length; i++) {
      nextCover = Math.max(nextCover, i + nums[i]);
      if (i == currCover) {
        currCover = nextCover;
        ++result;
        if (currCover >= nums.length - 1) {
          break;
        }
      }
    }
    return result;
  }

}
