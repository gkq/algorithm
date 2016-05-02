package org.sjtu.gkq;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryTree {
    public TreeNode root;

    class  TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

    public BinaryTree() {
        this.root = new TreeNode(-1);
    }

    public void push(int data) {
        buildTree(root, data);
    }

    private void buildTree(TreeNode node, int data) {
        if(node == null) {
            node = new TreeNode(data);
        }
        else if(node.val > data) {
            if(node.left == null){
                node.left = new TreeNode(data);
            }
            else buildTree(node.left, data);
        }
        else {
            if(node.right == null){
                node.right = new TreeNode(data);
            }
            else buildTree(node.right, data);
        }
    }

    public ArrayList preOrder(TreeNode node) {
        ArrayList res = new ArrayList();
        if(node != null) {
            res.add(node.val);
            res.addAll(preOrder(node.left));
            res.addAll(preOrder(node.right));
        }
        return res;
    }

    public ArrayList inOrder(TreeNode node){
        ArrayList res = new ArrayList();
        if(node != null){
            res.addAll(preOrder(node.left));
            res.add(node.val);
            res.addAll(preOrder(node.right));
        }
        return res;
    }

    public ArrayList postOrder(TreeNode node){
        ArrayList res = new ArrayList();
        if(node != null){
            res.addAll(preOrder(node.left));
            res.addAll(preOrder(node.right));
            res.add(node.val);
        }
        return res;
    }

    public ArrayList preOrder(){
        ArrayList res = new ArrayList();
        if(root == null) return res;
        TreeNode R = root;
        Stack<TreeNode> stack = new Stack<>();
        while(R != null || !stack.empty()){
            if(R != null){
                res.add(R.val);
                stack.push(R);
                R = R.left;
            }
            else{
                R = stack.pop().right;
            }
        }
        return res;
    }

    public ArrayList inOrder(){
        ArrayList res = new ArrayList();
        if(root == null) return res;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode R = root;
        while(R != null || !stk.empty()){
            if(R != null){
                stk.push(R);
                R = R.left;
            }
            else{
                R = stk.pop();
                res.add(R.val);
                R = R.right;
            }
        }
        return res;
    }

    public ArrayList postOrder(){
        ArrayList res = new ArrayList();
        if(root == null) return res;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode R = root;
        do{
            while(R != null){
                stk.push(R);
                R = R.left;
            }
            TreeNode q=null;
            while(!stk.empty()){
                R = stk.peek();
                if(R.right == q){
                    res.add(R.val);
                    stk.pop();
                    q = R;
                }
                else{
                    R = R.right;
                    break;
                }
            }
        }while(!stk.empty());
        return res;
    }

    public ArrayList levelOrder() {
        ArrayList res = new ArrayList();
        if(root == null) return res;
        Queue<TreeNode> dq = new LinkedBlockingQueue<TreeNode>();
        dq.add(root);
        while(!dq.isEmpty()){
            TreeNode p = dq.poll();
            res.add(p.val);
            if(p.left != null) dq.offer(p.left);
            if(p.right != null) dq.offer(p.right);
        }
        return res;
    }

    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        else
            return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;
        if(p.val == q.val)
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        else
            return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p.val>root.val && q.val>root.val)
            return lowestCommonAncestor(root.right, p, q);
        else if(p.val<root.val && q.val<root.val)
            return lowestCommonAncestor(root.left, p, q);
        else
            return root;
    }

    /**
     * unique BST
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        for(int i=1;i<=n;i++)
            for(int j=1;j<=i;j++)
                f[i] += f[j-1]*f[i-j];
        return f[n];
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        Stack<TreeNode> s = new Stack();
        TreeNode p = root;
        while(p!=null || !s.empty()){
            if(p!=null){
                s.push(p);
                p = p.left;
            }
            else{
                p = s.pop();
                k--;
                if(k==0) return p.val;
                p = p.right;
            }
        }
        return -1;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return fun(nums,0,nums.length-1);
    }

    private TreeNode fun(int[] nums, int i, int j){
        if(i>j) return null;
        int mid = i+(j-i)/2;
        TreeNode p = new TreeNode(nums[mid]);
        p.left = fun(nums,i,mid-1);
        p.right = fun(nums,mid+1,j);
        return p;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left,root.right);
    }
    private boolean isSymmetric(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return p.val==q.val && isSymmetric(p.left,q.right) && isSymmetric(q.left,p.right);
    }

    public boolean isBalanced(TreeNode root) {
        return BalancedHeight(root)>=0;
    }
    private int BalancedHeight(TreeNode R){
        if(R==null) return 0;
        int left = BalancedHeight(R.left);
        int right = BalancedHeight(R.right);
        if(left<0 || right<0 || Math.abs(left-right)>1)
            return -1;
        return Math.max(left,right)+1;
    }
}
