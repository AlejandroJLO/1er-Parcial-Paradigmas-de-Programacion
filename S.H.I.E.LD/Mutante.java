// Subclase de Vengador que representa a un mutante con un poder especial.
// Hereda alias, nombre y estatus del Vengador, y añade su propio poder.
public class Mutante extends Vengador {
    private String poderEspecial;

    public Mutante(String nombre, String alias, String poderEspecial, String estatus) {
        super(nombre, alias, estatus);
        this.poderEspecial = poderEspecial;
        agregarPoder(poderEspecial); // Lo añade automáticamente a su lista de poderes
    }

    // Sobreescritura del método mostrarInfo para mostrar su poder mutante
    @Override
    public void mostrarInfo() {
        System.out.println("----------------------------------------");
        System.out.println("MUTANTE => " + getAlias() + " (" + getNombre() + ")");
        System.out.println("Estatus: " + getEstatus());
        System.out.println("Poder Mutante: " + poderEspecial);
    }
}