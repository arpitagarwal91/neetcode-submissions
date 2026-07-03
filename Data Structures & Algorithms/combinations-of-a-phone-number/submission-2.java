class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0 || digits.contains("0") || digits.contains("1")) return res;
        backtrack(0,digits,new ArrayList<Character>(), res);
        return res;
    }

    public void backtrack(int i, String digits, List<Character> ls, List<String> res){
        String arr[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(i==digits.length()){
            StringBuilder sb = new StringBuilder();
            for(Character c:ls) sb.append(c);
            res.add(sb.toString());
            return;
        }
        int val = Integer.parseInt(String.valueOf(digits.charAt(i)));
        System.out.println(val);
        for(char c:arr[val].toCharArray()){
            ls.add(c);
            backtrack(i+1, digits, ls, res);
            ls.remove(ls.size()-1);
        }
    }
}
