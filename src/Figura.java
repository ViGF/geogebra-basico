public abstract class Figura {
  protected double perimetro;
  protected Vertice[] vertices;

  public double getPerimetro() {
    return perimetro;
  }

  public abstract void calcularPerimetro(int qtdVerticesPossui);
  public abstract double getArea();
}
