// ExceptionCapturada.java
class ExceptionCapturada {
    public static void main(String args[]) {
        int a, b;
        try { // Bloque try para el código pueda generar excepciones
            a = 0;
            b = 10 / a; // Genera ArithmeticException (división por cero)
            System.out.println("Esto ya no se imprime"); // No se ejecuta
        } catch (ArithmeticException objetoExcep) { // Captura la excepción específica
            System.out.println("División por cero" + objetoExcep); // Manejo del error
        }
        System.out.println("Continua el programa ... "); // Ejecución continúa después del catch
    }
}