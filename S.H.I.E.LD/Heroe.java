// Clase base que representa a un héroe genérico dentro del universo.
// Sirve como clase padre para Vengador, Mutante, Guardian, etc.
// Implementa los principios de Encapsulamiento y Herencia.
public class Heroe {
    // Atributos privados para proteger los datos (Encapsulamiento)
    private String nombre;
    private String estatus; // Ejemplo: "Activo", "En misión", "Retirado"

    // Constructor que inicializa los atributos del héroe
    public Heroe(String nombre, String estatus) {
        this.nombre = nombre;
        this.estatus = estatus;
    }

    // Métodos Getters (permiten acceder a los atributos)
    public String getNombre() {
        return nombre;
    }

    public String getEstatus() {
        return estatus;
    }

    // Setter (permite modificar el estatus del héroe)
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    // Método genérico que muestra la información del héroe
    // Este método será sobreescrito por las subclases
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " | Estatus: " + estatus);
    }
}