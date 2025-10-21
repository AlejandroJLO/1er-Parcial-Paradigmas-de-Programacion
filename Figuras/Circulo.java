public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double calcularArea() {
        return 3.1416 * radio * radio;
    }

    public double calcularPerimetro() {
        return 2 * 3.1416 * radio;
    }
}
