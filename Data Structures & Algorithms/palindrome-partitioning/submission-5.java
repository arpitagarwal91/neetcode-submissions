class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        getAllPalStrings(0, s, new ArrayList<>(), res);
        return res;
    }

    private void getAllPalStrings(int idx, String s, List<String> ls, List<List<String>> res){
        if(idx==s.length()){
            res.add(new ArrayList<>(ls));
            return;
        }

        for(int i=idx;i<s.length();i++){
            String str = s.substring(idx, i+1);
            if(isPali(str)){
                ls.add(str);
                getAllPalStrings(i+1, s, ls, res);
                ls.remove(ls.size()-1);
            }
        }
    }

    private boolean isPali(String str){
        int l = 0, r = str.length()-1;
        while(l<r){
            if(str.charAt(l)==str.charAt(r)){
                l++;
                r--;
            }
            else return false;
        }
        return true;
    }
}
