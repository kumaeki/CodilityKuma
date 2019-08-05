package lession05_PrefixSums.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MinAvgTwoSlice1 {
    public int solution(int[] A) {
        int N = A.length;
        int[] B = new int[N];
        B[0] = A[0];
        for (int i = 1; i < N; i++) {
            B[i] = B[i - 1] + A[i];
        }
        Float minIn = null;
        // min avg where P = 0
        for (int q = 1; q < N; q++) {
            float temp = B[q] / (float) (q + 1);
            if (minIn == null) {
                minIn = temp;
            } else {
                minIn = Math.min(minIn, temp);
            }
        }
        float[] C = new float[N - 1];
        C[0] = minIn;
        for (int p = 1; p < N - 1; p++) {
            minIn = null;
            for (int q = p + 1; q < N; q++) {
                float temp = (B[q] - B[p - 1]) / (float) (q - p + 1);
                if (minIn == null) {
                    minIn = temp;
                } else {
                    minIn = Math.min(minIn, temp);
                }
            }
            C[p] = minIn;
        }
        int result = 0;
        float min = C[0];
        for (int i = 1; i < N - 1; i++) {
            if (C[i] < min) {
                min = C[i];
                result = i;
            }
        }
        return result;
    }

    @Test
    public void testExample() {
        int[] A = { 4, 2, 2, 5, 1, 5, 8 };
        int result = 1;
        assertEquals(result, new MinAvgTwoSlice1().solution(A));
    }
}
