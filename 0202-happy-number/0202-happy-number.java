class Solution {
    public boolean isHappy(int n) {
       HashMap<Integer,Integer> map=new HashMap<>();
       String s=Integer.toString(n);
       while(!s.equals("1")){
        int num=Integer.parseInt(s);
        int sum=0;
        if(map.containsKey(num)){
            return false;
        }
        map.put(num,1);
        for(int i=0;i<s.length();i++){
            int a=s.charAt(i)-'0';
            sum+=a*a;
        }
        s=Integer.toString(sum);
       }
       return true;
    }
}