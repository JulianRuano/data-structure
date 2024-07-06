package com.data.structure.avltree;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadArchive {

    public static void main(String[] args) {
        String instruction=" ";
        int elemento;

        File f = new File("test_avl.txt");
       
        try  (Scanner input = new Scanner(f)) {
            TreeAVL arbin = new TreeAVL();
            while ((instruction.equals("salir")) != true)
            { 
                instruction = input.next(); //se lee la instruction
                System.out.print(instruction);
                
                switch(instruction)
                {        
                    case "insertar":
                        elemento = input.nextInt();
                        arbin.insertar(elemento);
                        System.out.print(" "+elemento)
                        ;break;
                    case "buscar":    
                        elemento = input.nextInt();
                        System.out.print(" "+elemento+" "+arbin.search(elemento, arbin.getRoot()));                    
                        ;break;
                    case "eliminar": 
                        //implementar 
                        ;break;
                    case "preorden": 
                         arbin.preorden(arbin.getRoot());
                        ;break;
                    case "inorden":
                         arbin.inOrden(arbin.getRoot()); 
                        ;break;
                    case "postorden": 
                          arbin.postOrden(arbin.getRoot());
                        ;break;
                    case "salir": 
                        ;break;
                    default: System.out.print("Instrucción desconocida"); break;      
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