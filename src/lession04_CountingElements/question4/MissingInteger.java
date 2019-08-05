package lession04_CountingElements.question4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MissingInteger {
    public int solution(int[] A) {
        int max = 1;
        for (int a : A) {
            if (a > max) {
                max = a;
            }
        }
        int[] B = new int[max + 1];
        for (int a : A) {
            if (a > 0) {
                B[a] = 1;
            }
        }

        for (int i = 1; i < max + 1; i++) {
            if (B[i] == 0) {
                return i;
            }
        }
        return max + 1;
    }

    @Test
    public void testExample1() {
        int[] A = { 1, 3, 6, 4, 1, 2 };
        int result = 5;
        assertEquals(result, new MissingInteger().solution(A));
    }

    @Test
    public void testExample2() {
        int[] A = { 1, 2, 3 };
        int result = 4;
        assertEquals(result, new MissingInteger().solution(A));
    }

    @Test
    public void testExample3() {
        int[] A = { -1, -2 };
        int result = 1;
        assertEquals(result, new MissingInteger().solution(A));
    }
}
