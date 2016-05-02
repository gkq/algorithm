package org.sjtu.gkq;

import java.util.ArrayList;

public class BtreeTest {
    public static void main(String[] args){
        int a[] = {10, 3, 6, 8, 2, 4, 7, 5, 9, 1};
        BinaryTree bt = new BinaryTree();
//        for(int i=0; i<a.length; i++){
//            bt.push(a[i]);
//        }
        bt.root = bt.sortedArrayToBST(a);
        ArrayList res = bt.levelOrder();
        for(int i=0; i<res.size(); i++){
            System.out.print(res.get(i) + " ");
        }

    }
}
