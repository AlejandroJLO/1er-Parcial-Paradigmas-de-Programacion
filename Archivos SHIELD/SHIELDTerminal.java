import java.util.ArrayList;         // Lista dinámica para almacenar héroes
import java.util.Scanner;           // Lectura de entrada por consola
import java.text.Normalizer;        // Para eliminar acentos de los textos
import java.util.Locale;            // Para operaciones consistentes de minúsculas

// Clase principal que simula la terminal de SHIELD
// Permite listar héroes y filtrarlos por estatus con entradas flexibles del usuario

public class SHIELDTerminal {

    // keyOf: Convierte un texto en una "llave" comparable
    // - Elimina acentos 
    // - Pone todo en minúsculas
    // - Elimina espacios, guiones y caracteres no alfabéticos
    // - Mapea variantes comunes a llaves estables (ejemplo:"enmision" y "mision")

    private static String keyOf(String s) {
        if (s == null) return ""; 
        // Evita NPE; devuelve cadena vacía si es nulo
        // Normaliza y elimina acentos o otros dialectos

        String noAccents = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        // Pasa a minúsculas de forma independiente del idioma

        String lower = noAccents.toLowerCase(Locale.ROOT);
        // Quita todo lo que no sea letra (espacios, guiones, etc.)

        String compact = lower.replaceAll("[^a-z]", "");
        // Normaliza sinónimos/variantes a llaves estándar
        
        if (compact.equals("mision") || compact.equals("enmision")) return "enmision";
        if (compact.startsWith("activo")) return "activo";
        if (compact.startsWith("retirad")) return "retirado"; // cubre retirado/retirada
        return compact; // devuelve lo que haya quedado si no coincide con nada anterior
    }

    // canonicalStatus: recibe lo que escribió el usuario y devuelve el estatus canónico
    // Devuelve null si no reconoce el estatus

