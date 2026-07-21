class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String arr[] = path.split("/");

        for(String cur:arr){
            if(cur.equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            }
            else if(!cur.equals("") && !cur.equals(".")) stack.push(cur);
        }

        return "/"+String.join("/", stack);
    }
}