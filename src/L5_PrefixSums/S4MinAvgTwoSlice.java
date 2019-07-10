package L5_PrefixSums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class S4MinAvgTwoSlice {

    public int solution(int[] A) {

        int len = A.length;
        double[] sumArr = new double[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += A[i];
            sumArr[i] = sum;
        }

        Integer result = null;
        Double min = null;
        for (int i = 0; i < len - 1; i++) {
            Double minInner = null;
            for (int j = i + 1; j < len; j++) {
                double avg = 0;
                if (i != 0) {
                    avg = (sumArr[j] - sumArr[i - 1]) / (j + 1 - i);
                } else {
                    avg = sumArr[j] / (j + 1);
                }
                if (minInner == null || avg < minInner) {
                    minInner = avg;
                }
            }
            if (min == null || minInner < min) {
                min = minInner;
                result = i;
            }
        }
        return result;
    }

    // it does not work
    public int solution2(int[] A) {

        int len = A.length;
        int sumR = 0;
        Double avg1 = null;
        int right = 1;
        for (int i = 0; i < len; i++) {
            sumR += A[i];
            if (i == 0) {
                continue;
            }
            double avgInner = sumR / (i + 1);
            if (avg1 == null || avgInner < avg1) {
                avg1 = avgInner;
                right = i;
            }
        }

        int result = right - 1;
        int sumL = A[right];
        Double avgL = null;
        for (int i = right - 1; i >= 0; i--) {
            sumL += A[i];
            double avgInner = sumL / (right - i + 1);
            if (avgL == null || avgInner < avgL) {
                avgL = avgInner;
                result = i;
            }
        }
        return result;
    }

    @Test
    public void testExample() {
        int[] A = { 4, 2, 2, 5, 1, 5, 8 };
        assertEquals(1, new S4MinAvgTwoSlice().solution2(A));
    }

    @Test
    public void testMinus() {
        int[] A = { 4, 2, 2, 5, -100, 1, 8 };
        assertEquals(4, new S4MinAvgTwoSlice().solution2(A));
    }

    @Test
    public void testDouble() {
        int[] A = { 4, 2 };
        assertEquals(0, new S4MinAvgTwoSlice().solution2(A));
    }

}
