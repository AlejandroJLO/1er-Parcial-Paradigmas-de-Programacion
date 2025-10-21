import java.util.ArrayList;

// Clase que hereda de Heroe y añade el concepto de alias y lista de poderes
// Representa a un "Vengador" dentro de SHIELD, aunque también se utiliza como clase base para mutantes y guardianes

public class Vengador extends Heroe {
    private String alias;                 // Alias público del héroe
    private ArrayList<String> poderes;    // Lista dinámica de poderes asociados al héroe

    // Constructor: inicializa el nombre, alias y estatus
    // También crea una lista vacía de poderes

    public Vengador(String nombre, String alias, String estatus) {
        super(nombre, estatus);   // Llamamos al constructor de la superclase Heroe
        this.alias = alias;
        this.poderes = new ArrayList<>();
    }

    // Devuelve el alias del héroe
    public String getAlias() {
        return alias;
    }

    // Agrega un nuevo poder al héroe
    public void agregarPoder(String poder) {
        poderes.add(poder);
    }

    // Devuelve la lista de poderes actuales
    public ArrayList<String> getPoderes() {
        return poderes;
    }

    // Sobreescribimos mostrarInfo para personalizar el despliegue de los Vengadores
    
    @Override
    public void mostrarInfo() {
        System.out.println("=== Vengador ===");
        System.out.println("Alias: " + getAlias());
        System.out.println("Nombre real: " + getNombre());
        System.out.println("Estatus: " + getEstatus());

        // Si el héroe tiene poderes registrados, los mostramos
        if (!poderes.isEmpty()) {
            System.out.println("Poderes: " + poderes);
        }

        // Línea de separación para mejorar la legibilidad
        System.out.println("-----------------------------");
    }
}

