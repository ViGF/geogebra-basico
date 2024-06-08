package figuras;

public abstract class Figura implements Comum {
  protected Vertice[] vertices;
  protected int qtdMaxVertices;
  protected int qtdPossuiVertices;
  protected double perimetro;
  protected double area;

  Figura(int qtdMaxVertices, int qtdPossuiVertices) {
    this.qtdMaxVertices = qtdMaxVertices;
    this.qtdPossuiVertices = qtdPossuiVertices;
  }

  // Getters

  public int getQtdMaxVertices() {
    return qtdMaxVertices;
  };

  public int getQtdPossuiVertices() {
    return qtdPossuiVertices;
  };

  public double getArea() {
    calcularArea();
    return area;
  }

  public double getPerimetro() {
    calcularPerimetro();
    return perimetro;
  }
}
