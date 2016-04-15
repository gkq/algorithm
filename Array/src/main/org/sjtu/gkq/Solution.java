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
}
