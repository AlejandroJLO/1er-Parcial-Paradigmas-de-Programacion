public class Tiempo2 {
    private int hora;    //0-23(Almacena la hora en formato 24h)
    private int minuto;  //0-59 (Almacena los minutos)
    private int segundo; //0-59 (Almacena los segundos)

    
    //Constructor sin argumentos. Inicializa el tiempo a 00:00:00 llamando al constructor con tres parámetros.

    public Tiempo2() {
        this(0, 0, 0); //Invoca al constructor principal con todos los valores en cero
    }

    
     //Constructor con solo la hora y la hora se establece (0-23)
     //Inicializa los minutos y segundos a 0

    public Tiempo2(int hora) {
        this(hora, 0, 0); // Invoca al constructor principal con minutos y segundos en cero
    }

    
    //Constructor con hora y minutos.
    //La hora a establecer (0-23)
    //Los minutos a establecer (0-59)
    //Inicializa segundos a 0.

    public Tiempo2(int hora, int minuto) {
        this(hora, minuto, 0); // Invoca al constructor principal con segundos en cero
    }

    
    //Constructor principal con hora, minutos y segundos.
    //La hora a establecer (0-23)
    //MiLos minutos a establecer (0-59)
    //Los segundos a establecer (0-59)
    //IllegalArgumentException en caso de algún parámetro está fuera de rango

    public Tiempo2(int hora, int minuto, int segundo) {
        // Validación de parámetros
        if (hora < 0 || hora >= 24)
            throw new IllegalArgumentException("hora debe estar entre 0 y 23");
        
        if (minuto < 0 || minuto >= 60)
            throw new IllegalArgumentException("minuto debe estar entre 0 y 59");
        
        if (segundo < 0 || segundo >= 60)
            throw new IllegalArgumentException("segundo debe estar entre 0 y 59");
        
        //La asignación de valores si son válidos
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    
     //Obtiene la hora actual
     //la hora (0-23)

    public int obtenerHora() {
        return hora;
    }

    //Obtiene los minutos actuales.
    //Los minutos (0-59)

    public int obtenerMinuto() {
        return minuto;
    }

    //los segundos actuales.
    //Los segundos (0-59)

    public int obtenerSegundo() {
        return segundo;
    }

    
    //Convierte el tiempo a formato universal (HH:MM:SS).
    //El String con el tiempo en formato 24h

    public String aStringUniversal() {
        return String.format("%02d:%02d:%02d", obtenerHora(), obtenerMinuto(), obtenerSegundo());
    }

    
     //Convierte el tiempo a formato estándar (H:MM:SS AM/PM).
    //String con el tiempo en formato 12h

    public String toString() {
        return String.format("%d:%02d:%02d %s", 
            ((obtenerHora() == 0 || obtenerHora() == 12) ? 12 : obtenerHora() % 12),
            obtenerMinuto(), 
            obtenerSegundo(), 
            (obtenerHora() < 12 ? "AM" : "PM"));
    }
}