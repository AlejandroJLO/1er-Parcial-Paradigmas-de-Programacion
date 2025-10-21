public class PruebaTiempo2 {
    public static void main(String[] args) {
        // Creación de objetos para ser usados con diferentes constructores
        Tiempo2 t1 = new Tiempo2();        //00:00:00 (Constructor sin argumentos)
        Tiempo2 t2 = new Tiempo2(2);  //02:00:00 (Constructor con solo hora)
        Tiempo2 t3 = new Tiempo2(21, 34); //21:34:00 (Constructor con hora y minuto)
        Tiempo2 t4 = new Tiempo2(12, 25, 42); // 12:25:42 (Constructor completo)
        Tiempo2 t5 = new Tiempo2(t4);  // 12:25:42 (Constructor copia, este constructor no existe en la clase original)
        
        //Mostrar los tiempos creados
        System.out.println("Se construyo con:");
        mostrarTiempo("t1: todos los argumentos predeterminados", t1);
        mostrarTiempo("t2: se especifico hora; minuto y segundo predeterminados", t2);
        mostrarTiempo("t3: se especificaron hora y minuto; segundo predeterminado", t3);
        mostrarTiempo("t4: se especificaron hora, minuto y segundo", t4);
        mostrarTiempo("t5: se especifico el objeto Tiempo2 llamado t4", t5);
        
        //La prueba de manejo para excepciones con valores inválidos
        try {
            Tiempo2 t6 = new Tiempo2(27, 74, 99); // Valores inválidos
        } catch (IllegalArgumentException e) {
            System.out.printf("%nExcepcion al inicializar t6: %s%n", e.getMessage());
        }
    }
    
    
    //Método auxiliar para mostrar un objeto Tiempo2 en ambos formato. Encabezado Texto descriptivo del tiempo
    //t Objeto Tiempo2 a mostrar

    private static void mostrarTiempo(String encabezado, Tiempo2 t) {
        System.out.printf("%s%n %s%n %s%n", 
            encabezado, 
            t.aStringUniversal(),  // Formato 24h
            t.toString());        // Formato 12h
    }
}