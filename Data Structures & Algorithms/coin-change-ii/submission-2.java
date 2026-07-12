class Solution {

    Map<String, Integer> dp = new HashMap<>();

    public int change(int amount, int[] coins) {
        return dfs(0,0,amount,coins);
    }

    public int dfs(int i, int a, int amount, int[] coins){
        if(a==amount) return 1;
        if(i==coins.length) return 0;
        if(a>amount) return 0;
        if(dp.containsKey(i+"-"+a)) return dp.get(i+"-"+a);

        int sum = dfs(i, a+coins[i], amount, coins) + dfs(i+1, a, amount, coins);
        dp.put(i+"-"+a, sum);
        return dp.get(i+"-"+a);
    }

}
