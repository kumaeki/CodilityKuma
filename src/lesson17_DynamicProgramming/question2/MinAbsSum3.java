package lesson17_DynamicProgramming.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MinAbsSum3 {
    public int solution(int[] A) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                A[i] = 0 - A[i];
            }
            // get the max value of A
            if (A[i] > max) {
                max = A[i];
            }
            ;
            // get the sum value of A
            sum += A[i];
        }

        int[] B = new int[max + 1];
        for (int a : A) {
            B[a]++;
        }
        // sum Array
        int[] sa = new int[sum + 1];
        Arrays.fill(sa, -1);
        // 0 is the possible value
        sa[0] = 0;
        for (int i = 1; i < max + 1; i++) {
            // when this value exist
            if (B[i] > 0) {
                for (int j = 0; j < sum + 1; j++) {
                    if (sa[j] >= 0) {
                        sa[j] = B[i];
                    } else if (j >= i && sa[j - i] > 0) {
                        sa[j] = sa[j - i] - 1;
                    }
                }
            }
        }

        int result = sum;
        for (int i = 0; i < (sum / 2) + 1; i++) {
            if (sa[i] >= 0) {
                result = Math.min(result, sum - 2 * i);
            }

        }
        return result;
    }

    @Test
    public void testExample() {
        int[] A = { 1, 5, 2, -2 };
        int result = 0;
        assertEquals(result, new MinAbsSum3().solution(A));
    }

    @Test
    public void testSimple1() {
        int[] A = {};
        int result = 0;
        assertEquals(result, new MinAbsSum3().solution(A));
    }

    @Test
    public void testSimple2() {
        int[] A = { 1, 2 };
        int result = 1;
        assertEquals(result, new MinAbsSum3().solution(A));
    }

    @Test
    public void testSimple3() {
        int[] A = { 1, 2, 100 };
        int result = 97;
        assertEquals(result, new MinAbsSum3().solution(A));
    }

    @Test
    public void testSimple4() {
        int[] A = { 91, 92, 93, 94, 95, 96, 97 };
        int result = 82;
        assertEquals(result, new MinAbsSum3().solution(A));
    }
}
