

package com.data.structure.avltree;

import javax.swing.JOptionPane;


public class TreeAVL {
private NodoAVL root;

    public TreeAVL() {
        this.root = null;
    }

    public NodoAVL getRoot(){
        return root;
    }

   public boolean search(int key,NodoAVL p){
        if (p == null) {
            return false;                  //false    
        }
        if(key == p.getDato()){
            return true;                  //true 
        }else if(key < p.getDato()) {
            return search(key, p.getLeft());
        }else{
            return search(key,p.getRight());
        }
        
    }

   //obtener f equilibrio
public int getBalancingFactor(NodoAVL x){
    if(x==null){
        return -1;
    }else{
        return x.getBalancingFactor();
    }
}

//rotacion a la izquierda
public NodoAVL rotacionIzquierda(NodoAVL c){
    NodoAVL auxiliar=c.getLeft();  
    c.setLeft(auxiliar.getRight());
    auxiliar.setRight(c);
    c.setBalancingFactor(Math.max(getBalancingFactor(c.getLeft()), getBalancingFactor(c.getRight()))+1);  //obtiene el maximo
    auxiliar.setBalancingFactor(Math.max(getBalancingFactor(auxiliar.getLeft()), getBalancingFactor(auxiliar.getRight()))+1);
    return auxiliar;
}

//rotacion derecha
public NodoAVL rotacionDerecha(NodoAVL c){
    NodoAVL auxiliar=c.getRight();
    c.setRight(auxiliar.getLeft());   
    auxiliar.setLeft(c);
    c.setBalancingFactor(Math.max(getBalancingFactor(c.getLeft()), getBalancingFactor(c.getRight()))+1);  //obtiene el maximo
    auxiliar.setBalancingFactor(Math.max(getBalancingFactor(auxiliar.getLeft()), getBalancingFactor(auxiliar.getRight()))+1);
    return auxiliar;
}


//insertar 
public NodoAVL insertarAVL(NodoAVL nuevo, NodoAVL subAr){
    NodoAVL nuevoPadre=subAr;
    if(nuevo.getDato()<subAr.getDato()){
        if(subAr.getLeft()==null){
            subAr.setLeft(nuevo);           
        }else{
            subAr.setLeft(insertarAVL(nuevo, subAr.getLeft()));                                   
            if((getBalancingFactor(subAr.getLeft())-getBalancingFactor(subAr.getRight())==2)){
                if(nuevo.getDato()<subAr.getLeft().getDato()){
                    nuevoPadre=rotacionIzquierda(subAr);
                }
            }
        }
    }else if(nuevo.getDato()>subAr.getDato()){
        if(subAr.getRight()==null){
            subAr.setRight(nuevo);
        }else{
            subAr.setRight(insertarAVL(nuevo, subAr.getRight()));
            if((getBalancingFactor(subAr.getRight())-getBalancingFactor(subAr.getLeft())==2)){
                if(nuevo.getDato()>subAr.getRight().getDato()){
                    nuevoPadre=rotacionDerecha(subAr);
                }
            }
        }
    }else{
        JOptionPane.showMessageDialog(null, "Nodo duplicado  "+nuevo.getDato());
    }

    if((subAr.getLeft()==null)&&(subAr.getRight()!=null)){
        subAr.setBalancingFactor(subAr.getRight().getBalancingFactor()+1);
    }else if((subAr.getRight()==null)&&(subAr.getLeft()!=null)){
        subAr.setBalancingFactor(subAr.getLeft().getBalancingFactor()+1);
    }else{
        subAr.setBalancingFactor(Math.max(getBalancingFactor(subAr.getLeft()), getBalancingFactor(subAr.getRight()))+1);
    }
    return nuevoPadre;
}


//insertar normal
public void insertar(int d){
   NodoAVL nuevo= new NodoAVL(d);
   if(root==null){
       root=nuevo;
   }else{
       root=insertarAVL(nuevo, root);
   }
}

//recorridos
    public void inOrden(NodoAVL r){
        if(r!=null){
            inOrden(r.getLeft());
            System.out.print(" "+r.getDato());
            inOrden(r.getRight());
        }
    }
 
    public void preorden(NodoAVL r){
        if(r!=null){
            System.out.print(" "+r.getDato());
            preorden(r.getLeft());
            preorden(r.getRight());
        }
    }
    public void postOrden(NodoAVL r){
         if(r!=null){
            postOrden(r.getLeft());
            postOrden(r.getRight());
            System.out.print(" "+r.getDato());
        }
    }
   public boolean estaVacio(){
        return root==null;
    }
}
