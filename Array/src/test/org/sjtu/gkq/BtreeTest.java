package org.sjtu.gkq;

import java.util.ArrayList;
import java.util.List;

public class BtreeTest {
    public static void main(String[] args){
        int a[] = {10, 3, 6, 8, 2, 4, 7, 5, 9, 1};
        BinaryTree bt = new BinaryTree();
//        for(int i=0; i<a.length; i++){
//            bt.push(a[i]);
//        }
        bt.root = bt.sortedArrayToBST(a);
        List<ArrayList<Integer>> res = bt.levelOrder(bt.root);
//        for(int i=0; i<res.size(); i++){
//            System.out.print(res.get(i) + " ");
//        }

    }
}
