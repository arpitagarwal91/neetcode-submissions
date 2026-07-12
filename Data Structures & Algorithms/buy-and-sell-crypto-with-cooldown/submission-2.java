class Solution {

    Map<String, Integer> dp = new HashMap<>();

    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }

    public int dfs(int i, boolean buying, int[] prices){
        if(i>=prices.length) return 0;

        if(dp.containsKey(i+"-"+buying)) return dp.get(i+"-"+buying);

        int cooldown = dfs(i+1, buying, prices);
        if(buying){
            int buy = dfs(i+1, false, prices) - prices[i];
            dp.put(i+"-"+buying, Math.max(cooldown, buy));
        }
        else{
            int sell = dfs(i+2, true, prices) + prices[i];
            dp.put(i+"-"+buying, Math.max(cooldown, sell));
        }
        return dp.get(i+"-"+buying);
    }
}
