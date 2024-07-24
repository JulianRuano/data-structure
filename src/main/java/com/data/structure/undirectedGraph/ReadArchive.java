package com.data.structure.undirectedGraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadArchive {

        public static void main(String[] args) {
        String instruction=" ";
        char element;
        ArrayList<Node> listNodes = new ArrayList<Node>();
        ArrayList<Node> nodeA = new ArrayList<Node>();
        char weight;
        
                

        File f = new File("test_undirectedGraph.txt");
       
        try  (Scanner input = new Scanner(f)) {
            Graph objGraph = new Graph();
            while ((instruction.equals("fin")) != true)
            { 
                instruction = input.next(); //se lee la instruction                
                
                switch(instruction)
                {        
                    case "nodo":
                        element = input.next().charAt(0);
                        Node objNodo = new Node(element);
                        listNodes.add(objNodo);
                        System.out.print("Insertado nodo "+element);
                        ;break;
                    case "arista": 
                        System.out.print("Insertada arista ");                                           
                        element = input.next().charAt(0); 
                        boolean flag;
                        nodeA.clear();
                        System.out.print(" "+element);
                        
                        for (int j = 0; j < 2; j++) {
                            flag = false;
                            for (int i = 0; i < listNodes.size(); i++) {
                                if (element == listNodes.get(i).getData() ) {                                    
                                    nodeA.add(listNodes.get(i));                                                                    
                                    flag = true;    
                                    i = listNodes.size();                                                                                                                                      
                                }                                  
                            }  
                            if(flag == false){                               
                                Node objNodo1 = new Node(element);
                                listNodes.add(objNodo1);
                                nodeA.add(objNodo1);                                                                
                            } 
                            if (nodeA.size() < 2)
                               element = input.next().charAt(0);
                        }
                        weight = input.next().charAt(0);
                        System.out.print(" "+element+" "+weight);                        
                        objGraph.insertEdge(nodeA.get(0), nodeA.get(1),weight);                            
                        ;break;                      
                    case "imprimir":
                        for (int i = 0; i < listNodes.size(); i++) {
                            if ( listNodes.get(i). getCountVertices () == 0 ) {
                                System.out.print(listNodes.get(i).getData()+" :");
                            }else{
                                System.out.print(listNodes.get(i).getData()+" :");
                                for (int j = 0; j < listNodes.get(i). getCountVertices (); j++) {
                                     System.out.print(listNodes.get(i).getEdge(j).imprimir(listNodes.get(i)));
                                }
                            }  
                            System.out.println("");
                        }                         
                        ;break;
                    case "matriz":
                        
                        char matriz[][] = new char[listNodes.size()+1][listNodes.size()+1];
                        System.out.print(" ");                       
                        for (int i = 0; i < listNodes.size(); i++) {                           
                                for (int j = 0; j < listNodes.size(); j++) {
                                    if (i==0) {                                       
                                        matriz[i][j+1] = listNodes.get(j).getData();}   // para llenar la matriz con los datos de los nodos                              
                                    else if(j==0){
                                        matriz[i][j] = listNodes.get(i-1).getData();}
                                    else{ 
                                        for (int k = 0; k < listNodes.get(i-1). getCountVertices (); k++) { // recorremos los vertices                                                                                                                                                
                                            if (matriz[0][j] == listNodes.get(i-1).getEdge(k).tochar(listNodes.get(i-1))){ //Sacamos solo el vertice al que esta asociado
                                                 matriz[i][j] = listNodes.get(i-1).getEdge(k).getWeight(); 
                                                 k = 9999; // Para salir del for 
                                            }
                                            else{
                                              matriz[i][j] = '0';
                                            }   
                                        }                                                                                        
                                    } 
                                    System.out.print("  "+matriz[i][j]);
                                }                                  
                                System.out.println(" ");
                            } 
                                 
                        
                        ;break;
                    case "fin": ;break;
                    default: 
                       
                        System.out.print("Instrucción desconocida"); break;      
                }// se cierra el switch
                
                System.out.println();
                    
            }//cierro el while principal

        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }                        
}
