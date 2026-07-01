class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }
            else{
                if(!stack.isEmpty() && map.get(s.charAt(i)) == stack.peek()){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
