public class PruebaInterfazPorPagar {
    public static void main(String[] args) {

        // Crear los objetos Factura y Empleados
        PorPagar[] objetosPorPagar = new PorPagar[6];

        objetosPorPagar[0] = new Factura("01234", "asiento", 2, 375.00);
        objetosPorPagar[1] = new Factura("56789", "llanta", 4, 79.95);
        objetosPorPagar[2] = new EmpleadoAsalariado("John", "Smith", "111-11-1111", 800.00);
        objetosPorPagar[3] = new EmpleadoPorHoras("Karen", "Price", "222-22-2222", 16.75, 40);
        objetosPorPagar[4] = new EmpleadoPorComision("Sue", "Jones", "333-33-3333", 10000, 0.06);
        objetosPorPagar[5] = new EmpleadoBaseMasComision("Bob", "Lewis", "444-44-4444", 5000, 0.04, 300);

        System.out.println("Facturas y Empleados procesados en forma polimorfica:");

        // Procesar cada objeto en el arreglo
        for (PorPagar porPagarActual : objetosPorPagar) {
            System.out.printf("%n%s %n%s: $%,.2f%n",
                    porPagarActual.toString(),
                    "pago vencido", porPagarActual.obtenerMontoPago());

            // Si es EmpleadoPorComision, incrementar ventas
            if (porPagarActual instanceof EmpleadoPorComision && !(porPagarActual instanceof EmpleadoBaseMasComision)) {
                EmpleadoPorComision empleado = (EmpleadoPorComision) porPagarActual;
                empleado.incrementarVentas(500); // incremento arbitrario por cada factura procesada
                System.out.printf("Ventas incrementadas. Nuevo pago: $%,.2f%n",
                        empleado.obtenerMontoPago());
            }
        }
    }
}
