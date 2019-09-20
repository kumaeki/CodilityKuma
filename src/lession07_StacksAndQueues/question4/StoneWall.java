package lession07_StacksAndQueues.question4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class StoneWall {
    public int solution(int[] H) {
        Queue q = new Queue();
        for (int h : H) {
            q.push(h);
        }
        return q.getCount();
    }

    class Queue {
        LinkedList<Integer> list = new LinkedList<Integer>();

        int blockCount = 0;

        int getCount() {
            return blockCount + list.size();
        }

        void push(int h) {
            while (list.size() > 0) {
                int preH = list.getLast();
                if (preH > h) {
                    list.removeLast();
                    blockCount++;
                } else {
                    break;
                }
            }

            if (list.size() == 0 || list.getLast() < h) {
                list.addLast(h);
            }
        }
    }

    @Test
    public void testExample() {
        int[] H = { 8, 8, 5, 7, 9, 8, 7, 4, 8 };
        int result = 7;
        assertEquals(result, new StoneWall().solution(H));
    }

    @Test
    public void testSimple1() {
        int[] H = { 8, 8, 8 };
        int result = 1;
        assertEquals(result, new StoneWall().solution(H));
    }
}
