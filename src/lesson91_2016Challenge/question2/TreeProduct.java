package lesson91_2016Challenge.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class TreeProduct {

    public String solution(int[] A, int[] B) {

        int n = A.length;
        long max = n + 1;
        TreePost tree = new TreePost(n);
        for (int i = 0; i < n; i++) {
            tree.add(A[i], B[i]);
        }

        tree.split(A[0], B[0]);
        max = Math.max(tree.getCount(), max);
        for (int i = 1; i < n; i++) {
            tree.add(A[i - 1], B[i - 1]);
            tree.split(A[i], B[i]);
            max = Math.max(tree.getCount(), max);

            for (int j = 0; j < i; j++) {
                tree.split(A[j], B[j]);
                max = Math.max(tree.getCount(), max);
                tree.add(A[j], B[j]);
            }
        }

        return String.valueOf(max);
    }

    class TreePost implements Cloneable {

        ArrayList<Post> roots;
        Post[] postArray;

        public TreePost(int n) {
            roots = new ArrayList<Post>();
            postArray = new Post[n + 1];
            for (int i = 0; i < n + 1; i++) {
                postArray[i] = new Post(i);
            }
        }

        long getCount() {
            long count = 1;
            for (Post p : roots) {
                count *= p.weight;
            }
            return count;
        }

        boolean isRootExist(int position) {
            for (Post p : roots) {
                if (p.position == position) {
                    return true;
                }
            }
            return false;
        }

        void add(int parentP, int childP) {
            LinkedList<Integer> tempListChild = new LinkedList<Integer>();
            tempListChild.add(childP);
            Post tempParentChild = postArray[childP].parent;
            while (tempParentChild != null) {
                tempListChild.add(tempParentChild.position);
                tempParentChild = tempParentChild.parent;
            }

            LinkedList<Integer> tempListParent = new LinkedList<Integer>();
            tempListParent.add(parentP);
            Post tempParentParent = postArray[parentP].parent;
            while (tempParentParent != null) {
                tempListParent.add(tempParentParent.position);
                tempParentParent = tempParentParent.parent;
            }

            LinkedList<Integer> tempList = tempListChild;
            if (tempListParent.size() < tempListChild.size()) {
                tempList = tempListParent;
                int temp = parentP;
                parentP = childP;
                childP = temp;
            }

            int tempChildP = tempList.getLast();
            roots.remove(postArray[tempChildP]);
            if (postArray[parentP].parent == null && !isRootExist(parentP)) {
                roots.add(postArray[parentP]);
            }
            tempList.removeLast();
            while (tempList.size() != 0) {
                int tempParentP = tempList.getLast();
                postArray[tempParentP].removeParent();
                postArray[tempChildP].removeChildren(postArray[tempParentP]);

                connectPost(tempParentP, tempChildP);
                tempChildP = tempParentP;
                tempList.removeLast();
            }

            connectPost(parentP, childP);
            if (isRootExist(childP)) {
                roots.remove(postArray[childP]);
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

        void split(int parentP, int childP) {
            if (postArray[childP].parent == null || postArray[childP].parent.position != parentP) {
                int temp = parentP;
                parentP = childP;
                childP = temp;
            }
            postArray[parentP].removeChildren(postArray[childP]);
            postArray[childP].removeParent();
            int childWeight = postArray[childP].weight;
            Post parentPost = postArray[parentP].parent;
            while (parentPost != null) {
                parentPost.subtractWeight(childWeight);
                parentPost = parentPost.parent;
            }
            roots.add(postArray[childP]);
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
        assertEquals(result, new TreeProduct().solution(A, B));
    }

    @Test
    public void testExample1() {
        int[] A = { 0, 1, 1, 3, 3, 6, 7 };
        int[] B = { 1, 2, 3, 4, 5, 3, 5 };
        String result = "18";
        assertEquals(result, new TreeProduct().solution(A, B));
    }

    @Test
    public void testExample2() {
        int[] A = { 0, 1 };
        int[] B = { 1, 2 };
        String result = "3";
        assertEquals(result, new TreeProduct().solution(A, B));
    }

}
