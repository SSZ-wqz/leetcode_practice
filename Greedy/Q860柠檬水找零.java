package Greedy;

public class Q860柠檬水找零 {

    public boolean lemonadeChange(int[] bills) {
        int fiveCnt = 0;
        int tenCnt = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCnt += 1;
            }
            if (bills[i] == 10) {
                tenCnt += 1;
                if (fiveCnt == 0) {
                    return false;
                }
                fiveCnt -= 1;
            }
            if (bills[i] == 20) {
                if (tenCnt == 0) {
                    if (fiveCnt < 3) {
                        return false;
                    }
                    fiveCnt -= 3;
                } else {
                    tenCnt -= 1;
                    if (fiveCnt < 1) {
                        return false;
                    }
                    fiveCnt -= 1;
                }
            }
        }
        return true;
    }

}
