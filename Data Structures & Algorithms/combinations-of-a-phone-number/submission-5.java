class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0) return res;
        backtrack(0, digits, new StringBuilder(), res);
        return res;
    }
    private final String arr[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    private void backtrack(int idx, String digits, StringBuilder sb, List<String> res){
        if(idx==digits.length()){
            res.add(sb.toString());
            return;
        }
        String str = arr[digits.charAt(idx) - '0'];
        for(char c:str.toCharArray()){
            sb.append(c);
            backtrack(idx+1, digits, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
