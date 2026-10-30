package it.unibo.generics.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    public Map<N,Set<N>> edges = new HashMap<>(); //tiene traccia dei collegamenti fra i nodi
//Set<N> insiemeNodi = new HashSet<>(); 
 // Adds a node : nothing happens if node is null or already there
public void addNode (N node ){

    if(node!= null){
        edges.putIfAbsent(node, new HashSet<>());   //crea una collezione di nodi
    }

 }
 // Adds an edge : nothing happens if source or target are null
public void addEdge (N source , N target ){
     if(source!= null && target!=null && edges.containsKey(source) && edges.containsKey(target)){
        
        Set<N> values = edges.get(source);
        values.add(target); //associo il nuovo nodo a quello che mi restituisce la f di hash 
    }
}

 // Returns all the node Set <N > nodeSet () ;
public Set <N> nodeSet () {
    return new HashSet<>(edges.keySet());  //ne ritorno una copia
 }


 // Returns all the nodes directly targeted from node
public Set <N> linkedNodes (N node ){
    if(edges.containsKey(node)){
        
    return new HashSet<>(edges.get(node));  //ritorno il valore associato alla key node

    }
    return Collections.emptySet();
}

 // Gets one sequence of nodes connecting source to path
public List <N> getPath (N source , N target ){

    Set<N> visited = new HashSet<>();
   List<N> path = new ArrayList<>();
    if (source != null && target != null && edges.containsKey(source) && edges.containsKey(target)) {
        this.dfs(source, target, path, visited);
    }
    return path;
}

private boolean dfs(N current, N target, List<N> path, Set<N> visited) {
    path.add(current);      // 1. Aggiungo il nodo corrente al cammino
    visited.add(current);   // 2. Lo segno come già visto

    if (current.equals(target)) {
        return true; // 3. Trovato! Fermati!
    }

    // 4. Con la .get() guardo tutti i suoi vicini
    for (N node : edges.get(current)) {
        if (!visited.contains(node)) {
            if (dfs(node, target, path, visited)) {
                return true; // Trovato ciclo, risali!
            }
        }
    }

    // 5. Se da qui era un vicolo cieco, tolgo il nodo dal cammino
    path.remove(path.size() - 1);
    return false;

}



}
