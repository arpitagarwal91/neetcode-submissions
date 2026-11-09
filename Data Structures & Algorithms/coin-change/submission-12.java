class Solution {
    public int coinChange(int[] coins, int amount) {
        int res = getMinCoins(coins.length-1, coins, amount);
        return res==1_000_000_000? -1: res;
    }

    private int getMinCoins(int idx, int coins[], int target){
        if(idx==0){
            if(target==0) return 0;
            if(target%coins[0]==0) return target/coins[0];
            return 1_000_000_000;
        }

        int notTake = getMinCoins(idx-1, coins, target);
        int take = 1_000_000_000;
        if(coins[idx]<=target){
            take = 1 + getMinCoins(idx, coins, target-coins[idx]);
        }
        return Math.min(take, notTake);
    }
}
