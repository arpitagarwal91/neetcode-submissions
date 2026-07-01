class Solution {
    String digitToChars[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        if(digits.length()==0) return res;
        backtrack(0,new StringBuilder(),digits,res);
        return res;
    }

    public void backtrack(int i, StringBuilder ls, String digits, List<String> res){
        if(i==digits.length()){
            res.add(ls.toString());
            return;
        }
        String ch = digitToChars[Integer.parseInt(String.valueOf(digits.charAt(i)))];
        for(int j=0;j<ch.length();j++){
            ls.append(ch.charAt(j));
            backtrack(i+1, ls, digits, res);
            ls.deleteCharAt(ls.length()-1);
        }
    }
}
