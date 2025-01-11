package Arrays;

public class Q59SpiralMatrixII {
  public int[][] generateMatrix(int n) {
    int[][] resultArr = new int[n][n];
    int num = 1;
    if (n == 1) {
      resultArr[0][0] = num;
      return resultArr;
    }
    for (int outerloop = 0; outerloop < Math.ceil(n / 2); outerloop++) {
      for (int innerloop_1 = outerloop; 
					      innerloop_1 < resultArr.length - 1 - outerloop; innerloop_1++) {
        resultArr[outerloop][innerloop_1] = num;
        num++;
      }
      for (int innerloop_2 = outerloop; 
					      innerloop_2 < resultArr.length - 1 - outerloop; innerloop_2++) {
        resultArr[innerloop_2][resultArr.length - 1 - outerloop] = num;
        num++;
      }
      for (int innerloop_3 = resultArr.length - 1 - outerloop; 
																      innerloop_3 > outerloop; innerloop_3--) {
        resultArr[resultArr.length - 1 - outerloop][innerloop_3] = num;
        num++;
      }
      for (int innerloop_4 = resultArr.length - 1 - outerloop; 
																      innerloop_4 > outerloop; innerloop_4--)  {
        resultArr[innerloop_4][outerloop] = num;
        num++;
      }
    }
    if (n % 2 != 0) resultArr[n / 2][n / 2] = num;
    return resultArr;
  }
}
