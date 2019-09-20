package lession08_Leader.question1;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Dominator2 {

    public int solution(int[] A) {
        int N = A.length;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            if (stack.size() == 0) {
                stack.add(A[i]);
            } else {
                if (stack.getLast() != A[i]) {
                    stack.removeLast();
                } else {
                    stack.addLast(A[i]);
                }
            }
        }
        if (stack.size() == 0)
            return -1;

        int candidate = stack.getLast();
        int count = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == candidate) {
                count++;
                result = i;
            }
        }

        return count > N / 2 ? result : -1;
    }

    @Test
    public void testExmaple() {
        int[] A = { 3, 4, 3, 2, 3, -1, 3, 3 };
        List<Integer> resultList = Arrays.asList(0, 2, 4, 6, 7);
        assertTrue(resultList.contains(new Dominator2().solution(A)));
    }

    @Test
    public void testSimple1() {
        int[] A = {};
        int result = -1;
        assertEquals(result, new Dominator2().solution(A));
    }

    @Test
    public void testSimple2() {
        int[] A = { Integer.MAX_VALUE };
        int result = 0;
        assertEquals(result, new Dominator2().solution(A));
    }

    @Test
    public void testSimple3() {
        int[] A = { Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE };
        List<Integer> resultList = Arrays.asList(0, 2);
        assertTrue(resultList.contains(new Dominator2().solution(A)));
    }

    @Test
    public void testSimple4() {
        int[] A = { Integer.MAX_VALUE, Integer.MIN_VALUE, 1 };
        int result = -1;
        assertEquals(result, new Dominator2().solution(A));
    }

}
