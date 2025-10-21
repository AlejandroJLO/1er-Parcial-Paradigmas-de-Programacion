// Importamos Scanner para leer datos del usuario
import java.util.Scanner;
// Importamos SimpleDateFormat y ParseException para trabajar con fechas
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

// Clase de prueba para crear y manejar objetos Estudiante
public class PruebaEstudiante {
    public static void main(String[] args) {
        // Creamos el objeto Scanner para leer entradas del teclado
        Scanner sc = new Scanner(System.in);
        try {
            // Solicitamos los datos básicos del estudiante
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Apellido Paterno: ");
            String apellidoP = sc.nextLine();
            System.out.print("Apellido Materno: ");
            String apellidoM = sc.nextLine();
            System.out.print("Fecha de Nacimiento (Día-Mes-Año): ");
            String fechaStr = sc.nextLine();
            
            // Convertimos la cadena de fecha a un objeto Date
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date fecha = sdf.parse(fechaStr);

            // Solicitamos datos adicionales
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Carrera: ");
            String carrera = sc.nextLine();
            System.out.print("Grado (Licenciatura/Master/Ph.D): ");
            String grado = sc.nextLine();
            System.out.print("Año de Graduación Esperado: ");
            int año = Integer.parseInt(sc.nextLine());

            // Creamos un objeto Estudiante con los datos proporcionados
            Estudiante est = new Estudiante(nombre, apellidoP, apellidoM, fecha, id, carrera, grado, año);

            // Pedimos el número de calificaciones a ingresar
            System.out.print("Número de Calificaciones: ");
            int n = Integer.parseInt(sc.nextLine());
            String[] califs = new String[n];
            
            // Guardamos cada calificación en el arreglo
            for (int i = 0; i < n; i++) {
                System.out.print("Calificación " + (i+1) + " (A, A-, B+, B, B-, C+, C, D, F): ");
                califs[i] = sc.nextLine();
            }

            // Calculamos el promedio del estudiante
            est.calcularPromedio(n, califs);

            // Mostramos los datos del estudiante
            System.out.println("\n─♦─ Datos del Estudiante ─♦─");
            System.out.println(est.toString());

            // Preguntamos si desea cambiar de carrera
            System.out.print("\n¿Desea Cambiar de Carrera? (Si/No): ");
            String resp = sc.nextLine().trim().toLowerCase();
            if (resp.equals("si") || resp.equals("sí")) {
                System.out.print("Nueva Carrera: ");
                String nueva = sc.nextLine();
                est.cambiarCarrera(nueva);
                System.out.println("Carrera cambiada a: " + est.obtenerCarrera());
            }

            // Mensaje de cierre
            System.out.println("\nFin del programa.");
        } catch (ParseException e) {
            // Si la fecha no tiene el formato correcto
            System.out.println("Fecha con Formato Incorrecto. Use Dia-Mes-Año.");
        } catch (NumberFormatException e) {
            // Si se introduce un número inválido
            System.out.println("Entrada Numérica Inválida!");
        } finally {
            // Cerramos el scanner
            sc.close();
        }
    }
}
