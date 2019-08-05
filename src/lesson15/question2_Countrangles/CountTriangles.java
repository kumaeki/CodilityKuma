package lesson15.question2_Countrangles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * to slow
 * 
 * @author xiong_yi
 *
 */
public class CountTriangles {
    public int solution(int[] A) {
        // sort A
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }

        int result = 0;
        int i = 0;
        int j = 1;
        int k = 2;
        for (; i < len - 2; i++) {
            for (j = i + 1; j < len - 1; j++) {
                for (k = j + 1; k < len && A[i] + A[j] > A[k]; k++) {
                }
                result += (k - 1 - j);
            }

        }

        return result;
    }

    @Test
    public void testExample() {
        int[] A = { 10, 2, 5, 1, 8, 12 };
        int result = 4;
        assertEquals(result, new CountTriangles().solution(A));

    }
}
