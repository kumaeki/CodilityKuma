package l8_Leader;

import java.util.ArrayList;

public class S1Dominator {
    public int solution(int[] A) {
        DominatorStack ds = new DominatorStack();
        for (int a : A) {
            ds.push(a);
        }
        if (ds.size() > 0) {
            int candidate = ds.candidate();
            int count = 0;
            int l = A.length;
            int half = l / 2;
            for (int i = 0; i < l; i++) {
                if (A[i] == candidate) {
                    count++;
                }
                if (count > half) {
                    return i;
                }
            }
            return -1;
        }

        return -1;
    }

    class DominatorStack {
        ArrayList<Integer> stack = new ArrayList<Integer>();

        int size() {
            return stack.size();
        }

        int candidate() {
            return peek();
        }

        int peek() {
            int s = stack.size();
            return s > 0 ? stack.get(s - 1) : 0;
        }

        void pop() {
            int s = stack.size();
            if (s > 0)
                stack.remove(s - 1);
        }

        void push(int a) {
            if (stack.size() == 0) {
                stack.add(a);
                return;
            }

            if (a != peek()) {
                pop();
            } else {
                stack.add(a);
            }
        }
    }
}
