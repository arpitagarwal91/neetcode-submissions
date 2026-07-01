class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a,b) -> a.get(1).compareTo(b.get(1)));
        Map<String,List<String>> adj = new HashMap();
        for(List<String> ticket:tickets){
            List<String> dests = adj.getOrDefault(ticket.get(0), new ArrayList());
            dests.add(ticket.get(1));
            adj.put(ticket.get(0), dests);
        }
        List<String> res = new ArrayList();
        res.add("JFK");
        dfs("JFK", adj, res, tickets);
        return res;
    }

    public boolean dfs(String src, Map<String,List<String>> adj, List<String> res, List<List<String>> tickets){
        if(res.size()==tickets.size()+1) return true;
        if(!adj.containsKey(src)) return false;
        List<String> dests = new ArrayList(adj.get(src));
        for(int i=0;i<dests.size();i++){
            res.add(dests.get(i));
            adj.get(src).remove(i);
            if(dfs(dests.get(i), adj, res, tickets)) return true;
            res.remove(res.size()-1);
            adj.get(src).add(i, dests.get(i));
        }
        return false;
    }
}
