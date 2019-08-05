package lesson16.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author xiong_yi
 *
 */
public class MaxNonoverlappingSegments2 {
    public int solution(int[] A, int[] B) {
        int len = A.length;
        if (len < 2) {
            return len;
        }
        int count = 1;
        int right = B[0];
        for (int i = 1; i < len; i++) {
            if (A[i] > right) {
                count++;
                right = B[i];
            }
        }

        return count;
    }

    @Test
    public void testExample() {
        int[] A = { 1, 3, 7, 9, 9 };
        int[] B = { 5, 6, 8, 9, 10 };
        int result = 3;
        assertEquals(result, new MaxNonoverlappingSegments2().solution(A, B));
    }

    @Test
    public void testSimple1() {
        int[] A = { 1 };
        int[] B = { 5 };
        int result = 1;
        assertEquals(result, new MaxNonoverlappingSegments2().solution(A, B));
    }

    @Test
    public void testSimple2() {
        int[] A = { 1, 2 };
        int[] B = { 5, 3 };
        int result = 1;
        assertEquals(result, new MaxNonoverlappingSegments2().solution(A, B));
    }

    @Test
    public void testSimple3() {
        int[] A = {};
        int[] B = {};
        int result = 0;
        assertEquals(result, new MaxNonoverlappingSegments2().solution(A, B));
    }

    @Test
    public void testSimple4() {
        int[] A = { 1, 2, 3 };
        int[] B = { 5, 6, 7 };
        int result = 1;
        assertEquals(result, new MaxNonoverlappingSegments2().solution(A, B));
    }
}
