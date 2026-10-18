class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> asterisks = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') open.push(i);
            else if(s.charAt(i)=='*'){
                 asterisks.push(i);
            }
            else{
                if(!open.isEmpty()) open.pop();
                else if(!asterisks.isEmpty()) asterisks.pop();
                else return false;
            }
        }
        while(!open.isEmpty() && !asterisks.isEmpty()){
            if(open.pop()>asterisks.pop()) return false;
        }

        return open.size()==0;
    }
}
