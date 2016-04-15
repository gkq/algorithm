package org.sjtu.gkq;

public class ArrayTest {
    public static void main(String[] args) {
        int[] num = new int[5];
        for(int i=0; i< 5; i++)
            num[i] = i;
        int target = 6;

        int[] res = Solution.twoSum(num, target);
    }

}
