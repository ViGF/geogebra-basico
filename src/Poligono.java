public class Poligono extends Figura {
  private int qtdMaxVertices;
  private int qtdVerticesPossui = 0;

  public Poligono(int qtdMaxVertices) {
    // Para construir um objeto polígono é necessário informar a quantidade de
    // vértices com o
    // intuito de alocar a memória para eles.
    vertices = new Vertice[qtdMaxVertices];
    this.qtdMaxVertices = qtdMaxVertices;
  }

  public boolean addVertice(Vertice v) {
    for (int i = 0; i < qtdMaxVertices; i++) {
      if (vertices[i] != null) {
        if (vertices[i].equals(v))
          return false; // Retorna falso se o vertice já existir.
      } else {
        // Se a posição for nula (vazia), significa que o o iterador chegou ao fim dos
        // vértices já armazenados na lista.
        vertices[i] = v;
        qtdVerticesPossui += 1;
        return true;
      }
    }
    return true;
  }

  public boolean alterarVertice(int numeroVertice, double x, double y) {
    if (numeroVertice > 0 && numeroVertice <= qtdVerticesPossui) {
      vertices[numeroVertice - 1].move(x, y);

      return true;
    }

    return false;
  }

  public Vertice[] getVertices() {
    return vertices;
  }

  public int getMaxQtdVertices() {
    return qtdMaxVertices;
  }

  public int getQtdVerticesPossui() {
    return this.qtdVerticesPossui;
  }
}
