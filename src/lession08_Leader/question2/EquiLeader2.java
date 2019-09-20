package lession08_Leader.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class EquiLeader2 {
    public int solution(int[] A) {
        int count = 0;
        Integer leader = getLeader(A);
        if (leader == null) {
            return count;
        }

        int N = A.length;
        int countLeft = 0;
        int countRight = 0;

        // calculate the count of leader where index = 0
        if (A[0] == leader.intValue())
            countLeft++;
        for (int i = 1; i < N; i++) {
            if (A[i] == leader.intValue())
                countRight++;
        }
        if (countLeft > 0 && countRight > (N - 1) / 2) {
            count++;
        }

        // move the index from 0 to N-1 and calculate the count of leader
        for (int i = 1; i < N - 1; i++) {
            if (A[i] == leader.intValue()) {
                countLeft++;
                countRight--;
            }
            if (countLeft > (i + 1) / 2 && countRight > (N - i - 1) / 2) {
                count++;
            }
        }

        return count;
    }

    Integer getLeader(int[] A) {
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
            return null;
        int candidate = stack.getLast();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == candidate) {
                count++;
            }
        }
        return count > N / 2 ? candidate : null;
    }

    @Test
    public void testExample() {
        int[] A = { 4, 3, 4, 4, 4, 2 };
        int result = 2;
        assertEquals(result, new EquiLeader2().solution(A));
    }

    @Test
    public void testSimple1() {
        int[] A = { 4 };
        int result = 0;
        assertEquals(result, new EquiLeader2().solution(A));
    }

    @Test
    public void testSimple2() {
        int[] A = { 4, 4 };
        int result = 1;
        assertEquals(result, new EquiLeader2().solution(A));
    }
}
