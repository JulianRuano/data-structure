package com.data.structure.binarytree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a node in a binary tree.
 * Each node contains data and references to the left and right child nodes.
 * 
 * @author Julian Ruano
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Node {
   private int data;
   private Node left; 
   private Node right;  

   /**
    * Constructs a node with the specified data.
    * The left and right child nodes are initialized to null.
    *
    * @param d the data to be stored in the node
    */
   public Node(int d) 
    {
        this.data = d;
        this.left = null;
        this.right = null;
    }

}
