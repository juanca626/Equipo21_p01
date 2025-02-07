/**
 * El programa nos ayuda a identificar el caracter mas repetido en un archivo de texto
 * Tambien muestra el tiempo de ejecucion del programa
 * @author Fernádez Morales Juan Carlos
 * @author Echeverría Verduzco Jesús
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class charFrequency {    

    /**
     * Inicia el contador de ms para medir el tiempo de ejecucion del programa
     * Inicia la lectura del documeto
     * 3 opciones ("random_text_100k", "random_text_200k", "random_text_800k")
     * @param args 
     */
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        String archivo = "random_text_100k.txt"; //nombre del archivo
        String cadena = "";

        /**
         * Lee el archivo y en caso de no poderlo leer manda un mensaje de error
         * Al no encontrarlo cierra el programa e imprime el mensaje
         */
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            cadena = br.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        int n = cadena.length();
        int umbral = n / 3;
        char[] caracteres = cadena.toCharArray();
        boolean[] contados = new boolean[256];

        /**
         * Empieza a contar los caracteres
         */
        for (int i = 0; i < n; i++) {
            char actual = caracteres[i];
        if (contados[actual]) continue;

        int contador = 0;
        for (int j = 0; j < n; j++) {
            if (caracteres[j] == actual) {
                contador++;
            }
        }

            /*
             * Verifica si un caracter supera el umbral
             * tambien mide y muestra el tiempo de ejecución
             */
            if (contador >= umbral) {  
                long fin = System.currentTimeMillis();
                System.out.println("El caracter mas repetido es '" + actual + "' y aparece " + contador + " veces");
                System.out.println("El programa tarda: "+ (fin-inicio)+ " ms");
                return;
            }
        }
        System.out.println("Ningun caracter cumple la condicion");
    }
}