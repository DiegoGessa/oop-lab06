package it.unibo.generics.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    private final Map <N, Set<N>> myGraph;
    
    GraphImpl(){
        this.myGraph = new LinkedHashMap<>();
    }

    @Override
    public void addNode(N node) {
        if(node != null){
        this.myGraph.putIfAbsent(node, new HashSet<N>());
    }
}

    @Override
    public void addEdge(N source, N target) {
        if(source != null && target != null){
            addNode(source);
            addNode(target);
            this.myGraph.get(source).add(target);
    }
        
    }

    @Override
    public Set<N> nodeSet() {
        return myGraph.keySet();
    }

    @Override
    public Set<N> linkedNodes(N node) {
        if(myGraph.containsKey(node)){
        return myGraph.get(node);
        }
        return Collections.emptySet();
    }

    @Override
    public List<N> getPath(N source, N target) {
        if(source == null || target == null){
            return Collections.emptyList();
        }
        Queue<N> myQueue = new LinkedList<>();
        Map<N, N> parentMap = new HashMap<>();
        Set<N> visitedSet = new HashSet<>();

        myQueue.add(source);
        visitedSet.add(source);


        while(!myQueue.isEmpty()){
            N current = myQueue.poll();
            if(current.equals(target)){
                return path(parentMap, target);
        }
        for(N neighbor : myGraph.get(current)){
            if(!visitedSet.contains(neighbor)){
                visitedSet.add(neighbor);
                parentMap.put(neighbor, current);
                myQueue.add(neighbor);
            }
        }
        }
    return Collections.emptyList();
    }

    private List<N> path(Map<N, N> parent, N target){
        List<N> path = new LinkedList<>();
        N current = target;

        while(current != null){
            path.addFirst(current);
         current = parent.get(current);
        }
        return path;
    }
}
