class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int prices[] = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for(int i=0;i<k+1;i++){
            int tmp[] = Arrays.copyOfRange(prices, 0, n);
            for(int ele[]:flights){
                if(prices[ele[0]]==Integer.MAX_VALUE) continue;
                if(prices[ele[0]]+ele[2] < tmp[ele[1]]) {
                    tmp[ele[1]] = prices[ele[0]] + ele[2];
                }
            }
            prices = tmp;
        }

        return prices[dst]==Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
