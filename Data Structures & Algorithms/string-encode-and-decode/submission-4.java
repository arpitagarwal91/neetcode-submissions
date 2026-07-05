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
        int l = 0, r = 0;
        List<String> res = new ArrayList<>();
        while(r<str.length()){
            while(str.charAt(r)!='#') r++;
            int len = Integer.parseInt(str.substring(l,r));
            res.add(str.substring(r+1, r+len+1));
            l = r+len+1;
            r = l;
        }
        return res;
    }
}
