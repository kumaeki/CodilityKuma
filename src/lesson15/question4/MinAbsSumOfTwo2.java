package lesson15.question4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * to slow
 * 
 * @author xiong_yi
 *
 */
public class MinAbsSumOfTwo2 {
    public int solution(int[] A) {
        int result = -1;
        // sort the Array
        int len = A.length;
        if (len == 1) {
            return Math.abs(2 * A[0]);
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }

        // if all the element equals or bigger than 0
        if (A[0] >= 0) {
            return Math.abs(2 * A[0]);
        }

        // if all the element equals or smaller than 0
        if (A[len - 1] <= 0) {
            return Math.abs(2 * A[len - 1]);
        }

        // the index of first zero or positive
        int index = -1;
        for (int i = 0; i < len; i++) {
            if (A[i] == 0) {
                return 0;
            }

            if (A[i] > 0 && index == -1) {
                index = i;
                break;
            }
        }
        int minabs = Math.min(Math.abs(2 * A[index - 1]), Math.abs(2 * A[index]));
        // start of nature numbers
        int start = index;
        // end of nature numbers
        int end = len - 1;
        // check all the negative
        for (int i = 0; i < index; i++) {
            int candidate = 0;
            while (start <= end) {
                int abs = 0 - A[i];
                int middle = (start + end) / 2;
                candidate = middle;
                if (abs == A[middle]) {
                    return 0;
                } else if (abs < A[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
            start = index;
            end = candidate;
            int temp = Math.min(Math.abs(A[i] + A[candidate]), Math.abs(A[i] + A[candidate - 1]));
            result = result == -1 ? temp : Math.min(result, temp);
        }

        return Math.min(result, minabs);
    }

    @Test
    public void TestExample1() {
        int[] A = { 1, 4, -3 };
        int result = 1;
        assertEquals(result, new MinAbsSumOfTwo2().solution(A));
    }

    @Test
    public void TestExample2() {
        int[] A = { -8, 4, 5, -10, 3 };
        int result = 3;
        assertEquals(result, new MinAbsSumOfTwo2().solution(A));
    }

    @Test
    public void TestSimple1() {
        int[] A = { 1, 4, 0, 5 };
        int result = 0;
        assertEquals(result, new MinAbsSumOfTwo2().solution(A));
    }

    @Test
    public void TestSimple2() {
        int[] A = { 1, 4, 100, 5 };
        int result = 2;
        assertEquals(result, new MinAbsSumOfTwo2().solution(A));
    }

    @Test
    public void TestSimple3() {
        int[] A = { -1, -4, -100, -5 };
        int result = 2;
        assertEquals(result, new MinAbsSumOfTwo2().solution(A));
    }

    @Test
    public void TestSimple4() {
        int[] A = { -1, -4, 0, -100, -5 };
        int result = 0;
        assertEquals(result, new MinAbsSumOfTwo2().solution(A));
    }

    @Test
    public void TestSimple5() {
        int[] A = { 0 };
        int result = 0;
        assertEquals(result, new MinAbsSumOfTwo2().solution(A));
    }

    @Test
    public void TestSimple6() {
        int[] A = { 100 };
        int result = 200;
        assertEquals(result, new MinAbsSumOfTwo2().solution(A));
    }

    @Test
    public void TestSimple7() {
        int[] A = { -100, -1, 201, 105, 95 };
        int result = 2;
        assertEquals(result, new MinAbsSumOfTwo2().solution(A));
    }

    @Test
    public void TestSimple8() {
        int[] A = { -100, 2, 201, 105, 95 };
        int result = 4;
        assertEquals(result, new MinAbsSumOfTwo2().solution(A));
    }

}
