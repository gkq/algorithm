package org.sjtu.gkq;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
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

}
