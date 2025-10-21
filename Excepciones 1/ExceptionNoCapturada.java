// ExceptionNoCapturada.java
class ExceptionNoCapturada {
    public static void main(String args[]) {
        int a = 0;
        int b = 10 / a; // Aquí hay un erro de división por cero
        //La excepción no es capturada
        // El programa se detendrá aquí con ArithmeticException
    }
}