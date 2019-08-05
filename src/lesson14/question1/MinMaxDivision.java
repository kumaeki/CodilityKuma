package lesson14.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MinMaxDivision {
    public int solution(int K, int M, int[] A) {

        int len = A.length;
        int max = getMax(A);
        if (max == 0) {
            return 0;
        }
        if (K >= len) {
            return max;
        }

        // if K < len
        int start = max;
        int end = max * (len - K + 1);
        int result = 0;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (isMaxSum(A, middle, K)) {
                end = middle - 1;
                result = middle;
            } else {
                start = middle + 1;
            }
        }
        return result;
    }

    int getMax(int[] A) {
        int max = 0;
        for (int a : A) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }

    boolean isMaxSum(int[] A, int target, int K) {
        int count = 0;
        int sum = 0;
        for (int a : A) {
            sum += a;
            if (sum > target) {
                count++;
                sum = a;
            } else if (sum == target) {
                count++;
                sum = 0;
            }
            if (count > K) {
                return false;
            }
        }
        if (sum != 0) {
            count++;
        }
        return count > K ? false : true;
    }

    @Test
    public void testExample() {
        int K = 3;
        int M = 5;
        int[] A = { 2, 1, 5, 1, 2, 2, 2 };
        int result = 6;
        assertEquals(result, new MinMaxDivision().solution(K, M, A));
    }

    @Test
    public void testSimple1() {
        int K = 3;
        int M = 5;
        int[] A = {};
        int result = 0;
        assertEquals(result, new MinMaxDivision().solution(K, M, A));
    }

    @Test
    public void testSimple2() {
        int K = 3;
        int M = 5;
        int[] A = { 1 };
        int result = 1;
        assertEquals(result, new MinMaxDivision().solution(K, M, A));
    }

    @Test
    public void testSimple3() {
        int K = 7;
        int M = 5;
        int[] A = { 2, 1, 5, 1, 2, 2, 2 };
        int result = 5;
        assertEquals(result, new MinMaxDivision().solution(K, M, A));
    }

    @Test
    public void testSimple4() {
        int K = 8;
        int M = 5;
        int[] A = { 2, 1, 5, 1, 2, 2, 2 };
        int result = 5;
        assertEquals(result, new MinMaxDivision().solution(K, M, A));
    }

    @Test
    public void testSimple5() {
        int K = 9;
        int M = 10;
        int[] A = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
        int result = 20;
        assertEquals(result, new MinMaxDivision().solution(K, M, A));
    }

    @Test
    public void testALLSAME() {
        int K = 10;
        int M = 1887;
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = 1887;
        }
        int result = 18870000;
        assertEquals(result, new MinMaxDivision().solution(K, M, A));
    }
}
