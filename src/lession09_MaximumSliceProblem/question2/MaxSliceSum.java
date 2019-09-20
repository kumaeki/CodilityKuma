package lession09_MaximumSliceProblem.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaxSliceSum {
    public int solution(int[] A) {
        int max = A[0];
        int preMax = A[0];
        for (int i = 1; i < A.length; i++) {
            preMax = Math.max(preMax + A[i], A[i]);
            max = Math.max(max, preMax);
        }
        return max;
    }

    @Test
    public void TestExample() {
        int[] A = { 3, 2, -6, 4, 0 };
        int result = 5;
        assertEquals(result, new MaxSliceSum().solution(A));
    }

    @Test
    public void TestSimple1() {
        int[] A = { 3 };
        int result = 3;
        assertEquals(result, new MaxSliceSum().solution(A));
    }

    @Test
    public void TestSimple2() {
        int[] A = { -2, -1, -3 };
        int result = -1;
        assertEquals(result, new MaxSliceSum().solution(A));
    }
}
