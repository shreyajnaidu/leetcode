class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb=new StringBuilder(s);
        Deque<Integer> st=new ArrayDeque();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else if(s.charAt(i)==')'){
                if(!st.isEmpty()){
                    st.pop();
                }else{
                    sb.setCharAt(i,'#');
                }
            }
        }
        while(!st.isEmpty()){
            sb.setCharAt(st.pop(),'#');
        }
        StringBuilder ans = new StringBuilder();

    for(int i = 0; i < sb.length(); i++) {
        if(sb.charAt(i) != '#') {
            ans.append(sb.charAt(i));
        }
    }
        return ans.toString();
    }
}