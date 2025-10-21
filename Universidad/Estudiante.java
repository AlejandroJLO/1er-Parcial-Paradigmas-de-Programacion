// Importamos la clase Date para manejar fechas
import java.util.Date;
// Importamos DecimalFormat para formatear decimales (ej. 3.333 → 3.33)
import java.text.DecimalFormat;

// Declaramos la clase Estudiante, que hereda de la clase Persona
public class Estudiante extends Persona {
    // Atributos específicos del estudiante
    private String id;               // Identificador único del estudiante
    private double promCalif;        // Promedio de calificaciones
    private String carrera;          // Carrera en la que estudia
    private String grado;            // Nivel académico: Licenciatura, Master o Ph.D
    private int añoGraduacion;       // Año en que se graduará

    // Constructor que inicializa un objeto Estudiante con los datos recibidos
    public Estudiante(String nombre, String apellidoPaterno, String apellidoMaterno,
                      Date fechaNacimiento, String id, String carrera, String grado, int añoGraduacion) {
        // Llamamos al constructor de la clase Persona (superclase)
        super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
        // Inicializamos los atributos específicos del Estudiante
        this.id = id;
        this.carrera = carrera;
        this.grado = grado;
        this.añoGraduacion = añoGraduacion;
        this.promCalif = 0.0; // Por defecto, el promedio empieza en 0.0
    }

    // Métodos Accesores (Getters) para obtener valores de los atributos
    public String obtenerId() { return id; }
    public double obtenerPromedio() { return promCalif; }
    public String obtenerCarrera() { return carrera; }
    public String obtenerGrado() { return grado; }
    public int obtenerAñoGraduacion() { return añoGraduacion; }

    // Método para cambiar la carrera del estudiante
    public void cambiarCarrera(String nuevaCarrera) {
        this.carrera = nuevaCarrera;
    }

    // Método para calcular el promedio de calificaciones a partir de un arreglo
    public void calcularPromedio(int n, String[] califs) {
        // Validamos si el número de calificaciones es válido
        if (n <= 0 || califs == null) {
            this.promCalif = 0.0;
            return; // Terminamos la función si no hay calificaciones válidas
        }

        double suma = 0.0; // Variable para acumular los puntos
        // Recorremos el arreglo de calificaciones
        for (int i = 0; i < n && i < califs.length; i++) {
            // Convertimos la calificación a mayúscula y sin espacios
            String c = califs[i].trim().toUpperCase();
            double puntos; // Guardará el valor numérico de la calificación
            // Asignamos puntos según la calificación
            switch (c) {
                case "A":  puntos = 4.00; break;
                case "A-": puntos = 3.67; break;
                case "B+": puntos = 3.33; break;
                case "B":  puntos = 3.00; break;
                case "B-": puntos = 2.67; break;
                case "C+": puntos = 2.33; break;
                case "C":  puntos = 2.00; break;
                case "D":  puntos = 1.00; break;
                case "F":  puntos = 0.00; break;
                default:   puntos = 0.00; // Si no coincide, se asigna 0
            }
            // Sumamos los puntos de cada calificación
            suma += puntos;
        }
        // Calculamos el promedio dividiendo la suma entre el número de calificaciones
        this.promCalif = (n > 0) ? (suma / n) : 0.0;
    }

    // Método que devuelve en forma de texto toda la información del estudiante
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##"); // Para mostrar decimales con dos cifras
        return "Nombre: " + obtenerNombreCompleto() +
               "\nFecha de Nacimiento: " + obtenerFechaNacimiento() +
               "\nID: " + id +
               "\nPromedio: " + df.format(promCalif) +
               "\nCarrera: " + carrera +
               "\nGrado: " + grado +
               "\nAño de Graduación: " + añoGraduacion;
    }
}
