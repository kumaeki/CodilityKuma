package lession07_StacksAndQueues.question4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class Solution {
    public int solution(int[] H) {
        StoneStack ss = new StoneStack();
        for (int h : H)
            ss.add(h);
        return ss.size();
    }

    class StoneStack {
        int blocks = 0;
        ArrayList<Integer> stack = new ArrayList<Integer>();

        int size() {
            return blocks;
        }

        int peek() {
            int s = stack.size();
            if (s > 0) {
                return stack.get(s - 1);
            } else {
                return 0;
            }

        }

        int pop() {
            int s = stack.size();
            if (s > 0) {
                return stack.remove(s - 1);
            } else {
                return 0;
            }

        }

        void push(Integer h) {
            stack.add(h);
        }

        void add(Integer h) {
            if (stack.size() == 0) {
                push(h);
                blocks++;
                return;
            }

            int preH = peek();
            while (stack.size() > 0) {
                if (preH == h) {
                    return;
                } else if (preH > h) {
                    pop();
                    preH = peek();
                }
                // preh < h
                else {
                    push(h);
                    blocks++;
                    break;
                }
            }

            if (stack.size() == 0) {
                blocks++;
                push(h);
            }
        }

    }

    @Test
    public void testExample() {
        int[] H = { 8, 8, 5, 7, 9, 8, 7, 4, 8 };
        assertEquals(7, new Solution().solution(H));
    }

    @Test
    public void testLargePiramid() {
        int[] H = new int[100000];
        for (int i = 0; i < 50000; i++) {
            H[i] = i + 1;
        }
        for (int i = 0; i < 50000; i++) {
            H[99999 - i] = i + 1;
        }
        assertEquals(50000, new Solution().solution(H));
    }

}
