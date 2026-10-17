class Solution {
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int res[] = new int[num1.length()+num2.length()];
        for(int i=0;i<num1.length();i++){
            for(int j=0;j<num2.length();j++){
                res[i+j] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                res[i+j+1] += res[i+j]/10;
                res[i+j] = res[i+j]%10;
            }
        }
        int k = res.length-1;
        while(k>=0 && res[k]==0) k--;
        StringBuilder sb = new StringBuilder();
        while(k>=0) sb.append(res[k--]);
        return sb.length()==0 ? "0" : sb.toString();
    }
}
