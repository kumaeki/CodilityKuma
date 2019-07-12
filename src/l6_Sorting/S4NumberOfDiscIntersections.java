package l6_Sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class S4NumberOfDiscIntersections {
    // to slow
    public int solution(int[] A) {
        int len = A.length;
        if (A == null || len < 2) {
            return 0;
        }

        int[][] AL = new int[len][2];
        for (int i = 0; i < len; i++) {
            AL[i][0] = i - A[i];
            AL[i][1] = A[i] > Integer.MAX_VALUE - i ? Integer.MAX_VALUE : i + A[i];
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (AL[i][1] >= AL[j][0]) {
                    result++;
                }
            }
        }

        return result;
    }

    // to slow
    public int solution2(int[] A) {
        int len = A.length;
        if (A == null || len < 2) {
            return 0;
        }

        int[][] AL = new int[len][2];
        for (int i = 0; i < len; i++) {
            AL[i][0] = i - A[i];
            AL[i][1] = A[i] > Integer.MAX_VALUE - i ? Integer.MAX_VALUE : i + A[i];
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            int ra = A[i] < len - 1 - i ? A[i] : len - 1 - i;
            result += ra;
            for (int j = i + ra + 1; j < len; j++) {
                if (AL[i][1] >= AL[j][0]) {
                    result++;
                }
            }
        }

        return result;
    }

    public int solution3(int[] A) {

        int len = A.length;
        if (A == null || len < 2) {
            return 0;
        }

        int[][] bounds = new int[len][2];
        for (int i = 0; i < len; i++) {
            int start = A[i] >= i ? 0 : i - A[i];
            int end = A[i] >= len - i - 1 ? len - 1 : A[i] + i;
            bounds[start][0]++;
            bounds[end][1]++;
        }

        int sum = 0;
        int actived = 0;
        for (int i = 0; i < len; i++) {

            sum += (actived * bounds[i][0] + (bounds[i][0] * (bounds[i][0] - 1) / 2));
            if (sum > 10000000) {
                return -1;
            }
            actived += bounds[i][0] - bounds[i][1];
        }

        return sum;
    }

    @Test
    public void testExample1() {
        int[] A = { 1, 5, 2, 1, 4, 0 };
        assertEquals(new S4NumberOfDiscIntersections().solution2(A), new S4NumberOfDiscIntersections().solution3(A));
    }

    @Test
    public void testMAX() {
        int[] A = { 1, Integer.MAX_VALUE, 2, 1, Integer.MAX_VALUE, 0 };
        assertEquals(new S4NumberOfDiscIntersections().solution2(A), new S4NumberOfDiscIntersections().solution3(A));
    }

    public static void main(String[] args) {
        int[][] bounds = new int[5][2];
        for (int[] is : bounds) {
            System.out.println(is[0] + " ; " + is[1]);
        }

    }
}
