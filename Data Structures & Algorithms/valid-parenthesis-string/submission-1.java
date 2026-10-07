class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> asterisks = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                open.add(i);
            }
            else if(c=='*'){
                asterisks.add(i);
            }
            else{
                if(!open.isEmpty()){
                    open.pop();
                }
                else if(!asterisks.isEmpty()){
                    asterisks.pop();
                }
                else return false;
            }
        }

        while(!open.isEmpty() && !asterisks.isEmpty()){
            if(open.pop()>asterisks.pop()) return false;
        }
        return open.isEmpty();
    }
}
