class Solution {
    public void solve(int[] nums,int start,List<List<Integer>> result,List<Integer> current){
        result.add(new ArrayList<>(current));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            current.add(nums[i]);
            solve(nums,i+1,result,current);
            current.remove(current.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        solve(nums,0,result,current);
        return result;
    }
}