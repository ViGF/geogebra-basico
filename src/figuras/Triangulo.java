package figuras;

public class Triangulo extends Figura {
  // Construtor:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public Triangulo(Vertice vertice1, Vertice vertice2, Vertice vertice3) {
    super(3, 3);
    vertices = new Vertice[3];
    vertices[0] = vertice1;
    vertices[1] = vertice2;
    vertices[2] = vertice3;
  }

  // Metodos de
  // triangulo:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  private double calcularSegmento(Vertice vert_a, Vertice vert_b) {
    return vert_a.distancia(vert_b);
  }

  public boolean formaTriangulo() {
    return (getSegmento_1() < getSegmento_2() + getSegmento_3())
        && (getSegmento_2() < getSegmento_1() + getSegmento_3())
        && (getSegmento_3() < getSegmento_1() + getSegmento_2());
  }

  public String tipo() {
    if ((getSegmento_1() == getSegmento_2()) && (getSegmento_2() == getSegmento_3())) {
      return "Triangulo Equilatero";
    } else if ((getSegmento_1() == getSegmento_2()) ||
        (getSegmento_1() == getSegmento_3()) ||
        (getSegmento_2() == getSegmento_3())) {
      return "Triangulo Isosceles";
    } else {
      return "Triangulo Escaleno";
    }
  }

  // Getters de
  // triangulo:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  private double getSegmento_1() {
    return this.calcularSegmento(super.vertices[0], super.vertices[1]);
  }

  private double getSegmento_2() {
    return this.calcularSegmento(super.vertices[1], super.vertices[2]);
  }

  private double getSegmento_3() {
    return this.calcularSegmento(super.vertices[2], super.vertices[0]);
  }

  // Comum:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  @Override
  public void calcularArea() {
    double semiP = (getSegmento_1() + getSegmento_2() + getSegmento_3()) / 2;
    area = Math.sqrt(semiP * (semiP - getSegmento_1()) * (semiP - getSegmento_2()) * (semiP - getSegmento_3()));
  }

  @Override
  public void calcularPerimetro() {
    // Para calcular o perimetro e necessario saber qual a distancia entre cada
    // vertice ao proximo,
    // e qual a distancia entre o ultimo ao primeiro, ja que eles se ligam para
    // formar o poligono.
    double perimetro = 0;
    for (int i = 0; i + 1 < qtdPossuiVertices; i++) {
      perimetro += vertices[i].distancia(vertices[i + 1]);
    }
    perimetro += vertices[0].distancia(vertices[qtdPossuiVertices - 1]);
    this.perimetro = perimetro;
  }
}
