package Greedy;

import java.util.Arrays;

public class Q455分发饼干 {

    public int findContentChildren(int[] g, int[] s) {
        int cnt = 0;
        if (g.length == 0 || s.length == 0) {
            return cnt;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0;
        for (int i = 0; i < s.length; i++) {
            if (gIndex <= g.length - 1 && s[i] >= g[gIndex]) {
                cnt += 1;
                gIndex += 1;
            }
        }
        return cnt;
    }

}
