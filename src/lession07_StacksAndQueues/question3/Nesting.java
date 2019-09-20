package lession07_StacksAndQueues.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class Nesting {
    public int solution(String S) {
        Stack s = new Stack();
        for (char c : S.toCharArray()) {
            s.push(c);
        }
        return s.size() > 0 ? 0 : 1;
    }

    final static char LEFT = '(';
    final static char RIGHT = ')';

    class Stack {
        ArrayList<Character> list = new ArrayList<Character>();

        int size() {
            return list.size();
        }

        void pop() {
            list.remove(size() - 1);
        }

        char peek() {
            return list.get(size() - 1);
        }

        void push(char c) {
            if (size() == 0) {
                list.add(c);
            } else {
                if (peek() == LEFT && c == RIGHT) {
                    pop();
                } else {
                    list.add(c);
                }
            }
        }
    }

    @Test
    public void testExample1() {
        String S = "(()(())())";
        int result = 1;
        assertEquals(result, new Nesting().solution(S));
    }

    @Test
    public void testExample2() {
        String S = "())";
        int result = 0;
        assertEquals(result, new Nesting().solution(S));
    }
    
    @Test
    public void testSimple1() {
        String S = "";
        int result = 1;
        assertEquals(result, new Nesting().solution(S));
    }
}
