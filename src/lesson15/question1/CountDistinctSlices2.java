package lesson15.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CountDistinctSlices2 {

    public final static int MAXCOUNT = 1000000000;

    public int solution(int M, int[] A) {
        if (A.length == 1)
            return 1;
        int max = getMax(A);
        int[] temp = new int[max + 1];
        Arrays.fill(temp, -1);
        int result = 0;
        int start = 0;
        int next = 0;
        int len = A.length;
        int maxSize = getMaxSize();
        while (start < len && next < len) {

            while (start < next && temp[A[next]] != -1) {
                temp[A[start]] = -1;
                start++;
            }
            int preSize = next - start;

            int newSize = 0;
            do {
                temp[A[next]] = next;
                next++;
                newSize++;
            } while (next < len && temp[A[next]] == -1);
            if (newSize > maxSize) {
                return MAXCOUNT;
            }
            result += getSum(preSize, newSize);
            if (result > MAXCOUNT) {
                return MAXCOUNT;
            }
        }

        return result;
    }

    int getMaxSize() {
        int i = 0;
        while (getCount(i) < MAXCOUNT) {
            i++;
        }
        return i - 1;
    }

    int getCount(int N) {
        return (N * (N + 1)) / 2;
    }

    int getSum(int preSize, int newSize) {
        return newSize * preSize + getCount(newSize);
    }

    int getMax(int[] N) {
        int max = 0;
        for (int i : N) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    @Test
    public void testExample() {
        int M = 5;
        int[] A = { 3, 4, 5, 5, 2 };
        int result = 9;
        assertEquals(result, new CountDistinctSlices2().solution(M, A));

    }

    @Test
    public void testSimple1() {
        int M = 1;
        int[] A = { 1 };
        int result = 1;
        assertEquals(result, new CountDistinctSlices2().solution(M, A));

    }

    @Test
    public void testSimple2() {
        int M = 1;
        int[] A = { 1, 1 };
        int result = 2;
        assertEquals(result, new CountDistinctSlices2().solution(M, A));

    }

    @Test
    public void testSimple3() {
        int M = 1;
        int[] A = { 0, 1 };
        int result = 3;
        assertEquals(result, new CountDistinctSlices2().solution(M, A));

    }

    @Test
    public void testSimple4() {
        int M = 0;
        int[] A = { 0 };
        int result = 1;
        assertEquals(result, new CountDistinctSlices2().solution(M, A));

    }

    @Test
    public void testSimple5() {
        int M = 2;
        int[] A = { 1, 2, 3, 1, 5 };
        int result = 13;
        assertEquals(result, new CountDistinctSlices2().solution(M, A));

    }

    @Test
    public void testLarge1() {
        int M = 100000;
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
        int result = new CountDistinctSlices().solution(M, A);
        assertEquals(result, new CountDistinctSlices2().solution(M, A));

    }

    public static void main(String[] args) {
        int n = 1;
        while ((n * (n + 1)) / 2 < 1000000000) {
            n++;
        }
        n--;
        System.out.println(n);
        System.out.println((n * (n + 1)) / 2);
        n++;
        System.out.println(n);
        System.out.println((n * (n + 1)) / 2);
    }
}
