class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        HashMap<Character,String> map1=new HashMap<>();
        HashMap<String, Character> map2=new HashMap<>();
        if(words.length != pattern.length()){
            return false;
            }
        for(int i=0;i<pattern.length();i++){
            char ch1=pattern.charAt(i);
            String ch2=words[i];
            if(map1.containsKey(ch1)){
                if(!map1.get(ch1).equals(ch2)){
                    return false;
                }
            }else{
                map1.put(ch1,ch2);
            }
            if(map2.containsKey(ch2)){
                if(map2.get(ch2)!=ch1){
                    return false;
                }
            }else{
                    map2.put(ch2,ch1);
                }
        }
        return true;
    }
}