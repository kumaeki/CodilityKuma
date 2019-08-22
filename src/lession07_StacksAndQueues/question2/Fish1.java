package lession07_StacksAndQueues.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class Fish1 {

    final static int UPSTREAM = 0;
    final static int DOWNSTREAM = 1;

    class FishEntity {
        int size;
        int direction;

        FishEntity(int s, int d) {
            size = s;
            direction = d;
        }
    }

    class Stack {
        ArrayList<FishEntity> list = new ArrayList<FishEntity>();

        int size() {
            return list.size();
        }

        FishEntity peek() {
            return list.get(size() - 1);
        }

        void pop() {
            list.remove(size() - 1);
        }

        void push(int fishSize, int direction) {
            if (size() == 0) {
                list.add(new FishEntity(fishSize, direction));
                return;
            }
            boolean addFlg = true;
            while (size() > 0) {
                FishEntity preFish = peek();
                if (preFish.direction == DOWNSTREAM && direction == UPSTREAM) {
                    if (preFish.size < fishSize) {
                        pop();
                    } else {
                        addFlg = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (addFlg) {
                list.add(new FishEntity(fishSize, direction));
            }
        }
    }

    public int solution(int[] A, int[] B) {
        Stack s = new Stack();
        int N = A.length;
        for (int i = 0; i < N; i++) {
            s.push(A[i], B[i]);
        }
        return s.size();
    }

    @Test
    public void testExample() {
        int[] A = { 4, 3, 2, 1, 5 };
        int[] B = { 0, 1, 0, 0, 0 };
        int result = 2;
        assertEquals(result, new Fish1().solution(A, B));
    }

    @Test
    public void testSimple1() {
        int[] A = { 4, 8, 2, 3, 6, 7, 5, 10 };
        int[] B = { 0, 1, 1, 1, 1, 0, 0, 0 };
        int result = 2;
        assertEquals(result, new Fish1().solution(A, B));
    }
    
    @Test
    public void testSimple2() {
        int[] A = { 4 };
        int[] B = { 0};
        int result = 1;
        assertEquals(result, new Fish1().solution(A, B));
    }
}
