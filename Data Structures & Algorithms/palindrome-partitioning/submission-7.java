class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        getAllPalPartitions(0, s, new ArrayList<>(), res);
        return res;
    }

    private void getAllPalPartitions(int idx, String s, List<String> ls, List<List<String>> res){
        if(idx==s.length()){
            res.add(new ArrayList<>(ls));
            return;
        }

        for(int i=idx;i<s.length();i++){
            String str = s.substring(idx, i+1);
            if(isPali(str)){
                ls.add(str);
                getAllPalPartitions(i+1, s, ls, res);
                ls.remove(ls.size()-1);
            }
        }
    }

    private boolean isPali(String s){
        int l = 0, r = s.length()-1;
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }
            else return false;
        }
        return true;
    }
}
