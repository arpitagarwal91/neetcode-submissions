class Solution {
    public int coinChange(int[] coins, int amount) {
        int res = getMinCoins(0, coins, amount);
        return res==1_000_000_000 ? -1 : res;
    }

    private int getMinCoins(int idx, int coins[], int amount){
        if(idx==coins.length-1){
            if(amount%coins[idx]==0) return amount/coins[idx]; //Again forgot about this base case
            return 1_000_000_000;
        }
        int notTake = getMinCoins(idx+1, coins, amount);

        int take = 1_000_000_000;
        if(coins[idx]<=amount){
            take = 1 + getMinCoins(idx, coins, amount-coins[idx]);
        }
        return Math.min(take, notTake);
    }
}
