public class EmpleadoPorComision extends Empleado {
    private double ventasBrutas;
    private double tarifaComision;

    public EmpleadoPorComision(String primerNombre, String apellidoPaterno,
                               String numeroSeguroSocial, double ventasBrutas, double tarifaComision) {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);

        if (ventasBrutas < 0.0 || tarifaComision <= 0.0 || tarifaComision >= 1.0)
            throw new IllegalArgumentException("Datos de comisión inválidos.");

        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
    }

    public void incrementarVentas(double monto) {
        ventasBrutas += monto;
    }

    @Override
    public double obtenerMontoPago() {
        return ventasBrutas * tarifaComision;
    }

    @Override
    public String toString() {
        return String.format("Empleado por comisión: %s%nVentas brutas: $%.2f; Tarifa de comisión: %.2f",
                super.toString(), ventasBrutas, tarifaComision);
    }
}
