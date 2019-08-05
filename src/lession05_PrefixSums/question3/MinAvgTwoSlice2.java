package lession05_PrefixSums.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MinAvgTwoSlice2 {
    public int solution(int[] A) {
        float min = (A[0] + A[1]) / 2F;
        int result = 0;
        int len = A.length;
        for (int i = 0; i < len - 1; i++) {
            float temp = (A[i] + A[i + 1]) / 2F;
            if (i + 2 < len) {
                temp = Math.min(temp, (A[i] + A[i + 1] + A[i + 2]) / 3F);
            }
            if (temp < min) {
                min = temp;
                result = i;
            }
        }
        return result;
    }

    @Test
    public void testExample() {
        int[] A = { 4, 2, 2, 5, 1, 5, 8 };
        int result = 1;
        assertEquals(result, new MinAvgTwoSlice2().solution(A));
    }

    @Test
    public void testSimple1() {
        int[] A = { -3, -5, -8, -4, -10 };
        int result = 2;
        assertEquals(result, new MinAvgTwoSlice2().solution(A));
    }
}
