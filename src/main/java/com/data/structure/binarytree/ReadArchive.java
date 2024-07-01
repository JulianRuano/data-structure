package com.data.structure.binarytree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadArchive {

    public static void main(String[] args) {
        String instruction=" ";
        int element;

        File f = new File("test_julian.txt");
       
        try  (Scanner input = new Scanner(f)) {
            BinaryTree binaryTree = new BinaryTree();
            while ((instruction.equals("salir")) != true)
            { 
                instruction = input.next(); //the instruction is read
                System.out.print(instruction);
                
                switch(instruction)
                {        
                    case "insertar":
                        element = input.nextInt();
                        binaryTree.insert(element);
                        System.out.print(" "+element)
                        ;break;
                    case "buscar":
                        element = input.nextInt();
                        System.out.println(" "+element+" "+binaryTree.existe(element, binaryTree.getRoot()));                       
                        ;break;
                    case "eliminar":
                        element = input.nextInt();
                        System.out.println(" "+element+" "+binaryTree.eliminar(element,binaryTree.getRoot()));           
                        ;break;
                    case "preorden": 
                         binaryTree.printPreorder(binaryTree.getRoot());
                        ;break;
                    case "inorden":
                         binaryTree.printInorder(binaryTree.getRoot()); 
                        ;break;
                    case "postorden": 
                          binaryTree.printPostorder(binaryTree.getRoot());
                        ;break;
                    case "salir": 
                        ;break;
                    default: System.out.print("Instrucción desconocida"); break;      
                }// the switch is closed
                
                System.out.println();
                    
            }//I close the main while

        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}