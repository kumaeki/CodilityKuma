package lesson15.question2_Countrangles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CountTriangles3 {
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
        for (; i < len - 2; i++) {
            int j = 1;
            for (j = i + 1; j < len - 1; j++) {
                int start = j + 1;
                int end = len - 1;
                int sum = A[i] + A[j];
                int r = j;
                while (start <= end) {
                    int middle = (start + end) / 2;
                    if (sum > A[middle]) {
                        start = middle + 1;
                        r = middle;
                    } else {
                        end = middle - 1;
                    }
                }
                result += (r - j);
            }

        }
        return result;
    }

    @Test
    public void testExample() {
        int[] A = { 10, 2, 5, 1, 8, 12 };
        int result = 4;
        assertEquals(result, new CountTriangles3().solution(A));

    }
}
