 //Clase de prueba para demostrar el uso de la referencia 'this'

public class PruebaThis {
    public static void main(String[] args) {
        //Crear un objeto TiempoSimple
        TiempoSimple tiempo = new TiempoSimple(15, 30, 19);
        //Mostrar el String creado que demuestra el uso de "this"
        System.err.println(tiempo.crearString());
    }
}


//Clase que demuestra el uso de la referencia 'this' para acceder a miembros de la clase

class TiempoSimple {
    private int hora;    //Hora del día
    private int minuto;  //Minuto de la hora
    private int segundo; //Segundo del minuto


    //Constructor que inicializa TiempoSimple
    //Hora valor de la hora (0-23)
    //Minuto valor del minuto (0-59)
    //Segundo valor del segundo (0-59)

    public TiempoSimple(int hora, int minuto, int segundo) {
        //El uso explícito de "this" para distinguir variables de instancia de parámetros
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }


     //Crea un String que muestra el uso de 'this'
     //String  que compara las llamadas con y sin 'this'

    public String crearString() {
        return String.format("%24s: %s%n%24s: %s",
            "this.aStringUniversal()", this.aStringUniversal(),
            "aStringUniversal()", aStringUniversal());
    }

    
    //Devuelve la hora en formato universal de 24 Horas
    //String con formato HH:MM:SS

    public String aStringUniversal() {
        //El uso de 'this' para acceder a miembros (Opcional en este momento)
        return String.format("%02d:%02d:%02d",
            this.hora, this.minuto, this.segundo);
    }
}