class Solution {
    public String convert(String s, int numRows) {
        char arr[][] = new char[numRows][s.length()+10];
        int k = 0;
        int c = 0;
        while(k<s.length()){
            for(int r=0;r<numRows;r++){
                if(k==s.length()) break;
                arr[r][c] = s.charAt(k++);
            }
            c++;
            for(int r=numRows-2;r>0;r--){
                if(k==s.length()) break;
                arr[r][c++] = s.charAt(k++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<s.length();j++){
                char p = arr[i][j];
                if(Character.isLetter(p)||p=='.'||p==',') sb.append(p);
            }
        }
        return sb.toString();
    }
}