package lession08.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Solution3 {
    public int solution(int[] A) {

        LeaderStack s = new LeaderStack();
        int len = A.length;
        int candidate;
        int count = 0;
        int half = len / 2;
        int[] countA = new int[len];
        int result = 0;

        for (int i = 0; i < len; i++) {
            s.push(A[i]);
        }
        if (!s.isExistCandidate()) {
            return 0;
        }

        candidate = s.candidate();
        for (int i = 0; i < len; i++) {
            if (candidate == A[i])
                count++;
            countA[i] = count;

        }
        if (count < half) {
            return 0;
        }

        for (int i = 0; i < len; i++) {
            int halfLeft = (i + 1) / 2;
            int halfRight = (len - i - 1) / 2;
            int numLeft = countA[i];
            int numRight = countA[len - 1] - countA[i];
            if (numLeft > halfLeft && numRight > halfRight) {
                result++;
            }
        }

        return result;
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
        assertEquals(2, new Solution3().solution(A));
    }

    @Test
    public void testExample2() {
        int[] A = { 4, 4, 2, 5, 3, 4, 4, 4 };
        assertEquals(3, new Solution3().solution(A));
    }

}
