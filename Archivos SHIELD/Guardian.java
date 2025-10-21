// Clase que hereda de Vengador
// Representa a un guardián galáctico, con un planeta de origen

public class Guardian extends Vengador {
    private String planetaOrigen; // Planeta natal del guardián

    // Constructor: inicializa también el planeta de origen

    public Guardian(String nombre, String alias, String planetaOrigen, String estatus) {
        super(nombre, alias, estatus);
        this.planetaOrigen = planetaOrigen;
    }

    // Sobreescribimos mostrarInfo para incluir el planeta de origen

    @Override
    public void mostrarInfo() {
        System.out.println("=== Guardian de la Galaxia ===");
        System.out.println("Alias: " + getAlias());
        System.out.println("Nombre real: " + getNombre());
        System.out.println("Planeta de origen: " + planetaOrigen);
        System.out.println("Estatus: " + getEstatus());
        if (!getPoderes().isEmpty()) {
            System.out.println("Poderes: " + getPoderes());
        }
        System.out.println("-----------------------------");
    }
}
