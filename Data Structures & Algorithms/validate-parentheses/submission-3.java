class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> mp = new HashMap();
        mp.put(']','[');
        mp.put('}','{');
        mp.put(')','(');
        Stack<Character> stack = new Stack<Character>();
        for(Character c:s.toCharArray()){
            if(mp.containsKey(c) && stack.size()>0 && stack.peek()==mp.get(c)){
                stack.pop();
            }
            else{
                stack.add(c);
            }
        }
        return stack.size()==0;
    }
}
