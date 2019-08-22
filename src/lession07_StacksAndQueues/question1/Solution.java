package lession07_StacksAndQueues.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class Solution {
    public int solution(String S) {
        if (S == null || S.trim().isEmpty()) {
            return 1;
        }
        mystack stack = new mystack();
        for (char c : S.toCharArray()) {
            stack.add(c);
        }
        if (stack.size() == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    class mystack {

        static final char LEFT1 = '(';
        static final char LEFT2 = '[';
        static final char LEFT3 = '{';
        static final char RIGHT1 = ')';
        static final char RIGHT2 = ']';
        static final char RIGHT3 = '}';

        ArrayList<Character> stack = new ArrayList<Character>();

        public mystack() {

        }

        void pop() {
            if (stack.size() > 0)
                stack.remove(stack.size() - 1);
        };

        void push(char c) {
            stack.add(c);
        };

        char peek() {
            return stack.get(stack.size() - 1);
        }

        public void add(char c) {
            if (stack.size() == 0) {
                push(c);
                return;
            }
            if ((c == RIGHT1 && peek() == LEFT1) 
                    || (c == RIGHT2 && peek() == LEFT2)
                    || (c == RIGHT3 && peek() == LEFT3)) {
                pop();
            } else {
                push(c);
            }
        }

        public int size() {
            return stack.size();
        }

    }

    @Test
    public void testExample1() {
        String S = "{[()()]}";
        assertEquals(1, new Solution().solution(S));
    }

    @Test
    public void testExample2() {
        String S = "([)()]";
        assertEquals(0, new Solution().solution(S));
    }

}
