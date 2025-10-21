// Ejemplo de manejo de excepciones que verifica la división entre cero
import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionEntreCeroConManejoDeExcepciones {
    // Método que calcula el cociente y puede lanzar ArithmeticException
    public static int cociente(int numerador, int denominador) throws ArithmeticException {
        return numerador / denominador; // Posible división entre cero
    } // Fin del método cociente

    public static void main(String args[]) {
        Scanner explorador = new Scanner(System.in); // Objeto Scanner para entrada de datos
        boolean continuarCiclo = true; // Controla si se necesitan más intentos de entrada

        do {
            try { // Bloque try para leer entrada y calcular
                System.out.print("Introduzca un numerador entero: ");
                int numerador = explorador.nextInt(); // Lee numerador puede lanzar InputMismatchException
                
                System.out.print("Introduzca un denominador entero: ");
                int denominador = explorador.nextInt(); // Lee denominador

                int resultado = cociente(numerador, denominador); // Calcula cociente puede lanzar ArithmeticException
                
                System.out.printf("\nResultado: %d / %d = %d\n", numerador, denominador, resultado);
                continuarCiclo = false; // Entrada exitosa; termina el ciclo
            } catch (InputMismatchException inputMismatchException) { // Captura entrada no válida
                System.err.printf("\nExcepcion: %s\n", inputMismatchException);
                explorador.nextLine(); // Descarta entrada incorrecta para nuevo intento
                System.out.println("Debe introducir enteros. Intente de nuevo.\n");
            } catch (ArithmeticException arithmeticException) { // Captura división por cero
                System.err.printf("\nExcepcion: %s\n", arithmeticException);
                System.out.println("Cero es un denominador invalido. Intente de nuevo.\n");
            }
        } while (continuarCiclo); // Continúa hasta entrada válida
        
        explorador.close(); // Cierra el scanner (buena práctica)
    } // Fin de main
} // Fin de la clase DivisionEntreCeroConManejoDeExcepciones