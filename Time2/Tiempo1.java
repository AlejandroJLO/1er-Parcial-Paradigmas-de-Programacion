
 //La clase Tiempo1 mantiene la hora en formato de 24 horas.
 //Proporciona métodos para establecer y mostrar la hora en diferentes formatos.

public class Tiempo1 {
    //Variables de instancia privadas para almacenar la hora
    private int hora;    //Almacena la Hora (0-23)
    private int minuto;  //Almacena los Minutos (0-59)
    private int segundo; //Almacena los Segundos (0-59)

    
     //Establece el tiempo verificando que los valores estén en rangos válidos
     //Hora el valor de la hora (0-23)
     //Minuto el valor de los minutos (0-59)
     //Segundo el valor de los segundos (0-59)
     //IllegalArgumentException si algún parámetro está fuera de rango
     
    public void establecerTiempo(int hora, int minuto, int segundo) {
        //Validación de rangos para hora, minuto y segundo
        if (hora < 0 || hora >= 24 || minuto < 0 || minuto >= 60 || segundo < 0 || segundo >= 60) {
            throw new IllegalArgumentException(
                "hora, minuto y/o segundo estaban fuera de rango");
        }

        //Asignación de valores validados a las variables de la instancia
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

     //Devuelve la Hora en formato universal de 24 Horas (HH:MM:SS) como String
     
    public String aStringUniversal() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    
      //Devuelve la hora en formato estándar de 12 Horas (H:MM:SS) como String
    
    public String toString() {
        return String.format("%d:%02d:%02d %s",
            ((hora == 0 || hora == 12) ? 12 : hora % 12),
            minuto, segundo, (hora < 12 ? "AM" : "PM"));
    }
}