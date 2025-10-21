// PruebaFinally.java
class PruebaFinally {
    // Método que lanza excepción
    static void metodo1() {
        try {
            System.out.println("en el metodo1");
            throw new RuntimeException("metodo1"); // Lanza excepción
        } finally { // Bloque finally siempre se ejecuta
            System.out.println("finally del metodo1"); // Se ejecuta incluso con excepción
        }
    }

    // Método que ejecuta return en try
    static void metodo2() {
        try {
            System.out.println("en el metodo2");
            return; // Sale del método
        } finally { // Bloque finally se ejecuta antes del return
            System.out.println("finally del metodo2");
        }
    }

    // Método con ejecución normal en try
    static void metodo3() {
        try {
            System.out.println("en el metodo3"); // Ejecución normal
        } finally { // Finally se ejecuta siempre
            System.out.println("finally del metodo3");
        }
    }

    public static void main(String args[]) {
        try {
            metodo1(); // Llama método que lanza excepción
        } catch (Exception e) { // Captura la excepción lanzada por metodo1
            System.out.println("Excepcion capturada");
        }
        metodo2(); // Llama método con return
        metodo3(); // Llama método normal
    } // fin main
}