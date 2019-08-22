package lession06_Sorting.question4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumberOfDiscIntersections {
    public int solution(int[] A) {
        int N = A.length;
        if (N == 0)
            return 0;
        int[] leftArr = new int[N];
        int[] rightArr = new int[N];
        for (int i = 0; i < N; i++) {
            int left = Math.max(0, i - A[i]);
            leftArr[left]++;
            int right = Math.min(N - 1, i + A[i]);
            if (i > Integer.MAX_VALUE - A[i]) {
                right = N - 1;
            }
            rightArr[right]++;
        }

        int level = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (leftArr[i] > 0) {
                int num = level * leftArr[i] + (leftArr[i] * (leftArr[i] - 1)) / 2;
                result += num;
                if (result > 10000000)
                    return -1;
            }
            level = level - rightArr[i] + leftArr[i];
        }

        return result;
    }

    @Test
    public void testExample() {
        int[] A = { 1, 5, 2, 1, 4, 0 };
        int result = 11;
        assertEquals(result, new NumberOfDiscIntersections().solution(A));
    }

    @Test
    public void testSimple1() {
        int[] A = {};
        int result = 0;
        assertEquals(result, new NumberOfDiscIntersections().solution(A));
    }

    @Test
    public void testSimple2() {
        int[] A = { 1 };
        int result = 0;
        assertEquals(result, new NumberOfDiscIntersections().solution(A));
    }
    
    @Test
    public void testSimple3() {
        int[] A = { 1, 2147483647, 0};
        int result = 2;
        assertEquals(result, new NumberOfDiscIntersections().solution(A));
    }
}
