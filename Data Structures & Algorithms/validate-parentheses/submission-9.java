class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(!map.containsKey(c)) st.push(c);
            else{
                if(!st.isEmpty() && st.peek()==map.get(c)) st.pop();
                else return false;
            }
        }
        return st.size()==0;
    }
}
