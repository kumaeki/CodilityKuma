package lession08.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Solution2 {
    public int solution(int[] A) {
        int count = 0;
        int len = A.length;
        for (int s = 0; s < len - 1; s++) {
            if (getLeader(s, A))
                count++;
        }
        return count;
    }

    boolean getLeader(int s, int[] A) {
        LeaderStack sRight = new LeaderStack();
        LeaderStack sLeft = new LeaderStack();
        int len = A.length;

        int candidate;
        for (int i = 0; i <= s; i++) {
            sRight.push(A[i]);
        }
        for (int i = s + 1; i < len; i++) {
            sLeft.push(A[i]);
        }
        if (!sRight.isExistCandidate() || !sLeft.isExistCandidate() || sRight.candidate() != sLeft.candidate()) {
            return false;
        }

        candidate = sRight.candidate();
        int countleft = 0;
        int halfLeft = (s + 1) / 2;
        int countRight = 0;
        int halfRight = (len - s - 1) / 2;

        for (int i = 0; i <= s; i++) {
            if (candidate == A[i])
                countleft++;
        }
        if (countleft <= halfLeft) {
            return false;
        }

        for (int i = s + 1; i < len; i++) {
            if (candidate == A[i]) {
                countRight++;
            }
        }
        if (countRight > halfRight) {
            return true;
        } else {
            return false;
        }
    }

    class LeaderStack {
        ArrayList<Integer> s = new ArrayList<Integer>();

        int size() {
            return s.size();
        }

        boolean isExistCandidate() {
            return s.size() > 0 ? true : false;
        }

        int candidate() {
            return peek();
        }

        int peek() {
            if (s.size() > 0)
                return s.get(s.size() - 1);
            throw new ArrayIndexOutOfBoundsException();
        }

        void pop() {
            if (s.size() > 0)
                s.remove(s.size() - 1);
        }

        void push(int a) {
            if (s.size() == 0) {
                s.add(a);
                return;
            }
            if (a != peek()) {
                pop();
            } else {
                s.add(a);
            }
        }
    }

    @Test
    public void testExample() {
        int[] A = { 4, 3, 4, 4, 4, 2 };
        assertEquals(2, new Solution2().solution(A));
    }

    @Test
    public void testExample2() {
        int[] A = { 4, 4, 2, 5, 3, 4, 4, 4 };
        assertEquals(3, new Solution2().solution(A));
    }

}
