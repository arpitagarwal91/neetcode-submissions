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
        List<String> res = new ArrayList();
        int lenStart = 0;
        while(lenStart<str.length()){
            int lenEnd = lenStart + 1;
            while(str.charAt(lenEnd) != '#') lenEnd++;
            int len = Integer.parseInt(str.substring(lenStart, lenEnd));
            res.add(str.substring(lenEnd+1, lenEnd + len +1));
            lenStart = lenEnd + len + 1;
        }
        return res;
    }
}
