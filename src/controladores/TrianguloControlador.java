package controladores;

import figuras.Triangulo;
import figuras.Vertice;

public class TrianguloControlador extends Controlador {
  private Triangulo t;

  // Construtor:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public TrianguloControlador() {
    super("triângulo");
  }

  // Criador do objeto:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public void criarTriangulo() {
    Vertice[] vertices = new Vertice[3];

    // Força o usuário a criar um triângulo válido
    bannerFigura("Criando Triangulo");
    for (;;) {
      for (int i = 0; i < vertices.length; i++) {
        Vertice novoVertice = Vertice.pedirVertice(i + 1, scDouble);
        vertices[i] = novoVertice;
        System.out.println("Vertice criado com sucesso!");
      }

      t = new Triangulo(vertices[0], vertices[1], vertices[2]);
      if (t.formaTriangulo()) {
        figuraCriada = true;
        System.out.print("\033[H\033[2J");
        separador();
        System.out.println("Triangulo criado com sucesso!");
        return; // Encerra o laço
      } else {
        System.out.println("Erro - Os vertices não formam um triangulo!");
        System.out.println("Adicione novamente!");
      }
    }
  }

  // Métodos de triãngulo:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public void tipo() {
    if (figuraCriada) {
      System.out.println(t.tipo());
    } else {
      msgFiguraInexistente();
    }
  }

  // Comum:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  @Override
  public void area() {
    if (figuraCriada) {
      System.out.format("Area: %.2f\n", t.getArea());
    } else {
      msgFiguraInexistente();
    }
  }

  @Override
  public void perimetro() {
    if (figuraCriada) {
      System.out.format("Perimetro: %.2f\n", t.getPerimetro());
    } else {
      msgFiguraInexistente();
    }
  }
}
