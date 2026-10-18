class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int l = 0, r = 0;
        while(r<str.length()){
            while(str.charAt(r)!='#') r++;
            int len = Integer.parseInt(str.substring(l,r));
            l = r+1;
            String word = str.substring(l, l+len);
            res.add(word);
            r = l+len;
            l = r;
        }
        return res;
    }
}
