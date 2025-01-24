package Greedy;

public class Q738单调递增的数字 {

    /**
     * 贪心算法一：左右互相证明法，就是速度慢，执行用时分布5ms，击败9.74%
     */
    public int monotoneIncreasingDigits_1(int n) {
        if (n > 0 && n <= 10) {
            return n - 1;
        }
        String[] sArr = (n + "").split("");

        for (int i = 0; i < sArr.length - 1; i++) {
            int curr = Integer.parseInt(sArr[i]);
            int next = Integer.parseInt(sArr[i + 1]);
            if (curr > next) {
                curr--;
                sArr[i] = Integer.toString(curr);
                for (int j = i + 1; j < sArr.length; j++) { // Set all digits after i to '9'
                    sArr[j] = "9";
                }
                break; // Exit early since monotonicity is enforced
            }
        }

        for (int i = sArr.length - 1; i > 0; i--) {
            int curr = Integer.parseInt(sArr[i]);
            int prev = Integer.parseInt(sArr[i - 1]);

            if (prev > curr) { // Fix monotonicity
                sArr[i - 1] = Integer.toString(Integer.parseInt(sArr[i - 1]) - 1);
                sArr[i] = "9"; // Ensure digits after this point are '9'
            }
        }

        return Integer.parseInt(String.join("", sArr));
    }

    /**
     * 暴力解法，超时了
     */
    public int monotoneIncreasingDigits(int n) {
        if (Integer.toString(n).length() == 1) {
            return n - 1;
        }
        while (n >= 0) {
            if (!isMonotonic(n)) {
                n--;
            } else {
                return n;
            }
        }
        return -1;
    }

    private boolean isMonotonic(int n) {
        String s = Integer.toString(n);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

}
