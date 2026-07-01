public class Solution {

    public string Encode(IList<string> strs) {
       StringBuilder sb = new StringBuilder();
       foreach(string str in strs){
        sb.Append(str.Count());
        sb.Append('#');
        sb.Append(str);
       } 
       return sb.ToString();
    }

    public List<string> Decode(string s) {
        int lenStart = 0;
        List<string> res = new();
        while(lenStart<s.Count()){
            int lenEnd = lenStart+1;
            while(s[lenEnd]!='#') lenEnd++;
            int len = Int32.Parse(s.Substring(lenStart, lenEnd-lenStart));
            res.Add(s.Substring(lenEnd+1, len));
            lenStart = lenEnd+len+1;
        }
        return res;
   }
}
