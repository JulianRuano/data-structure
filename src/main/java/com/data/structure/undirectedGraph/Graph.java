package com.data.structure.undirectedGraph;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
    
    public Graph(){
		this.nodes = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
    }
   
   
    public boolean insertEdge (Node n1, Node n2, char peso)
    {
		if(n1.equals(n2)) //los objetos Nodo son iguales?
			return false;

		Edge arista = new Edge(n1, n2, peso);

		edges.add(arista);
		n1.insertEdge(arista);
		n2.insertEdge(arista);     
		return true;
    }
       
    public boolean  insertVertex (Node nodo){
		Node actual = this.nodes.get(nodo.getData());

		nodes.add(nodo.getData(), actual);
		return true;
    }
    
	public Node getNode(char dato){
		return this.nodes.get(dato);
	}
   
}
