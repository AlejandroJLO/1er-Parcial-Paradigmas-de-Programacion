public class Main {
    public static void main(String[] args) {
        Figura cuadrado = new Cuadrado(4);
        Figura triangulo = new Triangulo(3, 4, 3, 4, 5);
        Figura circulo = new Circulo(5);

        System.out.println("~ Cuadrado:");
        System.out.println("   * Area: " + cuadrado.calcularArea());
        System.out.println("   * Perimetro: " + cuadrado.calcularPerimetro());

        System.out.println("~ Triangulo:");
        System.out.println("   * Area: " + triangulo.calcularArea());
        System.out.println("   * Perimetro: " + triangulo.calcularPerimetro());

        System.out.println("~ Circulo:");
        System.out.println("   * Area: " + circulo.calcularArea());
        System.out.println("   * Perimetro: " + circulo.calcularPerimetro());
    }
}