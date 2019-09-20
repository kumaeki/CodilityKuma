package lesson91_2016Challenge.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class TreeProduct2 {

    public String solution(int[] A, int[] B) {

        int n = A.length;
        long max = n + 1;
        TreePost tree = new TreePost(n);
        for (int i = 0; i < n; i++) {
            tree.add(A[i], B[i]);
        }
        Post[] postArray = tree.postArray;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Post p : postArray) {
            if (p.weight < n + 1 && p.weight > 1)
                list.add(p.position);
        }

        int m = list.size();
        for (int i = 0; i < m; i++) {
            int position1 = list.get(i);
            long count2 = postArray[position1].weight;
            long count1 = n + 1 - count2;
            max = Math.max(max, count1 * count2);

            for (int j = i + 1; j < m; j++) {
                int position2 = list.get(j);
                long count4 = postArray[position2].weight;
                if (postArray[position2].isParent(position1)) {
                    long count3 = count2 - count4;
                    max = Math.max(max, count1 * count3 * count4);
                } else {
                    long count3 = count1 - count4;
                    max = Math.max(max, count2 * count3 * count4);
                }
            }
        }

        return String.valueOf(max);
    }

    class TreePost {

        ArrayList<Post> roots;
        Post[] postArray;

        public TreePost(int n) {
            roots = new ArrayList<Post>();
            postArray = new Post[n + 1];
            for (int i = 0; i < n + 1; i++) {
                postArray[i] = new Post(i);
            }
        }

        boolean isRoot(int position) {
            for (Post p : roots) {
                if (p.position == position) {
                    return true;
                }
            }
            return false;
        }

        void add(int parentP, int childP) {
            if (postArray[parentP].getParentsLen() < postArray[childP].getParentsLen()) {
                int temp = parentP;
                parentP = childP;
                childP = temp;
            }
            reverseBranch(childP);
            connectPost(parentP, childP);
            if (postArray[parentP].parent == null && !isRoot(parentP)) {
                roots.add(postArray[parentP]);
            }
        }

        void connectPost(int parentP, int childP) {
            postArray[childP].addParent(postArray[parentP]);
            postArray[parentP].addChild(postArray[childP]);
            int childWeight = postArray[childP].weight;
            Post parentPost = postArray[parentP].parent;
            while (parentPost != null) {
                parentPost.addWeight(childWeight);
                parentPost = parentPost.parent;
            }
        }

        void reverseBranch(int start) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.add(start);
            Post parent = postArray[start].parent;
            while (parent != null) {
                list.add(parent.position);
                parent = parent.parent;
            }

            int childPosition = list.removeLast();
            roots.remove(postArray[childPosition]);
            while (list.size() != 0) {
                int parentPosition = list.removeLast();
                postArray[childPosition].removeChildren(postArray[parentPosition]);
                postArray[parentPosition].removeParent();
                connectPost(parentPosition, childPosition);
                childPosition = parentPosition;
            }
        }

    }

    class Post {

        // the post number
        int position;
        // the count of children
        int weight;
        Post parent;
        HashSet<Post> children;

        public Post(int p) {
            this.position = p;
            children = new HashSet<Post>();
            weight = 1;
        }

        boolean isParent(int p) {
            Post parentTemp = parent;
            while (parentTemp != null) {
                if (parentTemp.position == p)
                    return true;
                else
                    parentTemp = parentTemp.parent;
            }
            return false;
        }

        int getParentsLen() {
            int count = 0;
            Post tempParent = parent;
            while (tempParent != null) {
                count++;
                tempParent = tempParent.parent;
            }
            return count;
        }

        void addParent(Post post) {
            parent = post;
        }

        void addChild(Post post) {
            children.add(post);
            addWeight(post.weight);
        }

        void removeParent() {
            parent = null;
        }

        void removeChildren(Post post) {
            for (Post p : children) {
                if (p.position == post.position) {
                    children.remove(post);
                    subtractWeight(post.weight);
                    break;
                }
            }
        }

        void addWeight(int w) {
            weight += w;
        }

        void subtractWeight(int w) {
            weight -= w;
        }

    }

    @Test
    public void testSimple1() {
        int[] A = { 0, 1, 6, 1, 3, 3, 7 };
        int[] B = { 1, 2, 3, 3, 4, 5, 5 };
        String result = "18";
        assertEquals(result, new TreeProduct2().solution(A, B));
    }

    @Test
    public void testExample1() {
        int[] A = { 0, 1, 1, 3, 3, 6, 7 };
        int[] B = { 1, 2, 3, 4, 5, 3, 5 };
        String result = "18";
        assertEquals(result, new TreeProduct2().solution(A, B));
    }

    @Test
    public void testExample2() {
        int[] A = { 0, 1 };
        int[] B = { 1, 2 };
        String result = "3";
        assertEquals(result, new TreeProduct2().solution(A, B));
    }

    @Test
    public void testMediunm1() {
        int[] A = new int[299];
        int[] B = new int[299];

        A[0] = 0;
        B[0] = 1;

        A[1] = 0;
        B[1] = 81;

        A[2] = 0;
        B[2] = 183;

        for (int i = 3; i < 82; i++) {
            A[i] = 1;
            B[i] = i - 1;
        }
        for (int i = 82; i < 183; i++) {
            A[i] = 81;
            B[i] = i;
        }
        for (int i = 183; i < 299; i++) {
            A[i] = 183;
            B[i] = i + 1;
        }

        String result = "966654";
        assertEquals(result, new TreeProduct2().solution(A, B));
    }

}
