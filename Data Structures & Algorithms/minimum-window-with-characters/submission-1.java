class Solution {
    public String minWindow(String s, String t) {
        if(t.equals("")) return "";
        Map<Character,Integer> src = new HashMap<>();
        for(char c:t.toCharArray()) src.put(c, src.getOrDefault(c,0)+1);
        int need = src.keySet().size();
        int l = 0;
        int r = 0;
        int res = Integer.MAX_VALUE;
        int ans[] = new int[]{-1,-1};
        Map<Character,Integer> dest = new HashMap<>();
        int have = 0;
        while(r<s.length()){
            if(src.containsKey(s.charAt(r))){
                dest.put(s.charAt(r), dest.getOrDefault(s.charAt(r),0)+1);
                if(src.get(s.charAt(r))==dest.get(s.charAt(r))) have++;
                while(have==need) {
                    if(r-l+1<res){
                        res = r-l+1;
                        ans[0] = l;
                        ans[1] = r;
                    }
                    if(src.containsKey(s.charAt(l))){
                        dest.put(s.charAt(l), dest.getOrDefault(s.charAt(l), 0)-1);
                        if(src.get(s.charAt(l))>dest.get(s.charAt(l))) have--;
                    }
                    l++;
                }
            }
            r++;
        }
        return res!=Integer.MAX_VALUE ? s.substring(ans[0],ans[1]+1):"";
    }
}
