package org.sjtu.gkq;

public class ArrayTest {
    public static void main(String[] args) {
//        ArrayTest test = new ArrayTest();
//        test.strStrTest();
//        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int result =  Solution.maxSubArray(a);
//        System.out.println(result);
//        double res = Solution.findMedianSortedArrays(a,b);
//        System.out.println(res);
        int a[] = {-1, 2, 10, 8, 6, 9 , 10, 12,7, 3, 5, -10};
//        heapSort hp = new heapSort(a);
//        hp.sort();
//        BubbleSort bb = new BubbleSort(a);
//        int[] tmp = new int[a.length];
//        bb.mergeSort(0, a.length, tmp);
//        quickSort qs = new quickSort(a);
//        qs.sort(0, a.length-1);
//        for(int i=0; i<tmp.length; i++) {
//            System.out.print(tmp[i]+" ");
//        }

    }
    public void strStrTest() {
        char[] strlong = new String("abcdef").toCharArray();
        char[] str = new String("ef").toCharArray();
        int res = Solution.strStr(strlong, str);
        System.out.print(res);
    }
    public  void twoSumTest(){
        int[] num = new int[5];
        for(int i=0; i< 5; i++)
            num[i] = i;
        int target = 6;

        int[] res = Solution.twoSum(num, target);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            System.out.print("\t");
        }

        }
    }
