class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        if(digits.length()==0) return res;
        List<Character> ls = new ArrayList();
        backtrack(0,ls,digits,res);
        return res;
    }

    public void backtrack(int i, List<Character> ls, String digits, List<String> res){
        String arr[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(i==digits.length()){
            StringBuilder sb = new StringBuilder();
            for(Character c:ls) sb.append(c);
            res.add(sb.toString());
            return;
        }
        for(Character c:arr[Integer.parseInt(String.valueOf(digits.charAt(i)))].toCharArray()){
            ls.add(c);
            backtrack(i+1, ls, digits, res);
            ls.remove(ls.size()-1);
        }
    }
}
