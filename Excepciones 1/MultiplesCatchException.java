class MultiplesCatchException {
    public static void main(String args[]) {
        int a;
        int b[];
        int c = args.length; // Número de argumentos de línea de comandos
        
        try {
            a = 10 / c; // Error si no hay argumentos validos (c = 0)
            System.out.println("Valor de a = " + a);
            b = new int[5];
            
            for (int i = 0; i < a; i++) { // Si c = 1, a = 10, genera ArrayIndexOutOfBounds
                b[i] = i;
                System.out.print("\t" + i);
            }
        } catch (ArithmeticException e) { // Catch específico para la división por cero
            System.out.println("Primera excepción. División por cero:: " + e);
        } catch (ArrayIndexOutOfBoundsException e) { // Catch específico para los índices
            System.out.println("Segunda excepción. Indice fuera de límites => " + e);
        } catch (Exception e) { // Catch genérico para cualquier otra excepción
            System.out.println("Excepción GENERICA... " + e);
        }
    } // El Fn de main
}