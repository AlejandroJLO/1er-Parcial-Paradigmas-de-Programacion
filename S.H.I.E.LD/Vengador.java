// Clase intermedia que hereda de Heroe y representa a los Vengadores.
// Además de tener un nombre y estatus, poseen un alias y poderes.
import java.util.ArrayList;

public class Vengador extends Heroe {
    private String alias;
    private ArrayList<String> poderes; // Lista de poderes del vengador

    // Constructor que invoca al constructor de Heroe (super)
    public Vengador(String nombre, String alias, String estatus) {
        super(nombre, estatus);
        this.alias = alias;
        this.poderes = new ArrayList<>();
    }

    // Método para obtener el alias del vengador
    public String getAlias() {
        return alias;
    }

    // Método para agregar poderes a la lista del vengador
    public void agregarPoder(String poder) {
        poderes.add(poder);
    }

    // Método para obtener todos los poderes en formato legible
    public String getPoderes() {
        if (poderes.isEmpty()) return "Sin poderes registrados";
        return String.join(", ", poderes);
    }

    // Sobreescritura del método mostrarInfo para incluir alias y poderes
    @Override
    public void mostrarInfo() {
        System.out.println("----------------------------------------");
        System.out.println("VENGADOR => " + getAlias() + " (" + getNombre() + ")");
        System.out.println("Estatus: " + getEstatus());
        System.out.println("Poderes: " + getPoderes());
    }
}