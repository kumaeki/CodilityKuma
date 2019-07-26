package lesson11.question2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class Solution1 {
    public int[] solution(int[] A) {
        int len = A.length;
        int[] countArr = new int[2 * len];
        for (int i = 0; i < len; i++) {
            countArr[A[i] - 1]++;
        }

        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int[] dividors = getDivisors(A[i]);
            int sum = 0;
            for (int d : dividors) {
                if (d == 0) {
                    break;
                }
                sum += countArr[d - 1];
            }
            result[i] = len - sum;

        }
        return result;
    }

    int[] getDivisors(int N) {
        if (N == 1)
            return new int[] { 1 };

        int sqrt = (int) Math.sqrt(N);
        int[] result = new int[N / 2 + 1];
        result[0] = 1;
        result[1] = N;
        int j = 2;
        for (int i = 2; i <= sqrt; i++) {
            if (N % i == 0) {
                result[j] = i;
                if (i * i == N) {
                    j += 1;
                } else {
                    result[j + 1] = N / i;
                    j += 2;
                }

            }
        }
        return result;
    }

    @Test
    public void testExample() {
        int[] A = { 3, 1, 2, 3, 6 };
        int[] result = { 2, 4, 3, 2, 0 };
        assertArrayEquals(result, new Solution1().solution(A));
    }

    @Test
    public void testSingle() {
        int[] A = { 2 };
        int[] result = { 0 };
        assertArrayEquals(result, new Solution1().solution(A));
    }

    @Test
    public void testDouble() {
        int[] A = { 3, 2 };
        int[] result = { 1, 1 };
        assertArrayEquals(result, new Solution1().solution(A));
    }

    @Test
    public void testDouble2() {
        int[] A = { 3, 4 };
        int[] result = { 1, 1 };
        assertArrayEquals(result, new Solution1().solution(A));
    }

    @Test
    public void testThree() {
        int[] A = { 3, 6, 4 };
        int[] result = { 2, 1, 2 };
        assertArrayEquals(result, new Solution1().solution(A));
    }
}
