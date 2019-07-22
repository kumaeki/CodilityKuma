package lession09.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution {
    public int solution(int[] A) {
        int len = A.length;
        // first slice
        int[] f = new int[len];
        // second slice
        int[] s = new int[len];

        for (int i = 1; i < len; i++) {
            int sum = f[i - 1] + A[i];
            f[i] = sum > 0 ? sum : 0;
        }
        for (int i = len - 2; i > 0; i--) {
            int sum = s[i + 1] + A[i];
            s[i] = sum > 0 ? sum : 0;
        }

        int result = 0;
        for (int i = 1; i < len - 1; i++) {
            int sum = f[i - 1] + s[i + 1];
            result = sum > result ? sum : result;
        }
        return result;
    }

    @Test
    public void testExample() {
        int[] A = { 3, 2, 6, -1, 4, 5, -1, 2 };
        assertEquals(17, new Solution().solution(A));
    }

    @Test
    public void testThree() {
        int[] A = { 3, 2, 6 };
        assertEquals(0, new Solution().solution(A));
    }
}
