package figuras;

public class Circulo extends Figura {
  private double raio;
  private double diametro;

  // Construtor:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public Circulo(Vertice centro, Vertice ponto) {
    super(2, 2);
    vertices = new Vertice[2];
    vertices[0] = centro;
    vertices[1] = ponto;
  }

  public Circulo(Vertice centro, double raio) {
    super(2, 1);
    vertices = new Vertice[1];
    vertices[0] = centro;
    this.raio = raio;
  }

  public void calcularRaio() {
    // Se houver dois pontos o raio é à distância do centro até o ponto.
    if (vertices.length == 2) {
      raio = vertices[0].distancia(vertices[1]);
    }
  }

  public void calcularDiametro() {
    diametro = getRaio() * 2;
  }

  // Getters de
  // Circulo:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public double getRaio() {
    calcularRaio();
    return raio;
  }

  public double getDiametro() {
    calcularDiametro();
    return diametro;
  }

  // Comum:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  @Override
  public void calcularArea() {
    // pi * r²
    area = (Math.PI * Math.pow(getRaio(), 2));
  }

  @Override
  public void calcularPerimetro() {
    // 2pi * r
    perimetro = (2 * Math.PI * getRaio());
  }
}
