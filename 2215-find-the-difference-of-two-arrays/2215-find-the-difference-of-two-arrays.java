class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    HashSet<Integer> set1=new HashSet<>();
    HashSet<Integer> set2=new HashSet<>();
    List<Integer> result1=new ArrayList<>();
    List<Integer> result2=new ArrayList<>();
    for(int i=0;i<nums1.length;i++){
        set1.add(nums1[i]);
    }
    for(int i=0;i<nums2.length;i++){
        set2.add(nums2[i]);
        if(!set1.contains(nums2[i]) && !result2.contains(nums2[i])){
            result2.add(nums2[i]);
        }
    }
    for(int i=0;i<nums1.length;i++){
        if(!set2.contains(nums1[i]) && !result1.contains(nums1[i])){
            result1.add(nums1[i]);
        }
    }
    List<List<Integer>> result=new ArrayList<>();
    result.add(result1);
    result.add(result2);
    return result;
    }
}