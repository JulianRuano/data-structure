package com.data.structure.hashTables;

import java.util.HashMap;

public class HashTables {
 
    public static void main(String[] args) {
        // Crear un HashMap
        // HashMap<Clave, Valor>
        HashMap<String, String> passport = new HashMap<>();

        // Agregar elementos
        passport.put("A1" , "Juan");
        passport.put("A2" , "Pedro");
        passport.put("A3" , "María");

        // Obtener un valor
        System.out.println("El pasaporte A2 pertenece a " + passport.get("A2"));

        // Verificar si existe una clave
        // containsKey() retorna true si la clave existe
        if (passport.containsKey("A2")) {
            System.out.println("El pasaporte A2 existe");
        } else {
            System.out.println("El pasaporte A2 no existe");
        }

        // Imprimir todos los elementos
        // keySet() retorna un conjunto de claves
        for (String code : passport.keySet()) {
            System.out.println(code + " : " + passport.get(code));
        }

        // remove() Eliminar un elemento
        passport.remove("A2");

        // size() Tamaño del HashMap
        System.out.println("Tamaño del HashMap: " + passport.size());

        //Verificar si el HashMap está vacío
        System.out.println("El HashMap está vacío: " + passport.isEmpty());

        // entrySet() retorna un conjunto de pares clave-valor
        for (HashMap.Entry<String, String> entry : passport.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}