    private static String canonicalStatus(String userInput) {
        String key = keyOf(userInput); // Genera la llave de comparación
        switch (key) {
            case "enmision": return "En misión"; // Acepta "Mision" o "En Mision"
            case "activo":   return "Activo";
            case "retirado": return "Retirado";  // También cubre "Retirada"
            default:         return null;        // No reconocido
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crea el lector de consola

        ArrayList<Heroe> heroes = new ArrayList<>(); // Lista polimórfica de los héroes

        // ===== Registro de héroes precargados (Estatus Canónicos) =====

        // Vengadores clásicos
        Vengador ironman = new Vengador("Tony Stark", "Iron Man", "Activo"); // Crea Iron Man
        ironman.agregarPoder("Armadura tecnológica");    // Agrega poder 1
        ironman.agregarPoder("Inteligencia superior");   // Agrega poder 2

        Vengador spiderman = new Vengador("Peter Parker", "Spider-Man", "Activo"); // Crea Spider-Man
        spiderman.agregarPoder("Sentido arácnido");      // Poder 1
        spiderman.agregarPoder("Fuerza sobrehumana");    // Poder 2
        spiderman.agregarPoder("Trepar muros");          // Poder 3

        Vengador moonKnight = new Vengador("Marc Spector", "Moon Knight", "En misión"); // Crea Moon Knight
        moonKnight.agregarPoder("Fuerza aumentada por Khonshu"); // Poder 1
        moonKnight.agregarPoder("Experto en artes marciales");   // Poder 2

        Vengador daredevil = new Vengador("Matt Murdock", "Daredevil", "Activo"); // Crea Daredevil
        daredevil.agregarPoder("Sentidos aumentados");               // Poder 1
        daredevil.agregarPoder("Experto en combate cuerpo a cuerpo");// Poder 2

        Vengador namor = new Vengador("Namor McKenzie", "Namor", "Retirado"); // Crea Namor
        namor.agregarPoder("Respiración acuática");   // Poder 1
        namor.agregarPoder("Fuerza sobrehumana");     // Poder 2
        namor.agregarPoder("Vuelo");                  // Poder 3

        // Mutantes
        Mutante wolverine = new Mutante("Logan", "Wolverine", "Regeneración", "En misión"); // Crea Wolverine
        wolverine.agregarPoder("Garras de adamantium"); // Poder adicional

        Mutante phoenix = new Mutante("Jean Grey", "Phoenix", "Telepatía", "Retirado"); // Estandardizado a "Retirado"

        // Guardianes de la Galaxia
        Guardian starlord = new Guardian("Peter Quill", "Star-Lord", "Terra", "Activo"); // Crea Star-Lord
        starlord.agregarPoder("Armas avanzadas"); // Poder

        Guardian rocket = new Guardian("Rocket Raccoon", "Rocket", "Halfworld", "En misión"); // Crea Rocket
        rocket.agregarPoder("Estratega militar"); // Poder 1
        rocket.agregarPoder("Experto en explosivos"); // Poder 2

        // Agrega todos los héroes a la lista polimórfica
        heroes.add(ironman);
        heroes.add(spiderman);
        heroes.add(moonKnight);
        heroes.add(daredevil);
        heroes.add(namor);
        heroes.add(wolverine);
        heroes.add(phoenix);
        heroes.add(starlord);
        heroes.add(rocket);

        // ===== Menú interactivo =====
        int opcion; // Guarda la opción elegida por el usuario
        do {
            // Muestra el menú principal
            System.out.println("\n=┼= Terminal de S.H.I.E.L.D =┼=");
            System.out.println("1-) Ver todos los héroes");
            System.out.println("2-) Filtrar por estatus:"); // Nota: "Mision" sin acento funciona
            System.out.println("3-) Salir");
            System.out.print("Seleccione una opción: ");

            // Valida que el usuario ingrese un número entero
            while (!scanner.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                scanner.next(); // Descarta la entrada inválida
            }
            opcion = scanner.nextInt(); // Lee la opción
            scanner.nextLine();         // Limpia el buffer de fin de línea

            switch (opcion) {
                case 1:
                    // Opción 1: mostrar toda la lista de héroes
                    System.out.println("\n-■- Lista completa de héroes -■-\n");
                    for (Heroe h : heroes) { // Recorre cada héroe (polimorfismo)
                        h.mostrarInfo();     // Llama al mostrarInfo específico de la clase real
                        System.out.println(); // Línea en blanco para mejor legibilidad
                    }
                    break;

                case 2:
                    // Opción 2: filtrar por estatus
                    System.out.print("Estatus a filtrar (Activo | Mision | Retirado): ");
                    String entrada = scanner.nextLine();     // Lee lo que escribió el usuario
                    String canon = canonicalStatus(entrada); // Convierte a estatus canónico

                    if (canon == null) { // Si no se reconoció el estatus, muestra ayuda
                        System.out.println("Estatus no reconocido. Usa: Activo, Mision o Retirado.");
                        break; // Vuelve al menú
                    }

                    String targetKey = keyOf(canon); // Llave comparativa del estatus buscado
                    System.out.println("\n-®- Héroes con estatus -®-'" + canon + "' ---\n");

                    boolean alguno = false; // Bandera para saber si hubo resultados
                    for (Heroe h : heroes) { // Recorre la lista
                        // Compara usando llaves normalizadas (robusto ante acentos y mayúsculas)
                        if (keyOf(h.getEstatus()).equals(targetKey)) {
                            h.mostrarInfo(); // Muestra el héroe
                            System.out.println(); // Espacio entre registros
                            alguno = true;    // Marca que al menos uno coincidió
                        }
                    }

                    if (!alguno) { // Si no encontró héroes, informa al usuario
                        System.out.println("(No se encontraron héroes con ese estatus)\n");
                    }
                    break;

                case 3:
                    // Opción 3: salir del programa
                    System.out.println("Saliendo de la terminal...");
                    break;

                default:
                    // Si el usuario ingresó una opción inválida
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 3); // Repite el menú hasta que elija salir

        scanner.close(); // Cierra el lector de consola
    }
}
