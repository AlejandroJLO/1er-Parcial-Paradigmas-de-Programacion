class MultiplesCatch {
    public static void main(String args[]) {
        int a;
        int b[];
        int c = args.length; // Número de argumentos de línea de comandos

        try {
            a = 10 / c; // Error si no hay argumentos (c = 0)
            System.out.println("valor de a = " + a);
            b = new int[5];

            for (int i = 0; i < a; i++) { // Si c = 1, a = 10, genera el ArrayIndexOutOfBounds
                b[i] = i;
                System.out.print("\t" + i);
            }
        } catch (ArithmeticException e) { // Primer catch, el cual es división por cero
            System.out.println("Primera excepción. División por cero:: " + e);
        } catch (ArrayIndexOutOfBoundsException e) { // Segundo catch, el cual es índice fuera de límites
            System.out.println("Segunda excepción. Índice fuera de límites =>" + e);
        }
    }
}