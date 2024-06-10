package figuras;

public class Poligono extends Figura {
  // Construtor:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public Poligono(int qtdMaxVertices) {
    super(qtdMaxVertices, 0);
    vertices = new Vertice[qtdMaxVertices];
  }

  // Metodos de
  // poligono:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public boolean addVertice(Vertice v) {
    for (int i = 0; i < this.qtdMaxVertices; i++) {
      if (vertices[i] != null) {
        if (vertices[i].equals(v)) {
          return false; // Retorna falso se o vertice ja existir.
        }
      } else {
        // Se a posicao for nula (vazia), significa que o o iterador chegou ao fim dos
        // vertices ja armazenados na lista.
        this.vertices[i] = v;
        this.qtdPossuiVertices += 1;
        System.out.println(this.qtdPossuiVertices);
        return true;
      }
    }
    // System.out.println("Checkpoint: qtd - " + qtdMaxVertices +
    // qtdPossuiVertices);
    return true;
  }

  public boolean alterarVertice(int numeroVertice, double x, double y) {
    if (numeroVertice > 0 && numeroVertice <= qtdPossuiVertices) {
      vertices[numeroVertice - 1].move(x, y);

      return true;
    }

    return false;
  }

  public boolean pontoEstaNoPoligono(Vertice vertice) {
    // Pelo metodo de Raycasting, ao projetar uma reta horizontal de qualquer lado
    // atravessando um poligono ate o ponto especificado, e possivel descobrir se
    // o ponto esta dentro do poligono atraves do numero de vezes que essa reta
    // atravessou uma aresta desse poligono.
    // Se a reta atravessou um numero impar de vezes, entao o ponto esta dentro do
    // poligono
    // Se a reta atravessou um numero par de vezes ele esta fora
    // As condicoes necessaria sao a coordenada Y estar dentro dos limites do
    // poligono
    // A segunda condicao e dada pela formula Xp < X1 + (Yp - Y1)/(Y2 - Y1) * (X2 -
    // X1)
    // e e responsavel por dar o resultado de quantas vezes a reta atravessou as
    // arestas no
    // sentido horizontal.

    int contador = 0;
    for (int i = 0; i < qtdPossuiVertices - 1; i++) {
      if (((vertice.getY() < vertices[i].getY()) != (vertice.getY() < vertices[i + 1].getY()))
          && (vertice.getX() < (vertices[i].getX()
              + ((vertice.getY() - vertices[i].getY()) / (vertices[i + 1].getY() - vertices[i].getY()))
                  * (vertices[i + 1].getX() - vertices[i].getX())))) {
        contador++;
      }
    }
    // Conecta o ultimo vertice de volta ao primeiro
    if (((vertice.getY() < vertices[qtdPossuiVertices - 1].getY()) != (vertice.getY() < vertices[0].getY())) && (vertice
        .getX() < (vertices[qtdPossuiVertices - 1].getX() + ((vertice.getY() - vertices[qtdPossuiVertices - 1].getY())
            / (vertices[0].getY() - vertices[qtdPossuiVertices - 1].getY()))
            * (vertices[0].getX() - vertices[qtdPossuiVertices - 1].getX())))) {
      contador++;
    }
    return contador % 2 == 1;
  }

  // Comum:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  @Override
  public void calcularArea() {
    // Para calcular a area usa-se o determinante
    // A = 1/2 * ((X1 * Y2) - (Y1 * X2) + (X2 * Y3) - (Y2 * X3)......)
    // E necessario que a ordem dos vertices seja anti-horario, mas nos testes
    // nao houve nenhuma diferenca
    double area = 0;
    for (int i = 0; i < qtdPossuiVertices - 1; i++) {
      area += ((vertices[i].getX() * vertices[i + 1].getY()) + (vertices[i].getY() * vertices[i + 1].getX()) * -1);
    }

    area += ((vertices[qtdPossuiVertices - 1].getX() * vertices[0].getY())
        + (vertices[qtdPossuiVertices - 1].getY() * vertices[0].getX()) * -1);
    area = area / 2;

    // Nao existe area negativa
    if (area < 1)
      area = area * -1;
    this.area = area;
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
