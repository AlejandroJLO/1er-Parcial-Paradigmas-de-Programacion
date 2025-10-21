// Subclase de Vengador que representa a un Guardián de la Galaxia.
// Añade el atributo planeta de origen además de los heredados.
public class Guardian extends Vengador {
    private String planetaOrigen;

    public Guardian(String nombre, String alias, String planetaOrigen, String estatus) {
        super(nombre, alias, estatus);
        this.planetaOrigen = planetaOrigen;
    }

    // Sobreescritura del método mostrarInfo
    @Override
    public void mostrarInfo() {
        System.out.println("----------------------------------------");
        System.out.println("GUARDIÁN DE LA GALAXIA => " + getAlias() + " (" + getNombre() + ")");
        System.out.println("Planeta: " + planetaOrigen);
        System.out.println("Estatus: " + getEstatus());
        System.out.println("Poderes: " + getPoderes());
    }
}