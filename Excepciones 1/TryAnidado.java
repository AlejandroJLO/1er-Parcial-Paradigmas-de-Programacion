// TryAnidado.java
class TryAnidado {
    public static void main(String args[]) {
        try { // Primer bloque try (Exterior)
            int c = args.length; // Números de argumentos
            int a = 10 / c; // Error si c = 0 (División por cero)
            System.out.print("a= " + a);
            
            try { // Segundo bloque try (anidado)
                if (c == 1) a = a / (c - 1); // División por cero si c = 1
                if (c == 2) {
                    int[] b = {100, 5}; // Array con 2 elementos (índices 0 y 1)
                    b[3] = 0; // Error de índice 3 fuera de límites
                }
            } catch (ArrayIndexOutOfBoundsException e) { // Catch para el try anidado
                System.out.println("Segunda excepción. Indice fuera de límites => " + e);
            }
        } catch (ArithmeticException e) { // Catch para el try exterior
            System.out.println("Primera excepción. División por cero => " + e);
        }
    } // El fin de main
}