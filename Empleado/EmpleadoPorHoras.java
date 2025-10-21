public class EmpleadoPorHoras extends Empleado {
    private double salarioPorHora;
    private double horas;

    public EmpleadoPorHoras(String primerNombre, String apellidoPaterno, String numeroSeguroSocial,
                            double salarioPorHora, double horas) {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);

        if (salarioPorHora < 0.0 || horas < 0.0 || horas > 168.0)
            throw new IllegalArgumentException("Datos de salario u horas inválidos.");

        this.salarioPorHora = salarioPorHora;
        this.horas = horas;
    }

    @Override
    public double obtenerMontoPago() {
        return (horas <= 40) ? salarioPorHora * horas :
                40 * salarioPorHora + (horas - 40) * salarioPorHora * 1.5;
    }

    @Override
    public String toString() {
        return String.format("Empleado por horas: %s%nSalario por hora: $%.2f; Horas: %.2f",
                super.toString(), salarioPorHora, horas);
    }
}
