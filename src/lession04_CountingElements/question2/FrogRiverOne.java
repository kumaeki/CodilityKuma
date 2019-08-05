package lession04_CountingElements.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class FrogRiverOne {
    public int solution(int X, int[] A) {
        int len = A.length;
        int[] B = new int[X + 1];
        Arrays.fill(B, -1);
        for (int i = 0; i < len; i++) {
            if (B[A[i]] == -1) {
                B[A[i]] = i;
            } else {
                B[A[i]] = Math.min(B[A[i]], i);
            }
        }
        for (int i = 1; i <= X; i++) {
            if (B[i] == -1) {
                return -1;
            }
        }
        for (int i = 1; i <= X; i++) {
            if (i < X && B[i] > B[i + 1]) {
                int temp = B[i];
                B[i] = B[i + 1];
                B[i + 1] = temp;
            }
        }
        return B[X];
    }

    @Test
    public void testExample() {
        int X = 5;
        int[] A = { 1, 3, 1, 4, 2, 3, 5, 4 };
        int expected = 6;
        assertEquals(expected, new FrogRiverOne().solution(X, A));
    }

    @Test
    public void testSimple1() {
        int X = 2;
        int[] A = { 1, 1, 1 };
        int expected = -1;
        assertEquals(expected, new FrogRiverOne().solution(X, A));
    }

    @Test
    public void testSimple2() {
        int X = 3;
        int[] A = { 3, 3, 1 };
        int expected = -1;
        assertEquals(expected, new FrogRiverOne().solution(X, A));
    }

    @Test
    public void testSimple3() {
        int X = 3;
        int[] A = { 3, 2, 2, 1 };
        int expected = 3;
        assertEquals(expected, new FrogRiverOne().solution(X, A));
    }

}
