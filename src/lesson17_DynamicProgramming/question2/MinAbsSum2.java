package lesson17_DynamicProgramming.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

public class MinAbsSum2 {
    public int solution(int[] A) {

        int N = A.length;
        if (N == 0)
            return 0;
        for (int i = 0; i < N; i++) {
            if (A[i] < 0)
                A[i] = 0 - A[i];
        }
        Arrays.sort(A);

        HashSet<Integer> pre = new HashSet<Integer>(200);
        HashSet<Integer> cur = new HashSet<Integer>(200);
        pre.add(A[N - 1]);

        for (int i = N - 2; i >= 0; i--) {
            for (int p : pre) {
                int temp = Math.abs(p + A[i]);
                if (temp >= 0 || temp <= 100)
                    cur.add(temp);
                temp = Math.abs(p - A[i]);
                if (temp >= 0 || temp <= 100)
                    cur.add(temp);
            }
            pre = (HashSet<Integer>) cur.clone();
            cur.clear();
        }

        Integer min = null;
        for (int s : pre) {
            if (min == null) {
                min = s;
            } else if (s < min) {
                min = s;
            }
        }

        return min;

    }

    @Test
    public void testExample() {
        int[] A = { 1, 5, 2, -2 };
        int result = 0;
        assertEquals(result, new MinAbsSum2().solution(A));
    }

    @Test
    public void testSimple1() {
        int[] A = {};
        int result = 0;
        assertEquals(result, new MinAbsSum2().solution(A));
    }

    @Test
    public void testSimple2() {
        int[] A = { 1, 2 };
        int result = 1;
        assertEquals(result, new MinAbsSum2().solution(A));
    }

    @Test
    public void testSimple3() {
        int[] A = { 1, 2, 100 };
        int result = 97;
        assertEquals(result, new MinAbsSum2().solution(A));
    }

    @Test
    public void testSimple4() {
        int[] A = { 91, 92, 93, 94, 95, 96, 97 };
        int result = 82;
        assertEquals(result, new MinAbsSum2().solution(A));
    }
}
