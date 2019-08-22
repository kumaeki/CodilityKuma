package lession07_StacksAndQueues.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class Brackets {

    final static char LEFT1 = '(';
    final static char RIGHT1 = ')';
    final static char LEFT2 = '{';
    final static char RIGHT2 = '}';
    final static char LEFT3 = '[';
    final static char RIGHT3 = ']';

    public int solution(String S) {
        Stacks s = new Stacks();
        for (char c : S.toCharArray()) {
            s.push(c);
        }
        return s.size() == 0 ? 1 : 0;
    }

    class Stacks {
        ArrayList<Character> list = new ArrayList<Character>();

        public int size() {
            return list.size();
        }

        public char peek() {
            return list.get(list.size() - 1);
        }

        public void pop() {
            list.remove(list.size() - 1);
        }

        public void push(Character c) {
            if (size() == 0) {
                list.add(c);
            } else {
                char p = peek();
                if ((p == LEFT1 && c == RIGHT1) || (p == LEFT2 && c == RIGHT2) || (p == LEFT3 && c == RIGHT3)) {
                    pop();
                } else {
                    list.add(c);
                }
            }
        }
    }

    @Test
    public void testExample1() {
        String S = "{[()()]}";
        int result = 1;
        assertEquals(result, new Brackets().solution(S));
    }

    @Test
    public void testExample2() {
        String S = "([)()]";
        int result = 0;
        assertEquals(result, new Brackets().solution(S));
    }

    @Test
    public void testSimple1() {
        String S = "";
        int result = 1;
        assertEquals(result, new Brackets().solution(S));
    }

}
