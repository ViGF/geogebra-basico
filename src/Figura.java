public class Figura {
  protected double perimetro;
  protected Vertice[] vertices;

  public double getPerimetro() {
    return perimetro;
  }

  public void calcularPerimetro(int qtdVerticesPossui) {
    // Para calcular o perímetro é necessário saber qual a distância entre cada
    // vértice ao próximo,
    // e qual a distância entre o último ao primeiro, já que eles se ligam para
    // formar o polígono.
    
    double perimetro = 0;
    for (int i = 0; i + 1 < qtdVerticesPossui; i++) {
      perimetro += vertices[i].distancia(vertices[i + 1]);
    }
    perimetro += vertices[0].distancia(vertices[qtdVerticesPossui - 1]);
    this.perimetro = perimetro;
  }
}
