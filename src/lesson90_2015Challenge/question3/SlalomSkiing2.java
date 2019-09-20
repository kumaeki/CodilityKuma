package lesson90_2015Challenge.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SlalomSkiing2 {

    public int solution(int[] A) {
        int n = A.length;
        int max = getMax(A);
        long[] newA = new long[3 * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            long a = A[i];
            newA[index] = 2 * max + a;
            index++;
            newA[index] = 2 * max - a;
            index++;
            newA[index] = a;
            index++;
        }
        return getMaxCount(newA);
    }

    public int getMaxCount(long[] A) {
        List<Long> list = new ArrayList<Long>();
        list.add(A[0]);
        for (long a : A) {
            if (a > list.get(list.size() - 1)) {
                list.add(a);
            } else {
                int start = 0;
                int end = list.size() - 1;
                boolean isSame = false;
                while (start <= end) {
                    int middle = (start + end) / 2;
                    if (list.get(middle) < a) {
                        start = middle + 1;
                    } else if (list.get(middle) > a) {
                        end = middle - 1;
                    } else {
                        isSame = true;
                        break;
                    }
                }
                if (!isSame) {
                    list.set(start, a);
                }
            }
        }

        return list.size();
    }

    public int getMax(int[] array) {
        // get the max value
        int max = 1;
        for (int a : array) {
            max = Math.max(a, max);
        }
        return max;
    }

    @Test
    public void testExample1() {
        long[] A = { 15, 13, 5, 7, 4, 10, 12, 8, 2, 11, 6, 9, 3 };
        int result = 8;
        assertEquals(result, new SlalomSkiing2().getMaxCount(A));
    }

    @Test
    public void testExample2() {
        int[] A = { 1, 5 };
        int result = 2;
        assertEquals(result, new SlalomSkiing2().solution(A));
    }

    @Test
    public void testSimple1() {
        int[] A = { 1, 2, 3, 4, 5 };
        int result = 5;
        assertEquals(result, new SlalomSkiing2().solution(A));
    }

    @Test
    public void testSimple2() {
        int[] A = { 1, 2, 5, 4, 3 };
        int result = 5;
        assertEquals(result, new SlalomSkiing2().solution(A));
    }

    @Test
    public void testSimple3() {
        int[] A = { 1, 5, 2, 3, 4 };
        int result = 5;
        assertEquals(result, new SlalomSkiing2().solution(A));
    }

    @Test
    public void testSimple4() {
        int[] A = { 5, 4, 1, 2, 3 };
        int result = 5;
        assertEquals(result, new SlalomSkiing2().solution(A));
    }

    @Test
    public void testSimple5() {
        int[] A = { 1000000000, 999999999, 3, 2, 1 };
        int result = 5;
        assertEquals(result, new SlalomSkiing2().solution(A));
    }

    @Test
    public void testSimple6() {
        int[] A = { 1000000000, 999999999, 1, 3, 2 };
        int result = 4;
        assertEquals(result, new SlalomSkiing2().solution(A));
    }
}
