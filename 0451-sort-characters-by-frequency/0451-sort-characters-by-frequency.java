class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> pq=new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(char ch : map.keySet()){
            pq.add(ch);
        }
        while(!pq.isEmpty()){
            char ch=pq.poll();
            int i=map.get(ch);
            while(i>0){
                sb.append(ch);
                i--;
            }
        }
        return sb.toString();
    }
}