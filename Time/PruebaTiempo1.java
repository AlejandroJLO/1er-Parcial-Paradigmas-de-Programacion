//Case de prueba para demostrar el uso de la clase Tiempo1

public class PruebaTiempo1 {
    public static void main(String[] args) {
        //Crear un objeto Tiempo1
        Tiempo1 tiempo = new Tiempo1();
        mostrarTiempo("Después de crear el objeto tiempo", tiempo);
        System.out.println();

        //Establecer un tiempo válido
        tiempo.establecerTiempo(13, 27, 6);
        mostrarTiempo("Después de llamar a establecerTiempo", tiempo);
        System.out.println();

        //Intentar establecer un tiempo inválido (A excepciones)
        try {
            tiempo.establecerTiempo(99, 99, 99);
        } catch (IllegalArgumentException e) {
            System.out.printf("Exception: %s%n%n", e.getMessage());
        }

        //Mostrar el tiempo después del intento fallido
        mostrarTiempo("Después de llamar a establecerTiempo con valores invalidos", tiempo);
    }

    
     //Método auxiliar para mostrar el tiempo en ambos formatos
     //Encabezado texto descriptivo para la salida
     //t objeto Tiempo1 a mostrar

    private static void mostrarTiempo(String encabezado, Tiempo1 t) {
        System.out.printf("%s%nTiempo universal: %s%nTiempo estandar: %s%n",
            encabezado, t.aStringUniversal(), t.toString());
    }
}