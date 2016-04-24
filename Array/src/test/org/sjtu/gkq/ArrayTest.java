package org.sjtu.gkq;

public class ArrayTest {
    public static void main(String[] args) {
//        ArrayTest test = new ArrayTest();
//        test.strStrTest();
//        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int result =  Solution.maxSubArray(a);
//        System.out.println(result);
        int[] a = {1,3,4,5};
        int[] b = {2,8,10,12};
        double res = Solution.findMedianSortedArrays(a,b);
        System.out.println(res);

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
