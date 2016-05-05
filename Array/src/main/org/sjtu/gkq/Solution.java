package org.sjtu.gkq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        double result;
        if(total%2==1)
            result = find_kth(nums1, 0, nums2, 0, total/2+1);
        else
            result = (find_kth(nums1, 0, nums2, 0, total/2+1) + find_kth(nums1, 0, nums2, 0, total/2))/2;
        return result;



    }
    private static double find_kth(int[] A,int m,int[]B,int n,int k){
        if(A.length-m<B.length-n)
            return find_kth(B,n,A,m,k);
        if(n==B.length)
            return A[m+k-1];
        if(k==1)
            return Math.min(A[m],B[n]);
        int ib = Math.min(k/2, B.length-n);
        int ia = k - ib;
        if(A[m+ia-1]==B[n+ib-1])
            return A[m+ia-1];
        else if(A[m+ia-1]>B[n+ib-1])
            return find_kth(A,m,B,n+ib,k-ib);
        else
            return find_kth(A,m+ia,B,n,k-ia);

    }
    public static  int candy(int[] ratings) {
        int[] cost = new int[ratings.length];
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1])
                cost[i] = cost[i-1] + 1;
        }
        for(int j = ratings.length-2; j>=0; j--){
            if(ratings[j]>ratings[j+1])
                cost[j] = Math.max(cost[j], cost[j+1]+1);
        }
        int result = ratings.length;
        for(int i =0;i<cost.length;i++){
            result += cost[i];
        }
        return result;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, tmp = 0, idx = 0;
        for(int i=0; i<gas.length; i++){
            sum += gas[i] - cost[i];
            tmp += gas[i] - cost[i];
            if(tmp<0){
                idx = i+1;
                tmp = 0;
            }
        }
        return sum>=0 ? idx : -1;
    }

    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]>prices[i-1])
                sum += prices[i] - prices[i-1];
        }
        return sum;
    }

    public boolean canJump(int[] nums) {
        if(nums.length == 0)
            return false;
        int right = nums[0];
        for(int i=1; i<=right && right<nums.length; i++){
            right = Math.max(right,i+nums[i]);
        }
        return right >= nums.length - 1;
    }

    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int step = 1;
        int left = 0, right = nums[0];
        while(right<nums.length-1){
            int oldright = right;
            for(int i=left; i<=oldright; i++){
                if(i+nums[i]>right){
                    right = i+nums[i];
                    left = i+1;
                }
            }
            step++;

        }
        return step;
    }

    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        if(n==0) return res;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0; right[n-1] = 0;
        for(int i=1; i<n; i++){
            left[i] = Math.max(height[i-1],left[i-1]);
            right[n-i-1] = Math.max(height[n-i],right[n-i]);
        }
        for(int i=1; i<n-1; i++){
            int tmp = Math.min(left[i],right[i]) - height[i];
            if(tmp>0)
                res += tmp;
        }
        return res;
    }

    public int maxProduct(int[] nums) {
        int res =nums[0]; int neg = nums[0]; int pos = nums[0];
        for(int i=1; i<nums.length; i++){
            int tmp = Math.max(Math.max(neg*nums[i], pos*nums[i]), nums[i]);
            res = Math.max(tmp, res);
            int ptmp = Math.max(Math.max(pos*nums[i], neg*nums[i]), nums[i]);
            neg = Math.min(Math.min(neg*nums[i], pos*nums[i]), nums[i]);
            pos = ptmp;
        }
        return res;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(n==0) return null;
        int[] res = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1; right[n-1] = 1;
        for(int i=1; i< n; i++){
            left[i] = left[i-1]*nums[i-1];
            right[n-i-1] = right[n-i]*nums[n-i];
        }
        for(int i=0; i<n; i++){
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for(int i=0; i<nums.length; i++){
            if(count==0){
                res = nums[i];
                count = 1;
                continue;
            }
            if(nums[i]==res)
                count++;
            else count--;
        }
        return res;
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        if(n==0) return -1;
        for(int i=0; i<n; i++){
            while(nums[i]!=i && nums[i]<n){
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i]!=i)
                return i;
        }
        return n;
    }

//    public List<Integer> majorityElement(int[] nums) {
//        List<Integer> res = new ArrayList<Integer>();
//        if(nums.length==0) return res;
//        int major1 = 0, major2 = 0;
//        int count1 = 0, count2 = 0;
//        for(int i=0; i<nums.length; i++){
//            if(count1 == 0){
//                major1 = nums[i];
//                count1 = 1;
//                continue;
//            }
//            else if(count2 == 0){
//                major2 = nums[i];
//                count2 = 1;
//            }
//            else {
//                if(nums[i]==major1)
//                        count1++;
//                else if(nums[i] == major2)
//                        count2++;
//                else{
//                    count1--;
//                    count2--;
//                }
//            }
//        }
//    }
}
