package lession09.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution {
    public int solution(int[] A) {
        int len = A.length;
        int pre = A[0];
        int max = A[0];
        for (int i = 1; i < len; i++) {
            int a = A[i];
            pre = pre + a > a ? pre + a : a;
            max = max > pre ? max : pre;
        }
        return max;
    }

    @Test
    public void testExample() {
        int[] A = { 3, 2, -6, 4, 0 };
        assertEquals(5, new Solution().solution(A));
    }

    @Test
    public void testSingle1() {
        int[] A = { 3 };
        assertEquals(3, new Solution().solution(A));
    }

    @Test
    public void testSingle2() {
        int[] A = { -5 };
        assertEquals(-5, new Solution().solution(A));
    }

    @Test
    public void testDouble1() {
        int[] A = { 3, -5 };
        assertEquals(3, new Solution().solution(A));
    }

    @Test
    public void testDouble2() {
        int[] A = { -5, -2 };
        assertEquals(-2, new Solution().solution(A));
    }
}
