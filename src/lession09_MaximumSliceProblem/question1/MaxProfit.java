package lession09_MaximumSliceProblem.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaxProfit {
    public int solution(int[] A) {
        int N = A.length;
        if (N == 0) {
            return 0;
        }
        int level = A[0];
        int profit = 0;
        for (int i = 1; i < N; i++) {
            if (A[i] >= level) {
                profit = Math.max(profit, A[i] - level);
            } else {
                level = A[i];
            }
        }
        return profit;
    }

    @Test
    public void testExample() {
        int[] A = { 23171, 21011, 21123, 21366, 21013, 21367 };
        int result = 356;
        assertEquals(result, new MaxProfit().solution(A));
    }

    @Test
    public void testSimple1() {
        int[] A = {};
        int result = 0;
        assertEquals(result, new MaxProfit().solution(A));
    }

    @Test
    public void testSimple2() {
        int[] A = { 23171 };
        int result = 0;
        assertEquals(result, new MaxProfit().solution(A));
    }

    @Test
    public void testSimple3() {
        int[] A = { 23171, 21011 };
        int result = 0;
        assertEquals(result, new MaxProfit().solution(A));
    }
}
