package lession03_TimeComplexity.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TapeEquilibrium {
    public int solution(int[] A) {
        int len = A.length;
        int leftSum = A[0];
        int rightSum = 0;
        for (int i = 1; i < len; i++) {
            rightSum += A[i];
        }
        int min = Math.abs(leftSum - rightSum);
        for (int i = 1; i < len - 1; i++) {
            leftSum += A[i];
            rightSum -= A[i];
            min = Math.min(min, Math.abs(leftSum - rightSum));
        }
        return min;
    }

    @Test
    public void test0() {
        int[] in = { 3, 1, 2, 4, 3 };
        int out = 1;
        assertEquals(out, solution(in));
    }

    @Test
    public void test1() {
        int[] in = { 3, 1 };
        int out = 2;
        assertEquals(out, solution(in));
    }

    @Test
    public void test2() {
        int[] in = { 3, -1 };
        int out = 4;
        assertEquals(out, solution(in));
    }

}
