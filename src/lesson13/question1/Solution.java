package lesson13.question1;

import static org.junit.Assert.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class Solution {
    public int[] solution(int[] A, int[] B) {
        int len = A.length;
        int maxA = getMax(A);
        int maxB = getMax(B);
        int[] result = new int[len];

        int[] arr = new int[maxA + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) & ((1 << maxB) - 1);
        }

        for (int i = 0; i < len; i++) {
            result[i] = (arr[A[i]] & ((1 << B[i]) - 1));
        }

        return result;
    }

    int getMax(int A[]) {
        int max = 1;
        for (int a : A) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }

    @Test
    public void testExample() {
        int[] A = { 4, 4, 5, 5, 1 };
        int[] B = { 3, 2, 4, 3, 1 };
        int[] result = { 5, 1, 8, 0, 1 };
        assertArrayEquals(result, new Solution().solution(A, B));
    }

    @Test
    public void testSmall() {
        int[] A = { 1 };
        int[] B = { 3 };
        int[] result = { 1 };
        assertArrayEquals(result, new Solution().solution(A, B));
    }

    @Test
    public void testSmall2() {
        int[] A = { 2 };
        int[] B = { 3 };
        int[] result = { 2 };
        assertArrayEquals(result, new Solution().solution(A, B));
    }

    @Test
    public void testSmall3() {
        int[] A = { 3 };
        int[] B = { 3 };
        int[] result = { 3 };
        assertArrayEquals(result, new Solution().solution(A, B));
    }

}
