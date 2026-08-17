class Solution {
    public boolean isValid(String s) {
        Deque<Character> st=new ArrayDeque();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                st.push(s.charAt(i));
            }else if(s.charAt(i)==')' || s.charAt(i)=='}'||s.charAt(i)==']'){
                if(st.isEmpty()){
                    return false;
                }
                if(s.charAt(i)==')'){
                    if(st.peek()=='('){
                        st.pop();
                    }else{
                        return false;
                    }
                }else if(s.charAt(i)=='}'){
                    if(st.peek()=='{'){
                        st.pop();
                    }else{
                        return false;
                    }
                }else if(s.charAt(i)==']'){
                    if(st.peek()=='['){
                        st.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}