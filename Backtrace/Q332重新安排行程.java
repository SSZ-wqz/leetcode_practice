package Backtrace;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Q332重新安排行程 {

    private final Map<String, PriorityQueue<String>> map = new HashMap<>();
    private final LinkedList<String> resList = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            if (!map.containsKey(src)) {
                PriorityQueue<String> pq = new PriorityQueue<>();
                map.put(src, pq);
            }
            map.get(src).add(dst);
        }
        dfs("JFK");
        return resList;
    }

    private void dfs(String src) {
        if (src == null) {
            return;
        }
        PriorityQueue<String> pq = map.get(src);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }
        resList.addFirst(src);
    }

}
