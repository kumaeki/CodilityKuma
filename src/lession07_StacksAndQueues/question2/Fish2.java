package lession07_StacksAndQueues.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class Fish2 {
    public int solution(int[] A, int[] B) {
        FishStack s = new FishStack();
        for (int i = 0; i < A.length; i++) {
            s.add(new Fish(A[i], B[i]));
        }
        return s.size();
    }

    class Fish {
        static final int UPSTREAM = 0;
        static final int DOWNSTREAM = 1;
        int size;
        int direction;
        Fish(int size, int direction) {
            this.size = size;
            this.direction = direction;
        }
    }

    class FishStack {

        ArrayList<Fish> stack = new ArrayList<Fish>();

        int size() {
            return stack.size();
        }

        Fish peek() {
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

        void push(Fish f) {
            stack.add(f);
        }

        void add(Fish newfish) {
            if (stack.size() == 0) {
                stack.add(newfish);
                return;
            }
            Fish f = peek();

            while (stack.size() > 0) {
                if (f.direction == newfish.direction || f.direction == Fish.UPSTREAM) {
                    push(newfish);
                    break;
                } else {
                    if (newfish.size > f.size) {
                        pop();
                        f = peek();
                    }else {
                        break;
                    }
                }
            }
            if (stack.size() == 0) {
                stack.add(newfish);
            }
        }
    }

    @Test
    public void testExample1() {
        int[] A = { 4, 3, 2, 1, 5 };
        int[] B = { 0, 1, 0, 0, 0 };
        assertEquals(2, new Fish2().solution(A, B));
    }

    @Test
    public void test2fish1() {
        int[] A = { 1, 2 };
        int[] B = { 0, 1 };
        assertEquals(2, new Fish2().solution(A, B));
    }

    @Test
    public void test2fish2() {
        int[] A = { 1, 2 };
        int[] B = { 0, 0 };
        assertEquals(2, new Fish2().solution(A, B));
    }

    @Test
    public void test2fish3() {
        int[] A = { 1, 2 };
        int[] B = { 1, 1 };
        assertEquals(2, new Fish2().solution(A, B));
    }

    @Test
    public void test2fish4() {
        int[] A = { 1, 2 };
        int[] B = { 1, 0 };
        assertEquals(1, new Fish2().solution(A, B));
    }

    @Test
    public void test2fish5() {
        int[] A = { 2, 1 };
        int[] B = { 1, 0 };
        assertEquals(1, new Fish2().solution(A, B));
    }

    @Test
    public void test5fish1() {
        int[] A = { 1, 2, 3, 4, 5 };
        int[] B = { 0, 1, 1, 1, 0 };
        assertEquals(2, new Fish2().solution(A, B));
    }

}
