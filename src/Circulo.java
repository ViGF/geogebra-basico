public class Circulo extends Figura {
  private double raio;

  Circulo(Vertice centro, Vertice ponto) {
    vertices = new Vertice[2];
    vertices[0] = centro;
    vertices[1] = ponto;
  }

  Circulo(Vertice centro, double raio) {
    vertices = new Vertice[1];
    this.raio = raio;
  }

  public void calcularRaio() {}
  public void calcularDiametro() {}

  @Override
  public void calcularPerimetro(int qtdVerticesPossui) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'calcularPerimetro'");
  }

  @Override
  public double getArea() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getArea'");
  }

  public double getRaio() {
    return this.raio;
  }
}
