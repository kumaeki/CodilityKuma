package lession05_PrefixSums.question2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class GenomicRangeQuery {

    public final static char A = 'A';
    public final static char C = 'C';
    public final static char G = 'G';
    public final static char T = 'T';

    public int[] solution(String S, int[] P, int[] Q) {
        char[] arrayS = S.toCharArray();
        int N = arrayS.length;
        int[][] matrix = new int[N][];
        for (int i = 0; i < N; i++) {
            int a = 0;
            int c = 0;
            int g = 0;
            int t = 0;

            char ch = arrayS[i];
            switch (ch) {
            case A:
                a = 1;
                break;
            case C:
                c = 1;
                break;
            case G:
                g = 1;
                break;
            case T:
                t = 1;
                break;
            default:
                break;
            }

            int[] temp = { a, c, g, t };
            if (i == 0) {
                matrix[i] = temp;
            } else {
                matrix[i] = append(matrix[i - 1], temp);
            }
        }

        int M = P.length;
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            int p = P[i] - 1;
            int q = Q[i];
            int[] temp = new int[4];
            if (p < 0) {
                temp = matrix[q];
            } else {
                temp = subtract(matrix[q], matrix[p]);
            }

            if (temp[0] > 0) {
                result[i] = 1;
            } else if (temp[1] > 0) {
                result[i] = 2;
            } else if (temp[2] > 0) {
                result[i] = 3;
            } else if (temp[3] > 0) {
                result[i] = 4;
            }
        }

        return result;
    }

    /**
     * Array A subtract Array B
     * 
     */
    public int[] subtract(int[] A, int[] B) {
        int len = A.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = A[i] - B[i];
        }
        return result;
    }

    /**
     * Array A append Array B
     * 
     */
    public int[] append(int[] A, int[] B) {
        int len = A.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = A[i] + B[i];
        }
        return result;
    }

    @Test
    public void testExample() {
        String S = "CAGCCTA";
        int[] P = { 2, 5, 0 };
        int[] Q = { 4, 5, 6 };
        int[] result = { 2, 4, 1 };
        assertArrayEquals(result, new GenomicRangeQuery().solution(S, P, Q));
    }
}
