package lesson16.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * to slow
 * 
 * @author xiong_yi
 *
 */
public class MaxNonoverlappingSegments {
    public int solution(int[] A, int[] B) {
        int max = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            int count = 1;

            int left = A[i];
            int pre = i - 1;
            while (pre >= 0) {
                if (B[pre] < left) {
                    count++;
                    left = A[pre];
                }
                pre--;
            }

            int right = B[i];
            int next = i + 1;
            while (next < len - 1) {
                if (A[next] > right) {
                    count++;
                    right = B[next];
                }
                next++;
            }
            max = Math.max(max, count);
        }

        return max;
    }

    @Test
    public void testExample() {
        int[] A = { 1, 3, 7, 9, 9 };
        int[] B = { 5, 6, 8, 9, 10 };
        int result = 3;
        assertEquals(result, new MaxNonoverlappingSegments().solution(A, B));
    }

    @Test
    public void testSimple1() {
        int[] A = { 1 };
        int[] B = { 5 };
        int result = 1;
        assertEquals(result, new MaxNonoverlappingSegments().solution(A, B));
    }

    @Test
    public void testSimple2() {
        int[] A = { 1, 2 };
        int[] B = { 5, 3 };
        int result = 1;
        assertEquals(result, new MaxNonoverlappingSegments().solution(A, B));
    }

    @Test
    public void testSimple3() {
        int[] A = {};
        int[] B = {};
        int result = 0;
        assertEquals(result, new MaxNonoverlappingSegments().solution(A, B));
    }

    @Test
    public void testSimple4() {
        int[] A = { 1, 2, 3 };
        int[] B = { 5, 6, 7 };
        int result = 1;
        assertEquals(result, new MaxNonoverlappingSegments().solution(A, B));
    }
}
