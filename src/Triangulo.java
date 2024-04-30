public class Triangulo extends Figura {
  public Triangulo(Vertice vertice1, Vertice vertice2, Vertice vertice3) {
    super.vertices = new Vertice[3];
    super.vertices[0] = vertice1;
    super.vertices[1] = vertice2;
    super.vertices[2] = vertice3;
  }

  private double calcularSegmento(Vertice vert_a, Vertice vert_b) {
    return vert_a.distancia(vert_b);
  }

  private double getSegmento_1() {
    return this.calcularSegmento(super.vertices[0], super.vertices[1]);
  }

  private double getSegmento_2() {
    return this.calcularSegmento(super.vertices[1], super.vertices[2]);
  }

  private double getSegmento_3() {
    return this.calcularSegmento(super.vertices[2], super.vertices[0]);
  }

  public boolean formaTriangulo() {
    return (getSegmento_1() < getSegmento_2() + getSegmento_3())
        && (getSegmento_2() < getSegmento_1() + getSegmento_3())
        && (getSegmento_3() < getSegmento_1() + getSegmento_2());
  }

  public String tipo() {
    if ((getSegmento_1() == getSegmento_2()) && (getSegmento_2() == getSegmento_3())) {
      return "Triângulo Equilátero";
    } else if (
      (getSegmento_1() == getSegmento_2()) ||
      (getSegmento_1() == getSegmento_3()) ||
      (getSegmento_2() == getSegmento_3())
    ) {
      return "Triângulo Isósceles";
    } else {
      return "Triângulo Escaleno";
    }
  }

  public double getArea() {
    double semiP = (getSegmento_1() + getSegmento_2() + getSegmento_3()) / 2;

    double area = Math.sqrt(semiP * (semiP - getSegmento_1()) * (semiP - getSegmento_2()) * (semiP - getSegmento_3()));

    return area;
  }
}
