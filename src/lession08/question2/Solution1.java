package lession08.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Solution1 {
    public int solution(int[] A) {
        int count = 0;
        int len = A.length;
        for (int s = 0; s < len - 1; s++) {
            if (s < len / 2) {
                if (getLeaderAscend(s, A)) {
                    count++;
                }
            } else {
                if (getLeaderDescend(s, A)) {
                    count++;
                }
            }

        }

//        for (int s = 0; s < len - 1; s++) {
//            if (getLeaderAscend(s, A)) {
//                count++;
//            }
//
//        }

        return count;
    }

    boolean getLeaderAscend(int s, int[] A) {
        LeaderStack ls = new LeaderStack();
        int len = A.length;
        int count = 0;
        int half = (s + 1) / 2;
        int candidate;
        for (int i = 0; i <= s; i++) {
            ls.push(A[i]);
        }
        if (ls.isExistCandidate()) {
            candidate = ls.candidate();
            for (int i = 0; i <= s; i++) {
                if (candidate == A[i])
                    count++;
            }
            if (count <= half) {
                return false;
            }

            int countRight = 0;
            int halfRight = (len - s - 1) / 2;
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
        return false;
    }

    boolean getLeaderDescend(int s, int[] A) {
        LeaderStack ls = new LeaderStack();
        int len = A.length;
        int count = 0;
        int half = (len - s - 1) / 2;
        int candidate;
        for (int i = s + 1; i < len; i++) {
            ls.push(A[i]);
        }
        if (ls.isExistCandidate()) {
            candidate = ls.candidate();
            for (int i = s + 1; i < len; i++) {
                if (candidate == A[i])
                    count++;
            }
            if (count <= half) {
                return false;
            }

            int countLeft = 0;
            int halfLeft = (s + 1) / 2;
            for (int i = 0; i <= s; i++) {
                if (candidate == A[i]) {
                    countLeft++;
                }
            }
            if (countLeft > halfLeft) {
                return true;
            } else {
                return false;
            }
        }
        return false;
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
        assertEquals(2, new Solution1().solution(A));
    }

    @Test
    public void testExample2() {
        int[] A = { 4, 4, 2, 5, 3, 4, 4, 4 };
        assertEquals(3, new Solution1().solution(A));
    }

}
