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
            String s = str.substring(r+1, r+1+len);
            res.add(s);
            l = r+1+len;
            r = l;
        }
        return res;
    }
}
