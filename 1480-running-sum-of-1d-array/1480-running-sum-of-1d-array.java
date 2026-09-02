class Solution {
    public void sum(int[] nums,int i,int[] result,int sum){
        if(i==nums.length) return;
        sum+=nums[i];
        result[i]=sum;
        sum(nums,i+1,result,sum);
    }
    public int[] runningSum(int[] nums) {
        int[] result=new int[nums.length];
        sum(nums,0,result,0);
        return result;
    }
}