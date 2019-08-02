package lesson13.question2;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public int solution(int[] A) {
        int len = A.length;

        // fibonacci number list
        ArrayList<Integer> fl = getFib(len + 1);
        Collections.reverse(fl);

        if (len == 0 || fl.contains(len + 1)) {
            return 1;
        }

        //[0] : position
        //[1] : numbers of steps
        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(new int[] { -1, 0 });
        int index = 0;

        while (true) {
            if (index == list.size()) {
                return -1;
            }
            int[] current = list.get(index);
            for (int i : fl) {
                int next = current[0] + i;
                if (next == len) {
                    return current[1] + 1;
                } else if (next < len && A[next] == 1) {
                    list.add(new int[] { next, current[1] + 1 });
                }
            }
            index++;

        }

    }

    ArrayList<Integer> getFib(int N) {
        ArrayList<Integer> fibList = new ArrayList<Integer>();
        fibList.add(1);
        int next = 2;
        int index = 1;
        while (N >= next) {
            fibList.add(next);
            next = fibList.get(index) + fibList.get(index - 1);
            index++;
        }
        return fibList;
    }

    @Test
    public void testExample() {
        int[] A = { 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0 };
        int result = 3;
        assertEquals(result, new Solution().solution(A));
    }

    @Test
    public void testSample1() {
        int[] A = {};
        int result = 1;
        assertEquals(result, new Solution().solution(A));
    }

    @Test
    public void testSample2() {
        int[] A = { 0 };
        int result = 1;
        assertEquals(result, new Solution().solution(A));
    }

    @Test
    public void testSample3() {
        int[] A = { 0, 0 };
        int result = 1;
        assertEquals(result, new Solution().solution(A));
    }

    @Test
    public void testSample4() {
        int[] A = { 0, 0, 0 };
        int result = -1;
        assertEquals(result, new Solution().solution(A));
    }

    @Test
    public void testSample5() {
        int[] A = { 1, 1, 0, 0, 0, 0 };
        int result = 2;
        assertEquals(result, new Solution().solution(A));
    }

    @Test
    public void testSample6() {
        int[] A = { 1, 1, 0, 0, 0 };
        int result = 2;
        assertEquals(result, new Solution().solution(A));
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new Solution().getFib(100000);
        for (int i : list) {
            System.out.println(i);
            ;
        }
    }

}
