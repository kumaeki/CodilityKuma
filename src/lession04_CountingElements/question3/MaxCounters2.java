package lession04_CountingElements.question3;

import static org.junit.Assert.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class MaxCounters2 {
    public int[] solution(int N, int[] A) {
        int[] B = new int[N];
        int max = 0;
        int level = 0;
        for (int a : A) {
            if (a <= N) {
                if (B[a - 1] < level) {
                    B[a - 1] = level + 1;
                } else {
                    B[a - 1]++;
                }
                max = Math.max(max, B[a - 1]);
            } else {
                level = max;
            }
        }
        for (int i = 0; i < N; i++) {
            if (B[i] < level) {
                B[i] = level;
            }
        }
        return B;
    }

    @Test
    public void testExample() {
        int N = 5;
        int[] A = { 3, 4, 4, 6, 1, 4, 4 };
        int[] B = { 3, 2, 2, 4, 2 };
        assertArrayEquals(B, new MaxCounters2().solution(N, A));
    }
}
