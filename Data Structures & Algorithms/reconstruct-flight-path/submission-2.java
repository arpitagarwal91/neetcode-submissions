class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        Collections.sort(tickets, (a,b) -> a.get(1).compareTo(b.get(1)));
        for(List<String> ticket:tickets){
            adj.computeIfAbsent(ticket.get(0), k->new ArrayList<>()).add(ticket.get(1));
        }

        List<String> res = new ArrayList<>();
        res.add("JFK");
        dfs("JFK", adj, res, tickets.size());
        return res;
    }

    private boolean dfs(String src, Map<String, List<String>> adj, List<String> res, int n){
        if(res.size()==n+1) return true;
        if(!adj.containsKey(src)) return false;
        List<String> dests = new ArrayList(adj.get(src));
        for(int i=0;i<dests.size();i++){
            res.add(dests.get(i));
            adj.get(src).remove(i);
            if(dfs(dests.get(i), adj, res, n)) return true;
            res.remove(res.size()-1);
            adj.get(src).add(i, dests.get(i));
        }
        return false;
    }
}
