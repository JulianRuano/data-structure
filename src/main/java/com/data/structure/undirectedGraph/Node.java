 package com.data.structure.undirectedGraph;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class Node {
    private char data;
    private ArrayList<Edge> adjacent;
  
    
    public Node (char data)
    {
        this.data = data;
        this.adjacent = new ArrayList<Edge>();
    }
    
    public void insertEdge (Edge arista){
        if( !this.adjacent.contains(arista))
            this.adjacent.add(arista);
    }
   
    public Edge getEdge(int indice){
	    return this.adjacent.get(indice);
    }
  
    public int  getCountVertices (){
	    return this.adjacent.size();
    }
      
    public String toString(){
	    return ""+this.data;
    }

}
