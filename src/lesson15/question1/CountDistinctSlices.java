package lesson15.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * to slow
 * 
 * @author xiong_yi
 *
 */
public class CountDistinctSlices {
    public int solution(int M, int[] A) {
        if (A.length == 1)
            return 1;
        int result = 0;
        int start = 0;
        int next = 0;
        int len = A.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (start <= len && next <= len) {
            while (next < len && !map.containsValue(A[next])) {
                map.put(next, (A[next]));
                next++;
            }

            result += map.size();
            if (result > 1000000000) {
                return 1000000000;
            }
            if (!map.isEmpty()) {
                map.remove(start);
            }
            start++;
        }

        return result;
    }

    int getCount(int N) {
        return (N * (N + 1)) / 2;
    }

    @Test
    public void testExample() {
        int M = 5;
        int[] A = { 3, 4, 5, 5, 2 };
        int result = 9;
        assertEquals(result, new CountDistinctSlices().solution(M, A));

    }

    @Test
    public void testSimple1() {
        int M = 1;
        int[] A = { 1 };
        int result = 1;
        assertEquals(result, new CountDistinctSlices().solution(M, A));

    }

    @Test
    public void testSimple2() {
        int M = 1;
        int[] A = { 1, 1 };
        int result = 2;
        assertEquals(result, new CountDistinctSlices().solution(M, A));

    }

    @Test
    public void testSimple3() {
        int M = 1;
        int[] A = { 0, 1 };
        int result = 3;
        assertEquals(result, new CountDistinctSlices().solution(M, A));

    }

    @Test
    public void testSimple4() {
        int M = 0;
        int[] A = { 0 };
        int result = 1;
        assertEquals(result, new CountDistinctSlices().solution(M, A));

    }


    @Test
    public void testLarge1() {
        int M = 100000;
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = 100000;
        }
        int result = 100000;
        assertEquals(result, new CountDistinctSlices().solution(M, A));

    }
}
