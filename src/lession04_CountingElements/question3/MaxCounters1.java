package lession04_CountingElements.question3;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MaxCounters1 {
    public int[] solution(int N, int[] A) {
        int[] B = new int[N];
        int max = 0;
        for (int a : A) {
            if (a <= N) {
                B[a - 1]++;
                max = Math.max(max, B[a - 1]);
            } else {
                Arrays.fill(B, max);
            }
        }
        return B;
    }

    @Test
    public void testExample() {
        int N = 5;
        int[] A = { 3, 4, 4, 6, 1, 4, 4 };
        int[] B = { 3, 2, 2, 4, 2 };
        assertArrayEquals(B, new MaxCounters1().solution(N, A));
    }
}
