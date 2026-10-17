class Solution {
    private final String arr[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0) return res;
        backtrack(0, digits, new StringBuilder(), res);
        return res;
    }

    private void backtrack(int idx, String digits, StringBuilder sb, List<String> res){
        if(idx==digits.length()){
            res.add(sb.toString());
            return;
        }
        int num = digits.charAt(idx) - '0';
        for(char c:arr[num].toCharArray()){
            sb.append(c);
            backtrack(idx+1, digits, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
