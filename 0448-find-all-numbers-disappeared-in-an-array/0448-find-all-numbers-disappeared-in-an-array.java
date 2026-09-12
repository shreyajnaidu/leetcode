class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      HashMap<Integer,Integer> map=new HashMap<>(); 
        int range=nums.length;
        for(int i=0;i<range;i++){
               map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int j=1;j<=range;j++){
            map.put(j,map.getOrDefault(j,0)+1);
        }
        List<Integer> result=new ArrayList<>();
        for(int num:map.keySet()){
            if(map.get(num)==1){
                result.add(num);
            }
        }
        return result;
    }
}