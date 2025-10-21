
// Demostración del mecanismo de manejo de excepciones try, catch, finally
public class UsoDeExcepciones {
    public static void main(String args[]) {
        try {
            lanzaExcepcion(); // Llama al método que lanza y maneja una excepción
        } catch (Exception exception) { // Captura la excepción relanzada por lanzaExcepcion
            System.err.println("La excepción se manejo en main");
        }

        noLanzaExcepcion(); // Llama al método que no lanza excepciones
    } // Fin de main

    // Demuestra los bloques try, catch, finally con relanzamiento de excepción
    public static void lanzaExcepcion() throws Exception {
        try { // Intenta ejecutar código que lanza una excepción
            System.out.println("Método lanzaExcepcion");
            throw new Exception(); // Genera una nueva excepción
        } catch (Exception exception) { // Captura la excepción inmediatamente
            System.err.println("La excepción se manejo en el método lanzaExcepcion");
            throw exception; // Vuelve a lanzar la misma excepción para que la maneje otro método
        } finally { // Este bloque siempre se ejecuta, haya o no excepción
            System.err.println("Se ejecuto finally en lanzaExcepcion");
        }
        // Código aquí no se ejecutaría porque la excepción se relanzó en el catch
    } // Fin del método lanzaExcepcion

    // Demuestra el uso de finally cuando no ocurre una excepción
    public static void noLanzaExcepcion() {
        try { // Bloque try que no lanza excepciones
            System.out.println("Método noLanzaExcepcion");
        } catch (Exception exception) { // No se ejecuta porque no hay excepción
            System.err.println(exception);
        } finally { // Siempre se ejecuta, incluso sin excepciones
            System.err.println("Se ejecuto finally en noLanzaExcepcion");
        }

        System.out.println("Fin del método noLanzaException");
    } // Fin del método noLanzaException
} // Fin de la clase UsoDeExcepciones