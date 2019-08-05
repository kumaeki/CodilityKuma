package lesson15.question4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * to slow
 * 
 * @author xiong_yi
 *
 */
public class MinAbsSumOfTwo {
    public int solution(int[] A) {
        // sort the Array
        int len = A.length;
        if (len == 1) {
            return Math.abs(2 * A[0]);
        }
        int result = -1;
        for (int i = 0; i < len; i++) {
            if (A[i] == 0) {
                return 0;
            }
            for (int j = 0; j < len; j++) {
                int temp = Math.abs(A[i] + A[j]);
                result = result == -1 ? temp : Math.min(result, temp);
            }
        }
        return result;
    }

    @Test
    public void TestExample1() {
        int[] A = { 1, 4, -3 };
        int result = 1;
        assertEquals(result, new MinAbsSumOfTwo().solution(A));
    }

    @Test
    public void TestExample2() {
        int[] A = { -8, 4, 5, -10, 3 };
        int result = 3;
        assertEquals(result, new MinAbsSumOfTwo().solution(A));
    }

    @Test
    public void TestSimple1() {
        int[] A = { 1, 4, 0, 5 };
        int result = 0;
        assertEquals(result, new MinAbsSumOfTwo().solution(A));
    }

    @Test
    public void TestSimple2() {
        int[] A = { 1, 4, 100, 5 };
        int result = 2;
        assertEquals(result, new MinAbsSumOfTwo().solution(A));
    }

    @Test
    public void TestSimple3() {
        int[] A = { -1, -4, -100, -5 };
        int result = 2;
        assertEquals(result, new MinAbsSumOfTwo().solution(A));
    }

    @Test
    public void TestSimple4() {
        int[] A = { -1, -4, 0, -100, -5 };
        int result = 0;
        assertEquals(result, new MinAbsSumOfTwo().solution(A));
    }

    @Test
    public void TestSimple5() {
        int[] A = { 0 };
        int result = 0;
        assertEquals(result, new MinAbsSumOfTwo().solution(A));
    }

    @Test
    public void TestSimple6() {
        int[] A = { 100 };
        int result = 200;
        assertEquals(result, new MinAbsSumOfTwo().solution(A));
    }

    @Test
    public void TestSimple7() {
        int[] A = { -100, -1, 201, 105, 95 };
        int result = 2;
        assertEquals(result, new MinAbsSumOfTwo().solution(A));
    }

    @Test
    public void TestSimple8() {
        int[] A = { -100, 2, 201, 105, 95 };
        int result = 4;
        assertEquals(result, new MinAbsSumOfTwo().solution(A));
    }

}
