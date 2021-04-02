package Midterm;

import class1.BinaryTree;
import class1.Node;

import java.util.Stack;

class Solution {
    //q1
    //Time: n
    //Space: n
    public boolean areConverging(ListNode n1, ListNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        ListNode p=n1,q=n2;

        int len1=0,len2=0;
        while(p != null) {p =p.next;len1++; }
        while(q != null) { q = q.next;len2++; }
        p = n1;q = n2;
        if(len1 > len2){
            while(len1 - len2 > 0) { p = p.next;len1--;}
        }
        else{
            while(len2 - len1 > 0) { q = q.next;len2--; }
        }
        System.out.println(len1+" "+len2);

        while(p != null) {
            if(p.val != q.val){
                p = p.next;q = q.next;
            }
            else
                return true;
        }
        return false;
    }

    //q2 Time: n    Space: n
    public void printPerimeter(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        printPerimeter(root,0,0, stack);
        while (!stack.isEmpty()){
            System.out.printf(stack.pop().val + ", ");
        }
        System.out.println("");
    }

    private void printPerimeter(TreeNode node, int left, int right, Stack<TreeNode> stack){
        if (node != null){
            if (node.left == null && node.right == null){
                System.out.printf(node.val + ", ");
            } else {
                if (right == 0){
                    System.out.printf(node.val + ", ");
                } else if (left == 0){
                    stack.push(node);
                }

            }
              printPerimeter(node.right,left,right + 1,stack);
            printPerimeter(node.left, left + 1,right,stack);

        }
    }

    //q3 Time: n Space: n
    public int getMaxConsecutiveOnes(int[] nums){
        int ans = 0;
        int [] f = new int [10000];
        for(int i = 0;i < nums.length; i++){
            if(nums[i] == 0) f[i] = 0;
            else {
                if(i > 0) f[i]=f[i-1]+1;
                else f[i]=1;
            }
            ans = Math.max(f[i],ans);
        }
        return ans;
    }

    //q4
    //Time: O(logN)
    //Space: O(N)
    public int getIndex (int[] nums, int x){
        int l = 0,r = nums.length-1;
        int pos = r;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] >= x) {
                pos = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return pos;
    }

    public static void main(String[] args) {
        //q1
        Solution sol = new Solution();

        ListNode n13 = new ListNode(4);
        ListNode n12 = new ListNode(3,n13);
        ListNode n11 = new ListNode(2,n12);
        ListNode n1 = new ListNode(1, n11);

        ListNode n21 = new ListNode(4);
        ListNode n2 = new ListNode(3, n21);

        ListNode n31 = new ListNode(6);
        ListNode n3 = new ListNode(5,n31);


        System.out.println(sol.areConverging(n1,n2));
        System.out.println(sol.areConverging(n3,n2));

        //q2
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        sol.printPerimeter(root);

        //q3
        int nums[]={0,1,0,1,1,0,1,1,1,0,0,0};
        System.out.println(sol.getMaxConsecutiveOnes(nums));

        int nums1[]={0};
        System.out.println(sol.getMaxConsecutiveOnes(nums1));

        //q4
        int nums3[] = {2,4,4,4,6,7,7,7,8,9,9};
        System.out.println(sol.getIndex(nums3,9));

    }
}