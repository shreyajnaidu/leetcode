class Solution {
    public int countGoodSubstrings(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int count=0;
        if(s.length()<3){
            return 0;
        }
        for(int right=0;right<3;right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
        }
        if(map.size()==3){
            count++;
        }
        if(s.length()==3){
            return count;
        }
        for(int right=3;right<s.length();right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
        
            while(right-left>2){
                map.put(s.charAt(left),
                        map.get(s.charAt(left)) - 1);

                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            if(map.size()==3){
                count++;
            }
        }
        return count;
        }
    }
