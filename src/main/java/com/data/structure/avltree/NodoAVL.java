package com.data.structure.avltree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NodoAVL {

    private int dato;
    private int  balancingFactor ;
    private NodoAVL left;
    private NodoAVL right;

    public NodoAVL(int d) {
        this.dato = d;
        this.balancingFactor = 0;
        this.left = null;
        this.right = null;
    }

}
