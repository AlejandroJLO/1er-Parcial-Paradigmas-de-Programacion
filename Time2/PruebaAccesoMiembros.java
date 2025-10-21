
//Esta clase demuestra que los miembros privados de Tiempo1 no son accesibles directamente.
//El código no compilará debido a las violaciones de encapsulamiento.
 
public class PruebaAccesoMiembros {
    public static void main(String[] args) {
        Tiempo1 tiempo = new Tiempo1();
        //Estas líneas causarán errores de compilación porque los miembros son privados
        //Esto debe ser arreglado en un futuro
        tiempo.hora = 7;       // Error: Hora tiene acceso privado en Tiempo1
        tiempo.minuto = 15;    // Error: Minuto tiene acceso privado en Tiempo1
        tiempo.segundo = 30;   // Error: Segundo tiene acceso privado en Tiempo1
    }
}