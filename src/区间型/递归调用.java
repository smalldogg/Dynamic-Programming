package 区间型;

import java.util.HashMap;
import java.util.Map;

public class 递归调用 {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(100, 100);
        System.out.println(map.get(new Integer(100)));
    }

    public static int getCount(int n) {
        int[] dp = new int[n];
        dp[0] = 3;
        dp[1] = 5;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + 1;
        }
        return dp[n - 1];
    }
}
