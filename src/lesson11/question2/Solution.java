package lesson11.question2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class Solution {
    
    // to slow
    public int[] solution(int[] A) {
        int len = A.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    result[i]++;
                    continue;
                }
                if (A[i] < A[j]) {
                    continue;
                }
                if (A[i] == A[j] || A[i] % A[j] == 0) {
                    result[i]++;
                }
            }
            result[i] = len - result[i];
        }
        return result;
    }

    @Test
    public void testExample() {
        int[] A = { 3, 1, 2, 3, 6 };
        int[] result = { 2, 4, 3, 2, 0 };
        assertArrayEquals(result, new Solution().solution(A));
    }

    @Test
    public void testSingle() {
        int[] A = { 3 };
        int[] result = { 0 };
        assertArrayEquals(result, new Solution().solution(A));
    }

    @Test
    public void testDouble() {
        int[] A = { 3, 2 };
        int[] result = { 1, 1 };
        assertArrayEquals(result, new Solution().solution(A));
    }

    @Test
    public void testDouble2() {
        int[] A = { 3, 6 };
        int[] result = { 1, 0 };
        assertArrayEquals(result, new Solution().solution(A));
    }

    @Test
    public void testThree() {
        int[] A = { 3, 6, 9 };
        int[] result = { 2, 1, 1 };
        assertArrayEquals(result, new Solution().solution(A));
    }
}
