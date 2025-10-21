// TryAnidadoException.java
import java.io.*;

public class TryAnidadoException {
    public static void main(String args[]) {
        try {
            int c = args.length; // Números de argumentos
            int a = 10 / c; // Error si c = 0
            System.out.println("valor de a = " + a);

            try {
                if (c == 1)
                    a = a / (c - 1); // División por cero si c = 1
                if (c == 2) {
                    int[] b = {100, 5}; // Array con 2 elementos
                    b[3] = 0; // Índice fuera de límites
                }
            } catch (ArrayIndexOutOfBoundsException e) { // Catch específico anidado
                System.out.println("Segunda excepción. Indice fuera de límites ==> " + e);
            } catch (Exception e) { // Catch genérico anidado
                System.out.println("Excepción GENERICA... " + e);
            }
        } catch (ArithmeticException e) { // Catch específico exterior
            System.out.println("Primera excepción. División por cero:: " + e);
        }
    } // El fin de main
}