// Clase base que representa a un héroe perteneciente a SHIELD
// Sirve como superclase para todos los demás tipos de héroes

public class Heroe {

    // Atributos encapsulados (acceso privado para mayor seguridad)

    private String nombre;   // Nombre real del héroe
    private String estatus;  // Estado actual (Activo, En misión, Retirado)

    // Constructor que inicializa el nombre y estatus del héroe
    public Heroe(String nombre, String estatus) {
        this.nombre = nombre;
        this.estatus = estatus;
    }

    // Getter para obtener el nombre real
    public String getNombre() {
        return nombre;
    }

    // Getter para obtener el estatus
    public String getEstatus() {
        return estatus;
    }

    // Setter para modificar el estatus del héroe
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    // Método genérico que muestra la información básica de un héroe
    // Este método será sobrescrito en las subclases para añadir más detalles
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " | Estatus: " + estatus);
    }
}
