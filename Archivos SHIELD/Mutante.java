// Clase que hereda de Vengador
// Representa a un mutante con un poder principal definido en su construcción

public class Mutante extends Vengador {
    private String poderPrincipal; // Poder característico del mutante

    // Constructor: además de los atributos del vengador, se define un poder principal.
    public Mutante(String nombre, String alias, String poder, String estatus) {
        super(nombre, alias, estatus);
        this.poderPrincipal = poder;
        agregarPoder(poder); // Registramos automáticamente el poder principal
    }

    // Sobreescribimos mostrarInfo para detallar mejor al mutante
    @Override
    
    public void mostrarInfo() {
        System.out.println("=== Mutante ===");
        System.out.println("Alias: " + getAlias());
        System.out.println("Nombre real: " + getNombre());
        System.out.println("Poder principal: " + poderPrincipal);
        System.out.println("Estatus: " + getEstatus());
        System.out.println("Poderes: " + getPoderes());
        System.out.println("-----------------------------");
    }
}
