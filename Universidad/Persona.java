// Importamos la clase Date para manejar fechas de nacimiento
import java.util.Date;

// Clase Persona, la cual será la superclase de Estudiante
public class Persona {
  // Atributos básicos de una persona
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private Date fechaNacimiento;

  // Constructor que inicializa una persona con sus datos
  public Persona(String nombre, String apellidoPaterno,
    String apellidoMaterno, Date fechaNacimiento) {
   this.nombre = nombre;
   this.apellidoPaterno = apellidoPaterno;
   this.apellidoMaterno = apellidoMaterno;
   this.fechaNacimiento = fechaNacimiento;
  }

  // Métodos para obtener los valores de cada atributo
  public String obtenerNombre() {
   return nombre;
  }

  public String obtenerApellidoPaterno() {
   return apellidoPaterno;
  }

  public String obtenerApellidoMaterno() {
   return apellidoMaterno;
  }

  // Método que une nombre y apellidos en una sola cadena
  public String obtenerNombreCompleto() {
   return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
  }

  // Devuelve la fecha de nacimiento
  public Date obtenerFechaNacimiento() {
   return fechaNacimiento;
  }
}
