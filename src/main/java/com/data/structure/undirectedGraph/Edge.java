package com.data.structure.undirectedGraph;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Edge {
    private Node node1;
    private Node node2;
    private char weight;
    
    
    public String toString()
    {    
	    return "(" + this.node1 + ", " + this.node2  + ")";
    }

    public String imprimir(Node dato)           
    {    
        if (dato == this.node1) {
            return " "+ this.node2;
        }else{
            return " "+ this.node1;
        }	
    }
    
    public char tochar(Node dato){    
        if (dato == this.node1) {
            return this.node2.getData();
        }else{
            return this.node1.getData();
        }
    }
}
