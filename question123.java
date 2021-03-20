package Assignment6;

import java.util.ArrayList;
import java.util.List;

public class question123 {

    /*
    question1
    */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return walkThru(s, t);
    }

    public boolean walkThru(TreeNode s, TreeNode t) {
        return s != null && (isSameTree(s, t)
                || walkThru(s.left, t)
                || walkThru(s.right, t));
    }

    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.val == node2.val
                && isSameTree(node1.left, node2.left)
                && isSameTree(node1.right, node2.right);
    }

    /*
    question2
    */
    ArrayList<Integer> arr;
    boolean completed = false;
    int[] asteroids;

    public int[] asteroidCollision(int[] asteroids) {
        this.asteroids = asteroids;

        while (!completed) {
            arr = new ArrayList<>();
            arr = walkThrough(this.asteroids);
            completed = completed(arr);
        }
        int[] res = new int[arr.size()];
        int counter = 0;
        for (int num : arr) {
            res[counter] = num;
            counter++;
        }
        return res;
    }

    public ArrayList<Integer> walkThrough(int[] asteroids) {
        int i;
        boolean dealtWithLast = false;

        for (i = 0; i < asteroids.length - 1; i++) {

            if (asteroids[i] > 0 && asteroids[i + 1] < 0) {
                if (i + 2 == asteroids.length) {
                    dealtWithLast = true;
                }
                if (asteroids[i] > (-1 * asteroids[i + 1])) {
                    arr.add(asteroids[i]);
                    i = i + 1;
                } else if (asteroids[i] < (-1 * asteroids[i + 1])) {
                    arr.add(asteroids[i + 1]);
                    i = i + 1;
                } else if (asteroids[i] == (-1 * asteroids[i + 1])) {
                    i = i + 1;
                }
            } else {
                arr.add(asteroids[i]);
            }
        }

        if (!dealtWithLast) {
            arr.add(asteroids[i]);
        }

        this.asteroids = new int[arr.size()];
        int counter = 0;
        for (int num : arr) {
            this.asteroids[counter] = num;
            counter++;
        }

        return arr;
    }

    public boolean completed(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > 0 && arr.get(i + 1) < 0) {
                return false;
            }
        }
        return true;
    }
}
