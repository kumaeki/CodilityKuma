package lesson15.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AbsDistinct {
    public int solution(int[] A) {
        int len = A.length;
        // count of repeat
        int repCount = 0;
        // count the repeat
        for (int i = 0; i < len - 1; i++) {
            if (A[i] == A[i + 1]) {
                repCount++;
            }
        }

        if (A[0] >= 0 || A[len - 1] <= 0) {
            return len - repCount;
        }

        // first index of zero or positive
        int zeroIndex = -1;
        // remove repeat
        int[] newA = new int[len - repCount];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                newA[index] = A[i];
                index++;
                continue;
            }
            if (A[i] != A[i - 1]) {
                newA[index] = A[i];
                // the position of first zero or positive
                if (A[i] >= 0 && zeroIndex == -1) {
                    zeroIndex = index;
                }
                index++;
            }
        }

        int newlen = newA.length;
        int newRepCount = 0;
        int last = newlen - 1;
        // check all negative
        for (int i = 0; i < zeroIndex; i++) {
            if (newA[i] == Integer.MIN_VALUE) {
                continue;
            }
            int abs = 0 - newA[i];
            int start = zeroIndex;
            int end = last;
            int middle = last;
            while (start <= end) {
                middle = (start + end) / 2;
                if (newA[middle] == abs) {
                    newRepCount++;
                    break;
                } else if (abs < newA[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
            last = middle;
        }
        return newlen - newRepCount;
    }

    @Test
    public void TestExample() {
        int[] A = { -5, -3, -1, 0, 3, 6 };
        int result = 5;
        assertEquals(result, new AbsDistinct().solution(A));
    }

    @Test
    public void TestSimple1() {
        int[] A = { -5, -3, -3, -1, 0, 0, 0 };
        int result = 4;
        assertEquals(result, new AbsDistinct().solution(A));
    }

    @Test
    public void TestSimple2() {
        int[] A = { -5, -3, -3, -1 };
        int result = 3;
        assertEquals(result, new AbsDistinct().solution(A));
    }

    @Test
    public void TestSimple3() {
        int[] A = { 0, 0, 0, 1, 3 };
        int result = 3;
        assertEquals(result, new AbsDistinct().solution(A));
    }

    @Test
    public void TestSimple4() {
        int[] A = { 1, 1, 1, 1, 3, 5 };
        int result = 3;
        assertEquals(result, new AbsDistinct().solution(A));
    }

    @Test
    public void TestSimple5() {
        int[] A = { -1, 1, 1, 1, 3, 5 };
        int result = 3;
        assertEquals(result, new AbsDistinct().solution(A));
    }

    @Test
    public void TestSimple6() {
        int[] A = { -5, -3, -3, -2, -1, -1, 1, 1 };
        int result = 4;
        assertEquals(result, new AbsDistinct().solution(A));
    }

    @Test
    public void TestSimple7() {
        int[] A = { -5, -3, -3, -2, -1, -1, 0, 0, 1, 1 };
        int result = 5;
        assertEquals(result, new AbsDistinct().solution(A));
    }

    @Test
    public void TestSimple8() {
        int[] A = { -2147483648, -1, 0, 1 };
        int result = 3;
        assertEquals(result, new AbsDistinct().solution(A));
    }
}
