
package com.data.structure.binarytree;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a binary tree data structure with various traversal methods.
 * This class includes methods for inserting nodes, searching for nodes, 
 * and deleting nodes.
 * 
 * @autor Julian Ruano
 */

@Getter
@Setter
@NoArgsConstructor
public class BinaryTree {
    
    private Node root;

    /**
     * Inserts a new node with the specified data into the binary tree.
     * 
     * @param d the data to be inserted into the new node
     */
    public void insert(int d)
    {
        Node newNode = new Node(d);

        if(root == null)
        {
            root = newNode;
        }
        else
          {
              Node parent = null;
              Node aux;
              aux = root;
              while (aux != null)
              {
                  parent = aux;
                  if (d < aux.getData())
                      aux = aux.getLeft();
                  else
                      aux = aux.getRight();
              }
              if (d < parent.getData())
                  parent.setLeft(newNode);
              else
                  parent.setRight(newNode);
          }
    } //end insert

    /**
     * Prints the binary tree nodes in pre-order traversal.
     * 
     * @param r the root node from where to start the traversal
     */
    public void printPreorder(Node r)
    {
       if (r != null)
        {
            System.out.print(" "+r.getData());
            printPreorder(r.getLeft());
            printPreorder(r.getRight());
        }

    }

    /**
     * Prints the binary tree nodes in in-order traversal.
     * 
     * @param r the root node from where to start the traversal
     */
    public void printInorder(Node r)
    {
       if (r != null)
        {
            printInorder(r.getLeft());
            System.out.print(" "+r.getData());      
            printInorder(r.getRight());
        }

    }
    
    /**
     * Prints the binary tree nodes in post-order traversal.
     * 
     * @param r the root node from where to start the traversal
     */
    public void printPostorder(Node r)
    {
       if (r != null)
        {
            printPostorder(r.getLeft());      
            printPostorder(r.getRight());
            System.out.print(" "+r.getData());
        }

    }

    /**
     * Searches for a node with the specified key in the binary tree.
     * 
     * @param key the key to search for in the binary tree
     * @param p the root node from where to start the search
     * @return true if the key is found in the binary tree, false otherwise
     */
    public boolean existe(int clave,Node p){
        if (p == null) {
            return false;                  //false    
        }
        if(clave == p.getData()){
            return true;                  //true 
        }else if(clave < p.getData()) {
            return existe(clave, p.getLeft());
        }else{
            return existe(clave,p.getRight());
        }
        
    }


    public String eliminar(int clave, Node p){
        return eliminar(clave, p,p); 
    }

    /**
     * Deletes a node with the specified key from the binary tree.
     * This is a helper method that handles the deletion recursively.
     * 
     * @param clave the key of the node to be deleted
     * @param p the current node being examined
     * @param auxP the parent of the current node being examined
     * @return a message indicating whether the deletion was successful or not
     */
    private  String eliminar(int clave, Node p,Node auxP){      
             
        if (p == null) {
            return "\nNo existe el Nodo con clave: "+clave;  //false    
        }
        if(clave == p.getData()){

            if (p.getLeft() == null && p.getRight() == null) {   // leaf node
                if (auxP.getRight().getData() == clave) {
                    auxP.setRight(null);
                }else{
                    auxP.setLeft(null);
                }
            }
            if (p.getLeft() == null || p.getRight() != null) {  //  Node having a subtree 
                auxP.setRight(p.getRight());
            }else if (p.getLeft() != null || p.getRight() == null){
                auxP.setLeft(p.getLeft());
            }
            if (p.getLeft() != null && p.getRight() != null) { // Node with two Subtree

                Node auxH = p.getLeft();
                while (auxH.getRight() != null) {
                       auxH = auxH.getRight();
                }
                eliminar(auxH.getData(), getRoot());
                p.setData(auxH.getData());                                
            }
            return "\nEliminado correctamente";  
        }else if(clave < p.getData()) {
            return eliminar(clave, p.getLeft(),p);
        }else{
            return eliminar(clave,p.getRight(),p);
        }
        
        
    }
    

    
}
