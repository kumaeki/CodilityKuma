package l7_StacksAndQueues;

import java.util.ArrayList;

public class S3Nesting {
    public int solution(String S) {
        NestStack ns = new NestStack();
        for (char c : S.trim().toCharArray()) {
            ns.add(c);
        }
        return ns.size() == 0 ? 1 : 0;
    }

    class NestStack {

        static final char LEFT = '(';

        static final char RIGHT = ')';

        ArrayList<Character> stack = new ArrayList<Character>();

        Character peek() {
            if (stack.size() == 0) {
                return null;
            } else {
                return stack.get(stack.size() - 1);
            }
        }

        void pop() {
            if (stack.size() > 0)
                stack.remove(stack.size() - 1);
        }

        void push(char c) {
            stack.add(c);
        }

        void add(char c) {
            if (stack.size() == 0) {
                push(c);
                return;
            }
            if (LEFT == peek() && RIGHT == c) {
                pop();
            } else {
                push(c);
            }
        }

        int size() {
            return stack.size();
        }

    }

}
