package org.sjtu.gkq;
import java.util.HashMap;

public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        int[]  idxRes = new int[2];
        HashMap map = new HashMap();
        for(int i=0; i< nums.length; i++)
            map.put(nums[i], i);
        for(int i=0; i< nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp) && ( ( (int) map.get(tmp) )!= i) ) {
                idxRes[0] = i;
                idxRes[1] = (int) map.get(tmp);
                break;
            }
        }
        return idxRes;
    }
    public static int strStr(char[] strlen, char[] str){
        int j = 0;
        for(int i=0; i < strlen.length; ) {
            int old = i;
            while(i< strlen.length && j < str.length &&strlen[i] == str[j] ){
                i++;
                j++;
            }
            if(j == str.length)
                return old;
            else {
                j = 0;
                i = old + 1;
            }
        }
        return -1;
    }
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int tmp = res;
        for(int i=1; i<nums.length; i++){
            tmp = Math.max(tmp+nums[i], nums[i]);
            res = Math.max(res, tmp);
        }
        return res;
    }

}
