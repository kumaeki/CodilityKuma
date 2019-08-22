package lession06_Sorting.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Triangle {
    public int solution(int[] A) {
        int N = A.length;
        if (N > 2) {
            Arrays.sort(A);
            for (int i = 0; i < N - 2; i++) {
                if (A[i] <= 0)
                    continue;
                if (A[i] > A[i + 2] - A[i + 1])
                    return 1;
            }
        }
        return 0;
    }

    @Test
    public void testExample1() {
        int[] A = { 10, 2, 5, 1, 8, 20 };
        int result = 1;
        assertEquals(result, new Triangle().solution(A));

    }

    @Test
    public void testExample2() {
        int[] A = { 10, 50, 5, 1 };
        int result = 0;
        assertEquals(result, new Triangle().solution(A));

    }

}
