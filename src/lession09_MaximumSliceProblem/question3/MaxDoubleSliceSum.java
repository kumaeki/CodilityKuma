package lession09_MaximumSliceProblem.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaxDoubleSliceSum {
        public int solution(int[] A) {
            int n = A.length;
            int[] maxLeft = new int[n];
            int[] maxRight = new int[n];
    
            for (int i = 1; i < n - 1; i++) {
                maxLeft[i] = Math.max(maxLeft[i - 1] + A[i], 0);
                maxRight[n - i - 1] = Math.max(maxRight[n - i] + A[n - i - 1], 0);
            }
    
            int max = 0;
            for (int i = 1; i < n - 1; i++) {
                max = Math.max(max, maxLeft[i - 1] + maxRight[i + 1]);
            }
    
            return max;
        }

    @Test
    public void TestExample() {
        int[] A = { 3, 2, 6, -1, 4, 5, -1, 2 };
        int result = 17;
        assertEquals(result, new MaxDoubleSliceSum().solution(A));
    }

    @Test
    public void TestSimple1() {
        int[] A = { 3, 2, 6 };
        int result = 0;
        assertEquals(result, new MaxDoubleSliceSum().solution(A));
    }

    @Test
    public void TestSimple2() {
        int[] A = { 3, 2, 100, 6 };
        int result = 100;
        assertEquals(result, new MaxDoubleSliceSum().solution(A));
    }

    @Test
    public void TestSimple3() {
        int[] A = { -3, -2, -100, -6 };
        int result = 0;
        assertEquals(result, new MaxDoubleSliceSum().solution(A));
    }

    @Test
    public void TestSimple4() {
        int[] A = { -3, -2, -100, 100, -6 };
        int result = 100;
        assertEquals(result, new MaxDoubleSliceSum().solution(A));
    }

    @Test
    public void TestSimple5() {
        int[] A = { -3, -2, 100, -100, -6 };
        int result = 100;
        assertEquals(result, new MaxDoubleSliceSum().solution(A));
    }

}
