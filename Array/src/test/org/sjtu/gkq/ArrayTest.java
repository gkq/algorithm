package org.sjtu.gkq;

public class ArrayTest {
    public static void main(String[] args) {
        ArrayTest test = new ArrayTest();
        test.strStrTest();

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
