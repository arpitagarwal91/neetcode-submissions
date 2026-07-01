class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mp = new HashMap<>();
        mp.put(')','(');
        mp.put('}','{');
        mp.put(']','[');
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(mp.containsKey(c) && !st.isEmpty() && st.peek()==mp.get(c)){
                st.pop();
                continue;
            }
            st.add(c);
        }
        return st.size()==0;
    }
}
