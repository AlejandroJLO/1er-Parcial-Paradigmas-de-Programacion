public class EmpleadoBaseMasComision extends EmpleadoPorComision {
    private double salarioBase;

    public EmpleadoBaseMasComision(String primerNombre, String apellidoPaterno,
                                   String numeroSeguroSocial, double ventasBrutas,
                                   double tarifaComision, double salarioBase) {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial, ventasBrutas, tarifaComision);

        if (salarioBase < 0.0)
            throw new IllegalArgumentException("El salario base debe ser >= 0.0");

        this.salarioBase = salarioBase;
    }

    public void establecerSalarioBase(double nuevoSalarioBase) {
        if (nuevoSalarioBase < 0.0)
            throw new IllegalArgumentException("El salario base debe ser >= 0.0");

        this.salarioBase = nuevoSalarioBase;
    }

    public double obtenerSalarioBase() {
        return salarioBase;
    }

    @Override
    public double obtenerMontoPago() {
        return super.obtenerMontoPago() + salarioBase;
    }

    @Override
    public String toString() {
        return String.format("Empleado base más comisión: %s%nSalario base: $%.2f",
                super.toString(), salarioBase);
    }
}
